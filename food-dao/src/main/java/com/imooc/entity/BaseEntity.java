package com.imooc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",
        strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @PrePersist
    public void saveCreateTime() {
        if (createTime == null) {
            createTime = new Date();
        }
    }

    @PreUpdate
    public void saveUpdateTime() {
        if (updateTime == null) {
            createTime = new Date();
        }
    }

}
