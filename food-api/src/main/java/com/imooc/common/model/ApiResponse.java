package com.imooc.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String code;
    private String message;
    private Object data;

    public ApiResponse(Object data) {
        this.code = "200";
        this.message = "OK";
        this.data = data;
    }

    public static ApiResponse ok() {
        return ok(null);
    }

    public static ApiResponse ok(Object object) {
        return new ApiResponse("200", "Ok", object);
    }

    public static ApiResponse success(String message, Object object) {
        return new ApiResponse("200", message, object);
    }

    public static ApiResponse errorMessage(String message) {
        return new ApiResponse("500", message, null);
    }

    public static ApiResponse errorMessage(String code, String message) {
        return new ApiResponse(code, message, null);
    }

}
