package com.leshuibao.fragmentTax.controller.endpoint;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.leshuibao.fragmentTax.dao.entity.SmsLogEntity;
import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import com.leshuibao.fragmentTax.dto.request.LoginReqDto;
import com.leshuibao.fragmentTax.dto.request.PasswdChangeReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.logicalModel.IAuthorizeLogical;
import com.leshuibao.fragmentTax.util.FormatUtil;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import com.leshuibao.fragmentTax.viewModel.IAuthorizeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static com.leshuibao.fragmentTax.util.SmsUtil.sendSms;

@Component
@Path("/authorize")
@CrossOrigin
public class AuthorizeController {

    @Autowired
    private IAuthorizeView authorizeView;

    @Autowired
    private IAuthorizeLogical authorizeLogical;


    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> login(LoginReqDto loginReqDto) {

        Map<String, Object> resp = new HashMap<>();

        UserEntity userEntity = authorizeLogical.getUserEntity(loginReqDto);

        if (!FormatUtil.isEmpty(userEntity)) {
            resp.put("c", 200);
            resp.put("r", authorizeView.getUserResp(userEntity));

            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "登录失败"); // 失败原因：1，连接数据错误 2，查无此人 3，密码不对

        return resp;

    }

    @Path("/smsSend")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> smsSend(String phone) throws Exception {

        Map<String, Object> resp = new HashMap<>();
        SendSmsResponse SendSmsResp = new SendSmsResponse();
        // 发送的内容：6位数字字符串
        String smsKey = UUIDUtil.UString(24);
        String smsCode = UUIDUtil.RInt(6);

        // 1.发送短信，response接受返回的消息
        for (int i = 0; i < 5; i++) {
            SendSmsResp = sendSms(phone, smsCode);
            // todo 等一秒
            if (SendSmsResp.getCode().equals("OK")) {
                authorizeLogical.addSmsLog(authorizeView.getSmsLogEntity(smsKey, phone, smsCode, SendSmsResp));
                resp.put("c", 200);
                resp.put("r", smsKey);
                return resp;
            }
        }
        authorizeLogical.addSmsLog(authorizeView.getSmsLogEntity(smsKey, phone, smsCode, SendSmsResp));
        resp.put("c", 300);
        resp.put("r", "短信发送失败");
        return resp;
    }


    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> register(RegisterReqDto registerReqDto) {

        Map<String, Object> resp = new HashMap<>();

        UserEntity userEntity = authorizeLogical.getUserEntity(registerReqDto);
        // 1，判断是否已注册
        if (!FormatUtil.isEmpty(userEntity)) {
            resp.put("c", 201);
            resp.put("r", "老用户，请直接登录。或从：登录 -> 忘记密码 找回密码。");

            return resp;
        }
        // 2，进行短信验证
        if (!registerReqDto.getSmsCode().equals(authorizeLogical.getSmsLogEntity(registerReqDto.getSmsId()).getSmsCode())) {
            resp.put("c", 300);
            resp.put("r", "验证码不正确");

            return resp;
        }

        // 3，注册写入数据库
        UserEntity userEntity1 = authorizeView.getUserEntity(registerReqDto);
        authorizeLogical.addUser(userEntity1);
        resp.put("c", 200);
        resp.put("r", authorizeView.getUserResp(userEntity1));

        return resp;

    }

    // todo
    @Path("/logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> logout(String userId) {

        Map<String, Object> resp = new HashMap<>();

        resp.put("c", 200);
        resp.put("r", "1");

        return resp;

    }

    /**
     * 1. 根据smsId找到验证码
     * 2. 修改用户密码
     */
    @Path("/passChange")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> passChange(PasswdChangeReqDto passwdChangeReqDto) {

        Map<String, Object> resp = new HashMap<>();
        SmsLogEntity smsLogEntity = authorizeLogical.getSmsLogEntity(passwdChangeReqDto.getSmsId());
        if (!FormatUtil.isEmpty(smsLogEntity)) {
            if (passwdChangeReqDto.getValidatecode().equals(smsLogEntity.getSmsCode())) {
                authorizeLogical.updatePassByPhone(passwdChangeReqDto.getPhone(), passwdChangeReqDto.getPass());

                resp.put("c", 200);
                resp.put("r", "密码修改成功！");

                return resp;
            }
        }
        resp.put("c", 200);
        resp.put("r", "验证码验证错误，密码修改未成功！");

        return resp;
    }
}
