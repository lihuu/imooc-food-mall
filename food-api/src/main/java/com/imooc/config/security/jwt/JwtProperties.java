package com.imooc.config.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/20.
 *
 * @author lihu
 * @date 2020/11/20
 */
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Getter
@Setter
public class JwtProperties {
    private String securityKey;
    private long expireTime;
}
