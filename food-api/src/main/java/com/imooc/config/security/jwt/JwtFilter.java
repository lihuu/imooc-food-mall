package com.imooc.config.security.jwt;

import com.imooc.utils.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
public class JwtFilter extends GenericFilterBean {
    private static final String AUTHORIZATION_TOKEN = "auth-token";
    private final UserAuthProvider userAuthProvider;

    public JwtFilter(UserAuthProvider userAuthProvider) {
        this.userAuthProvider = userAuthProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader(AUTHORIZATION_TOKEN);
        if (!StringUtils.isEmpty(token)) {
            PayloadModel payloadModel = userAuthProvider.verifyToken(token);
            Authentication authentication = userAuthProvider.getAuthentication(payloadModel);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
