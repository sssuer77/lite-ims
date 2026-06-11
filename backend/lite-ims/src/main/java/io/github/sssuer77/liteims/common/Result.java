package io.github.sssuer77.liteims.common;

import io.github.sssuer77.liteims.entity.SysUser;
import lombok.Data;

@Data
public class Result<T> {
    private Integer code; // 状态码: 200成功, 其他失败
    private String message;   // 提示信息
    private T data;       // 返回数据


    // 成功的方法
    public static <T> Result<T> success(String message,T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    // 成功的方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage();
        result.setData(data);
        return result;
    }

    // 失败的方法（带错误信息）
    public static <T> Result<T> fail(Integer code,String message) {
        Result<T> result = new Result<>();
        result.setCode(code); // 假设 500 是通用失败码
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}