package com.imooc.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Http Response 对象")
public class ApiResponse {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回的数据")
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
