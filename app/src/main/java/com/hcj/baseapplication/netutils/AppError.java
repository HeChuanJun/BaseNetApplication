package com.hcj.baseapplication.netutils;

/**
 * Created by dell on 2017/6/16.
 */

public class AppError {
    private int code;
    private String message;

    public static final int EXCEPTION = 100;
    public static final int NO_NETWORK = 101;       //没网
    public static final int NO_DATA = 102;          //没数据
    public static final int SEARCH_NO_DATA = 103;          //没数据
    public static final int LOAD_ERROR = 104;          //加载错误
    public static final int OTHER_ERROR = 105;

    public static final int NETWORK_EXCEPTION = 106;       //没网

    public static final String MESSAGE_NO_NETWORK = "无法连接网络";
    public static final String MESSAGE_NO_DATA = "暂无内容";
    public static final String MESSAGE_SEARCH_NO_DATA = "搜索无结果";
    public static final String MESSAGE_LOAD_ERROR = "加载失败";
    public static final String MESSAGE_BAD_NETWORK = "网络异常，请稍后重试！";
    public static final String MESSAGE_LOCATION_LIMIT = "手机位置信息未开启！";
    public static final String MESSAGE_SERVER_NODATA = "服务器无数据！";
    public static final String SocketTimeoutException = "响应超时";
    public static final String SocketException = "网络异常，请检查网络连接";


    public AppError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AppError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
