package com.imooc.common.exception;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
public class JwtExpiredException extends RuntimeException {
    public JwtExpiredException(String message) {
        super(message);
    }

}
