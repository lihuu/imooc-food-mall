package com.imooc.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/18.
 *
 * @author lihu
 * @date 2020/11/18
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户对象")
public class UserBO {
    @ApiModelProperty(value = "用户名",
        name = "userName",
        example = "lihuu")
    private String userName;
    @ApiModelProperty(value = "密码",
        name = "password",
        example = "admin@123")
    private String password;
    @ApiModelProperty(value = "确认密码",
        name = "confirmPassword",
        example = "admin@123")
    private String confirmPassword;
}
