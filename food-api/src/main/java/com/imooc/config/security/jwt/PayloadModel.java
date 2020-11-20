package com.imooc.config.security.jwt;

import lombok.*;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayloadModel {
    private String userId;
    private String roleString;
    private long expireTime;
}
