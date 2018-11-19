package com.leshuibao.fragmentTax.logicalModel;

import com.leshuibao.fragmentTax.dao.entity.OrderEntity;
import com.leshuibao.fragmentTax.dao.entity.ShoppingTrolleyEntity;
import com.leshuibao.fragmentTax.dao.entity.SmsLogEntity;
import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import com.leshuibao.fragmentTax.dao.mapper.ISmsLogMapper;
import com.leshuibao.fragmentTax.dao.mapper.IUserMapper;
import com.leshuibao.fragmentTax.dto.request.LoginReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrderDtlRespDto;
import com.leshuibao.fragmentTax.util.FormatUtil;
import com.leshuibao.fragmentTax.util.PropertiesUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.leshuibao.fragmentTax.util.ExcelUtil.copyFile;
import static com.leshuibao.fragmentTax.util.ExcelUtil.save;
import static com.leshuibao.fragmentTax.util.ExcelUtil.write;

@Service
public class AuthorizeLogical implements IAuthorizeLogical {

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private ISmsLogMapper smsInfoMapper;

    @Autowired
    private ITradingHallLogical tradingHallLogical;
//    @Autowired
//    public AuthorizeLogical(IUserMapper userMapper){
//        this.userMapper = userMapper;
//    }

    @Override
    public UserEntity getUserEntity(LoginReqDto loginReqDto) {

        UserEntity userEntity;

        try {
            userEntity = userMapper.queryByUsername(loginReqDto.getUsername());
            if (FormatUtil.isEmpty(userEntity)) {
                userEntity = userMapper.queryByPhone(loginReqDto.getUsername());
            }
        } catch (Exception e) {
            return null;
        }

        if (!FormatUtil.isEmpty(userEntity) && loginReqDto.getPassword().equals(userEntity.getPassword())) {
            return userEntity;
        }

        return null;
    }

    @Override
    public UserEntity getUserEntity(RegisterReqDto registerReqDto) {

        try {
            return userMapper.queryByPhone(registerReqDto.getPhone());
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }


    @Override
    public SmsLogEntity getSmsLogEntity(String smsId) {
        return smsInfoMapper.queryByKey(smsId);
    }

    @Override
    public void addSmsLog(SmsLogEntity smsLogEntity) {
        smsInfoMapper.insert(smsLogEntity);
    }

    @Override
    public void updatePassByPhone(String phone, String password) {
        userMapper.updateByPhone(phone, password);
    }

    @Override
    public void genExcel(String filePath, String fileName, String orderId) throws IOException {

        OrderEntity orderEntity = tradingHallLogical.getOrderEntity(orderId);

        ShowOrderDtlRespDto orderDtlRespDto = new ShowOrderDtlRespDto(
                orderEntity,
                tradingHallLogical.getPayeeEntity(orderId),
                tradingHallLogical.getPayerEntity(orderId),
                tradingHallLogical.getGoodsEntityByOrderId(orderId),
                tradingHallLogical.getAddrEntity(orderEntity.getAddressId())
        );

        Workbook workbook = copyFile(PropertiesUtil.prop("template_path"));

        write(workbook, 0, 2, 2, orderDtlRespDto.getPayerEntity().getPayerName());
        write(workbook, 0, 2, 5, orderDtlRespDto.getPayerEntity().getPayerCode());
        write(workbook, 0, 3, 2, orderDtlRespDto.getPayerEntity().getPayerAddr());
        write(workbook, 0, 3, 5, orderDtlRespDto.getPayerEntity().getPayerBank());
        write(workbook, 0, 4, 2, orderDtlRespDto.getPayerEntity().getPayerPhone());
        write(workbook, 0, 4, 5, orderDtlRespDto.getPayerEntity().getPayerBankNo());

        write(workbook, 0, 5, 2, orderDtlRespDto.getPayeeEntity().getPayeeName());
        write(workbook, 0, 5, 5, orderDtlRespDto.getPayeeEntity().getPayeeCidno());

        int index = 0;
        for (ShoppingTrolleyEntity shoppingTrolleyEntity : orderDtlRespDto.getShoppingTrolleyEntities()) {
            write(workbook, 0, 13+index, 0, shoppingTrolleyEntity.getGoodsName());
            write(workbook, 0, 13+index, 1, shoppingTrolleyEntity.getGoodsType());
            write(workbook, 0, 13+index, 2, shoppingTrolleyEntity.getMeasureUnit());
            write(workbook, 0, 13+index, 3, shoppingTrolleyEntity.getBuyedNum().toString());
            write(workbook, 0, 13+index, 4, shoppingTrolleyEntity.getPrice()+"");
            write(workbook, 0, 13+index, 5, shoppingTrolleyEntity.getTax()+"");
            write(workbook, 0, 13+index, 6, shoppingTrolleyEntity.getTaxAmount()+"");

            index += 1;
        }

        save(write(workbook, 0, 45, 1, orderDtlRespDto.getAddressEntity().getAddress()),PropertiesUtil.prop("file_path") + orderId + ".xlsx");

    }

}
