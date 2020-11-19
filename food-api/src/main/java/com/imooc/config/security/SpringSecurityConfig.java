package com.imooc.config.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by 1449488533qq@gmail.com on 5/14/2020.
 *
 * @author lihu
 * @date 5/14/2020
 */
@Configuration
@Log4j2
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/test", "/login", "/database/**/*", "/common/**")
            .permitAll()//这些不需要登录的
            .antMatchers("/hello").hasRole("admin").anyRequest().authenticated().and().formLogin().loginPage("/login")
            .loginProcessingUrl("/user/login").successHandler((request, response, authentication) -> {
            //登录成功之后的处理，设置一些cookies什么的吧
            response.sendRedirect("/account/myevents");
        }).failureHandler((request, response, exception) -> {
            //登录失败
            log.error("账号登录失败", exception);
            response.sendRedirect("/login?returnMessage=" + exception.getMessage());
        }).permitAll().and().logout().logoutUrl("/logout").logoutSuccessHandler((request, response, authentication) -> {
            //登出的处理，清除一些cookies什么的
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(null);
            response.sendRedirect("/login");
        }).permitAll().and().csrf().disable();

        //添加这个配置后，才能访问h2的数据库管理页面
        httpSecurity.headers().frameOptions().disable();
    }
}
