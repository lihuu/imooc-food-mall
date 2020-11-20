package com.imooc.repository;

import com.imooc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
