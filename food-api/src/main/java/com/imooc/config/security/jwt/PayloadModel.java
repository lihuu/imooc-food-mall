package com.imooc.config.security.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
@Getter
@Setter
@Builder
public class PayloadModel {
    private String userId;
    private String roleString;
    private long expireTime;
}
