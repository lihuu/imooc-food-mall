package com.imooc.config.security;

import com.imooc.config.security.jwt.JwtFilter;
import com.imooc.config.security.jwt.JwtProperties;
import com.imooc.config.security.jwt.UserAuthProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by 1449488533qq@gmail.com on 5/14/2020.
 * Spring Security配置使用jwt
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
        return new UserAuthProvider(jwtProperties.getSecurityKey(), jwtProperties.getExpireTime());
    }

    private JwtProperties jwtProperties;

    @Autowired
    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        //这些不需要登录的
        httpSecurity.authorizeRequests().antMatchers("/passport/*").permitAll();
    }
}
