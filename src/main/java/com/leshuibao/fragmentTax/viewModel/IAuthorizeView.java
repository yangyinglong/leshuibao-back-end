package com.leshuibao.fragmentTax.viewModel;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.dto.response.UserRespDto;


public interface IAuthorizeView {

     UserRespDto getUserResp(UserEntity userEntity);

     UserEntity getUserEntity(RegisterReqDto registerReqDto);

    SmsLogEntity getSmsLogEntity(String smsKey, String phone, String cmsCode, SendSmsResponse sendSmsResp);
}
