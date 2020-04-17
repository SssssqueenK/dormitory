package com.example.dormitory.dto;

import lombok.Getter;

/**
 * 统一返回结果
 */
@Getter
public class Response {
    // 200成功 500失败 401未认证，跳转登录 406请求未授权
    private int code;
    private String msg;
    private Object data;
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_ERROR = 500;
    private static final int CODE_TOKEN_ERROR = 401;

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success() {
        return success(null);
    }

    public static Response success(Object data) {
        return new Response(CODE_SUCCESS, "success", data);
    }

    public static Response error(String msg) {
        return new Response(CODE_ERROR, msg, null);
    }

    public static Response errorToken(String msg) {
        return new Response(CODE_TOKEN_ERROR, msg, null);
    }
}
