package com.leshuibao.fragmentTax.dao;


import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import com.leshuibao.fragmentTax.dao.mapper.IUserMapper;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestController
public class TUserMapper {

    @Autowired
    IUserMapper userMapper;

    @Test
    public void addUser(){

        UserEntity userEntity = new UserEntity();

        userEntity.setId(UUIDUtil.UString(24));
        userEntity.setUsername("Richard");
        userEntity.setPhone("13305694396");
        userEntity.setPassword("123456");
//        userEntity.setSalt("test");
//        userEntity.setMailAddr("test");
        userEntity.setStatus(0);
//        userEntity.setMemo("test");
        userEntity.setCreatedTime("2018-10-05 00:00:00");

        userMapper.insert(userEntity);

    }

    @Test
    public void searchUser(){

        UserEntity userEntity = userMapper.queryByUsername("Richard");
        System.out.println(userEntity.getId());

    }

}
