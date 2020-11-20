package com.imooc.config.security;

import com.imooc.config.security.jwt.JwtFilter;
import com.imooc.config.security.jwt.UserAuthProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by 1449488533qq@gmail.com on 5/14/2020.
 *
 * @author lihu
 * @date 5/14/2020
 */
@Configuration
@Log4j2
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter(userAuthProvider());
    }

    @Bean
    public UserAuthProvider userAuthProvider() {
        String secretKey = "";
        long expireTime = 12313L;
        return new UserAuthProvider(secretKey, expireTime);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.authorizeRequests().antMatchers("/passport/*")
            .permitAll();//这些不需要登录的
        //登录失败
    }
}
