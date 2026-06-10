package io.github.sssuer77.liteims.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code; // 状态码: 200成功, 其他失败
    private String message;   // 提示信息
    private T data;       // 返回数据

    // ... 省略 success/fail 等静态工厂方法
}