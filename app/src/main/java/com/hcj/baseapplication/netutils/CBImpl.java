package com.hcj.baseapplication.netutils;

import android.util.Log;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CBImpl<T> implements Callback<T> {

    @Override
    public final void onResponse(final Call<T> originCall, Response<T> response) {
//        Logger.e(" response   :  "+response.errorBody()+"   "+response.message()+"   "+response.code());
        Log.e("LOG_TAG", "响应信息  errorBody " + response.errorBody() + "  message " + response.message() + "  code " + response.code() + "  body  " + response.body());

//        if(response.body() != null){
//            Logger.e(" "+response.body().toString());
//            TLog.e("响应结果   "+response.body().toString());
//        }

        if (response.isSuccessful()) {
            success(response.body());
        } else {
            try {
                error(new AppError(response.code(), response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void success(T t);

    protected void error(AppError error) {

    }

    //    //增加超时重试机制 考虑重写构造方法
    @Override
    public final void onFailure(Call<T> call, Throwable e) {
        if (call.isCanceled()) return;
        if (e instanceof SocketTimeoutException) {
            error(new AppError(AppError.EXCEPTION, AppError.SocketTimeoutException));
        } else if (e instanceof SocketException) {
            error(new AppError(AppError.EXCEPTION, AppError.SocketException));
        } else if (e instanceof ConnectException) {
            error(new AppError(AppError.NETWORK_EXCEPTION, AppError.MESSAGE_BAD_NETWORK));
        } else if (e instanceof UnknownHostException) {
            error(new AppError(AppError.NO_NETWORK, AppError.MESSAGE_NO_NETWORK));
        } else {
            error(new AppError(AppError.EXCEPTION, e.getMessage()));
        }
    }
}
