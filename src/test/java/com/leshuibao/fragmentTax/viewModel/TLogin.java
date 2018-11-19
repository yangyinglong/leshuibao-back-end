package com.leshuibao.fragmentTax.viewModel;

import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import com.leshuibao.fragmentTax.dto.request.LoginReqDto;
import com.leshuibao.fragmentTax.dto.response.UserRespDto;
import com.leshuibao.fragmentTax.logicalModel.IAuthorizeLogical;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestController
public class TLogin {

    @Autowired
    IAuthorizeLogical authorizeLogical;

    @Autowired
    IAuthorizeView authorizeView;

    @Test
    public void queryUser() {

        LoginReqDto loginReqDto = new LoginReqDto();
        loginReqDto.setUsername("Richard");
        loginReqDto.setPassword("123456");
        loginReqDto.setRememberPassword(true);

        UserEntity userEntity = authorizeLogical.getUserEntity(loginReqDto);

        System.out.println(userEntity.getPhone());
    }

    @Test
    public void queryUserView() {

        LoginReqDto loginReqDto = new LoginReqDto();
        loginReqDto.setUsername("Richard");
        loginReqDto.setPassword("123456");
        loginReqDto.setRememberPassword(true);

//        UserRespDto userRespDto = authorizeView.getUserResp(loginReqDto);

//        System.out.println(userRespDto.getPhone());
    }

    @Test
    public void setUserResp(){
        UserRespDto userRespDto = new UserRespDto();
        userRespDto.setUserId("fortest");
        System.out.println(userRespDto.getUserId());
    }

}
