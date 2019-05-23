package com.hcj.baseapplication.bean;

import java.io.Serializable;

/**
 * 基本结果类
 */
public class BaseBean<T> implements Serializable {
	private static final long serialVersionUID = -4433883125158971260L;

	private int code;
	private Boolean success;
	private String message;
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseBean{" +
				"code=" + code +
				", success=" + success +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
