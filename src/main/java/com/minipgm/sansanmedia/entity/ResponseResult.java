package com.minipgm.sansanmedia.entity;

public class ResponseResult<T> {
    private boolean success;
    private String message;
    private T data;

    public ResponseResult() {

    }

    public ResponseResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
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

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(true, "获取成功!", data);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(true, message, data);
    }

    public static <T> ResponseResult<T> failure(String message) {
        return new ResponseResult<>(false, message, null);
    }
}