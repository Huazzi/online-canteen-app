package com.example.common;


import lombok.Getter;
import lombok.Setter;


// 统一返回结果类
@Setter
@Getter
public class Result {
    private String code;    // 返回状态码
    private String msg;     // 返回信息
    private Object data;    // 返回数据

    private Result(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("请求成功");
        return result;
    }

    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode("500");
        result.setMsg("请求失败");
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode("500");
        result.setMsg(msg);
        return result;
    }

}
