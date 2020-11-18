package com.imooc.service.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/18.
 *
 * @author lihu
 * @date 2020/11/18
 */
@Getter
@Setter
public class UserBO {
    private String userName;
    private String password;
    private String confirmPassword;
}
