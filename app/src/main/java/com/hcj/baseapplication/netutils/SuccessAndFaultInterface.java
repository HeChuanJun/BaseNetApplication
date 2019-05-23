package com.hcj.baseapplication.netutils;

import android.app.ProgressDialog;
import android.util.Log;

import com.hcj.baseapplication.bean.BaseBean;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by 眼神 on 2018/3/27.
 * 用于在Http请求开始时，自动显示一个ProgressDialog
 * 在Http请求结束是，关闭ProgressDialog
 * 调用者自己对请求数据进行处理   成功时 通过result是否等于1分别回调onSuccess和onFault，默认处理了401错误转登录。
 * 回调结果为String，需要手动序列化
 */

public class SuccessAndFaultInterface<T> extends DisposableObserver<T>
        implements ProgressCancelListener {
    /**
     * 是否需要显示默认Loading
     */
    private boolean showProgress = true;
    private OnSuccessAndFaultListener mOnSuccessAndFaultListener;

    private ProgressDialog progressDialog;

    /**
     * @param mOnSuccessAndFaultListener 成功回调监听
     */
    public SuccessAndFaultInterface(OnSuccessAndFaultListener mOnSuccessAndFaultListener) {
        this.mOnSuccessAndFaultListener = mOnSuccessAndFaultListener;
    }

    private void showProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.show();
        }
    }


    private void dismissProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.dismiss();
        }
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }


    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onComplete() {
        dismissProgressDialog();
        progressDialog = null;
    }


    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     */
    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof SocketTimeoutException) {
                mOnSuccessAndFaultListener.onFault("请求超时");
            } else if (e instanceof ConnectException) {
                mOnSuccessAndFaultListener.onFault("网络连接超时");
            } else if (e instanceof SSLHandshakeException) {
                mOnSuccessAndFaultListener.onFault("安全证书异常");
            } else if (e instanceof HttpException) {
                int code = ((HttpException) e).code();
                if (code == 504) {
                    mOnSuccessAndFaultListener.onFault("网络异常，请检查您的网络状态");
                } else if (code == 404) {
                    mOnSuccessAndFaultListener.onFault("请求的地址不存在");
                } else {
                    mOnSuccessAndFaultListener.onFault("请求失败");
                }
            } else if (e instanceof UnknownHostException) {
                mOnSuccessAndFaultListener.onFault("域名解析失败");
            } else {
                mOnSuccessAndFaultListener.onFault("error:" + e.getMessage());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            Log.e("OnSuccessAndFaultSub", "error:" + e.getMessage());
            //mOnSuccessAndFaultListener.onFault("error:" + e.getMessage());
            dismissProgressDialog();
            progressDialog = null;

        }
    }

    /**
     * 当result等于1回调给调用者，否则自动显示错误信息，若错误信息为401跳转登录页面。
     * ResponseBody  body = response.body();//获取响应体
     * InputStream inputStream = body.byteStream();//获取输入流
     * byte[] bytes = body.bytes();//获取字节数组
     * String str = body.string();//获取字符串数据
     */
    @Override
    public void onNext(T baseBean) {
        try {
            mOnSuccessAndFaultListener.onData(baseBean);
        } catch (Exception e) {
            e.printStackTrace();
            mOnSuccessAndFaultListener.onFault("数据解析异常！");
        }
    }
    /*@Override
    public void onNext(T body) {
        try {
            final String result = CompressUtils.decompress(body.byteStream());
            Log.e("body", result);
            mOnSuccessAndFaultListener.onData(result);
        } catch (Exception e) {

            e.printStackTrace();
            mOnSuccessAndFaultListener.onFault("数据解析异常！");
        }
    }*/
    /*@Override
    public void onNext(BaseDataBean baseBean) {
        try {
            mOnSuccessAndFaultListener.onData(baseBean);
        } catch (Exception e) {
            e.printStackTrace();
            mOnSuccessAndFaultListener.onFault("数据解析异常！");
        }
    }*/

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isDisposed()) {
            this.dispose();
        }
    }
}
