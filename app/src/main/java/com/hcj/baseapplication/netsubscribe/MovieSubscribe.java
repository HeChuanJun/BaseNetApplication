package com.hcj.baseapplication.netsubscribe;

import com.hcj.baseapplication.bean.BaseBean;
import com.hcj.baseapplication.bean.BaseDataBean;
import com.hcj.baseapplication.netapi.HttpApi;
import com.hcj.baseapplication.netutils.HttpMethods;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by 眼神 on 2018/3/27.
 * 建议：把功能模块来分别存放不同的请求方法，比如登录注册类LoginSubscribe、电影类MovieSubscribe
 */

public class MovieSubscribe {
    /**
     * 获取数据
     */
    public static void getData(int pageNumber, int userId, DisposableObserver<ResponseBody> subscriber) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", pageNumber);
        map.put("count", userId);
        Observable<ResponseBody> observable = HttpMethods.getInstance().getHttpApi().getDataForMap(map);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    /**
     * 获取数据
     */
    public static void getVersionInfo(DisposableObserver<ResponseBody> subscriber) {
        Observable<ResponseBody> observable = HttpMethods.getInstance().getHttpApi().getVersionInfo();
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    /**
     * 获取数据
     */
    public static void getVersionInfo2(DisposableObserver<BaseBean<BaseDataBean>> subscriber) {
        Observable<BaseBean<BaseDataBean>> observable = HttpMethods.getInstance().getHttpApi(HttpApi.class).getVersionInfo2();
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }
}
