package com.hcj.baseapplication.netutils;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface InterfaceListener<T> {
    void onSuccess(String result);

    void onFault(String errorMsg);

    void onData(T t);
}
