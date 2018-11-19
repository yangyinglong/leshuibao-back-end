package com.leshuibao.fragmentTax.viewModel;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.dto.response.UserRespDto;
import com.leshuibao.fragmentTax.util.DateUtil;
import com.leshuibao.fragmentTax.util.FormatUtil;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeView implements IAuthorizeView {


    @Override
    public UserRespDto getUserResp(UserEntity userEntity) {

        UserRespDto userResp = new UserRespDto();

        if (!FormatUtil.isEmpty(userEntity)) {
            userResp.setUserId(userEntity.getId());
            userResp.setUserName(userEntity.getUsername());
            userResp.setPhone(userEntity.getPhone());
//            userResp.setStatus(userEntity.getStatus());
            userResp.setStatus(1);
            userResp.setCreateTime(userEntity.getCreatedTime().substring(0,10));

            return userResp;
        }
        return null;
    }

    @Override
    public UserEntity getUserEntity(RegisterReqDto registerReqDto) {

        UserEntity userEntity = new UserEntity();

        if (!FormatUtil.isEmpty(registerReqDto)) {
            userEntity.setId(UUIDUtil.UString(24));
            userEntity.setUsername(registerReqDto.getUsername());
            userEntity.setPhone(registerReqDto.getPhone());
            userEntity.setPassword(registerReqDto.getPassword());
            userEntity.setStatus(0);
            userEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return userEntity;
        }
        return null;
    }

    @Override
    public SmsLogEntity getSmsLogEntity(String smsKey, String phone, String smsCode, SendSmsResponse sendSmsResp) {
        // 不需要判断是否为空
        SmsLogEntity smsLogEntity = new SmsLogEntity();

        smsLogEntity.setId(smsKey);
        smsLogEntity.setPhone(phone);
        smsLogEntity.setSmsCode(smsCode);
        smsLogEntity.setRequestId(sendSmsResp.getRequestId());
        smsLogEntity.setStatusCode(sendSmsResp.getCode());
        smsLogEntity.setMessage(sendSmsResp.getMessage());
        smsLogEntity.setBizid(sendSmsResp.getBizId());
        smsLogEntity.setCreateTime(DateUtil.getCurrentDatetime());

        return smsLogEntity;
    }

}
