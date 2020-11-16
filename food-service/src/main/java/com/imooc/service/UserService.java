package com.imooc.service;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
public interface UserService {
    /**
     * 判断用户是否存在
     *
     * @param userName
     * @return
     */
    boolean isUserExist(String userName);
}
