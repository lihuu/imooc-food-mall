package com.imooc.service.model;

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
public class UserBO {
    private String userName;
    private String password;
    private String confirmPassword;
}
