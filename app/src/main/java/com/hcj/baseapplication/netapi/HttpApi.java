package com.hcj.baseapplication.netapi;

import com.hcj.baseapplication.bean.BaseBean;
import com.hcj.baseapplication.bean.BaseDataBean;
import com.hcj.baseapplication.bean.DouBanMovieRequest;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 眼神 on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface HttpApi {
    //请填写自己的接口名
    @POST("")
    Observable<ResponseBody> getDataForBean(@Body DouBanMovieRequest bean);

    //请填写自己的接口名
    @GET("")
    Observable<ResponseBody> getDataForMap(@QueryMap Map<String, Integer> map);

    /**
     * 通过地址下载一个文件
     */
    @GET()
    @Streaming
    Call<ResponseBody> downloadFile(@Url String fileUrl);

    @GET("app/getOemVersion/yth")
    Observable<ResponseBody> getVersionInfo();

    @GET("app/getOemVersion/yth")
    Observable<BaseBean<BaseDataBean>> getVersionInfo2();

    @GET("app/getOemVersion/yth")
    Call<BaseDataBean> getVersionInfo1();

    @FormUrlEncoded
    @POST("app/usrLogin/yth")
    Observable<BaseBean<BaseDataBean>> login(@Field("usrTel") String usrTel,
                                             @Field("logintype") String logintype,
                                             @Field("loginpwd") String loginpwd,
                                             @Field("osType") String osType,
                                             @Field("deviceToken") String deviceToken);
}
