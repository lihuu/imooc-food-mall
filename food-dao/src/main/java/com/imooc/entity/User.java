package com.imooc.entity;

import com.imooc.constants.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "realname")
    private String realName;

    @Column(name = "face")
    private String face;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "birthday")
    private Date birthday;

}
