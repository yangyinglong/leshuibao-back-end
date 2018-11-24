package com.leshuibao.fragmentTax.logicalModel;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.google.zxing.WriterException;
import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dao.mapper.*;
import com.leshuibao.fragmentTax.dto.request.PayeeDeleteReqDto;
import com.leshuibao.fragmentTax.dto.request.PayeeEditReqDto;
import com.leshuibao.fragmentTax.dto.request.ShowOrdersReqDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrderDtlRespDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrdersRespDto;
import com.leshuibao.fragmentTax.util.*;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.leshuibao.fragmentTax.util.AliPayUtil.query;

//todo 1，需要增加插入失败异常处理，2，最好是有返回值，根据返回值判断插入结果
@Service
public class TradingHallLogical implements ITradingHallLogical {

    @Autowired
    IOrderMapper orderMapper;
    @Autowired
    IPayerMapper payerMapper;
    @Autowired
    IAddressMapper addressMapper;
    @Autowired
    IShoppingTrolleyMapper shoppingTrolleyMapper;
    @Autowired
    IPaymentMapper paymentMapper;
    @Autowired
    IPayeeMapper payeeMapper;
    @Autowired
    IInvoiceDeliveryMapper iInvoiceDeliveryMapper;

    private static final String IMAGE_PATH = PropertiesUtil.prop("img_path");

    @Override
    public void addOrderEntity(OrderEntity orderEntity) {
        orderMapper.insert(orderEntity);
    }

    @Override
    public OrderEntity getOrderEntity(String orderId) {
        return orderMapper.queryByKey(orderId);
    }

    @Override
    public void addPayerEntty(PayerEntity payerEntity) {
        payerMapper.insert(payerEntity);
    }

    @Override
    public void addAddressEntty(AddressEntity addressEntity) {
        addressMapper.insert(addressEntity);
    }

    @Override
    public void addShoppingTrolley(ShoppingTrolleyEntity shoppingTrolleyEntitie) {
        shoppingTrolleyMapper.insert(shoppingTrolleyEntitie);
    }

    @Override
    public void addPaymentEntity(PaymentEntity paymentEntity) {
        paymentMapper.insert(paymentEntity);
    }

    @Override
    public void addPayeeEntity(PayeeEntity payeeEntity) {
        payeeMapper.insert(payeeEntity);
    }

    @Override
    public void addInvoiceDeliveryEntity(InvoiceDeliveryEntity invoiceDeliveryEntity) {
        iInvoiceDeliveryMapper.insert(invoiceDeliveryEntity);
    }


    @Override
    public List<PayerEntity> getPayerEntitys(String userId) {
        return payerMapper.queryByUserId(userId);
    }

    @Override
    public PayerEntity getPayerEntity(String orderId) {
        // 通过orderId 获取 payer表的Id
        return payerMapper.queryByKey(orderMapper.queryByKey(orderId).getPayerId());
    }

    @Override
    public List<PayeeEntity> getPayeeEntitys(String userId) {
        return payeeMapper.queryByUserId(userId);
    }

    @Override
    public PayeeEntity getPayeeEntity(String orderId) {
        // 通过orderId 获取 payer表的Id
        return payeeMapper.queryByKey(orderMapper.queryByKey(orderId).getPayeeId());
    }

    @Override
    public AddressEntity getAddrEntity(String id) {
        return addressMapper.queryByKey(id);
    }

    @Override
    public List<ShoppingTrolleyEntity> getGoodsEntityByOrderId(String orderId) {
        return shoppingTrolleyMapper.queryByOrderId(orderId);
    }

    @Override
    public void updateShoppingTrolleyEntity(ShoppingTrolleyEntity shoppingTrolleyEntity) {
        shoppingTrolleyMapper.update(shoppingTrolleyEntity);
    }

    @Override
    public List<ShowOrdersRespDto> getShowOrdersRespDtos(ShowOrdersReqDto showOrdersReqDto) {

        List<ShowOrdersRespDto> showOrdersRespDtos = new ArrayList<>();
        int index = 0;
        int startNum = (showOrdersReqDto.getStartPageNum()-1)*showOrdersReqDto.getPageRange();
        for (PayeeEntity payeeEntity : payeeMapper.queryByUserId(showOrdersReqDto.getUserId())) {
            for (OrderEntity orderEntity : orderMapper.queryByC1(
                    payeeEntity.getId(),
                    FormatUtil.strings2String(getIntAuditStatus(showOrdersReqDto.getAuditStatus())),
                    startNum,
                    showOrdersReqDto.getPageRange())) {
                if (index >= startNum && index < startNum + showOrdersReqDto.getPageRange()) {
                    ShowOrdersRespDto showOrdersRespDto = new ShowOrdersRespDto();
                    showOrdersRespDto.setOrderId(orderEntity.getId());
                    showOrdersRespDto.setCreatedTime(orderEntity.getCreatedTime().substring(0, 10));
                    showOrdersRespDto.setPayeeName(payeeEntity.getPayeeName());
                    showOrdersRespDto.setTotalAmount(orderEntity.getTotalAmount());
//                showOrdersRespDto.setAuditStatus(orderEntity.getAuditStatus());
                    showOrdersRespDto.setAuditStatus(getStrAuditStatus(orderEntity.getAuditStatus()));
                    showOrdersRespDto.setExpressCompany(orderEntity.getExpressCompany());
                    showOrdersRespDto.setExpressTrackingCode(orderEntity.getExpressTrackingCode());
                    showOrdersRespDtos.add(showOrdersRespDto);
                } else if (index >= startNum + showOrdersReqDto.getPageRange()){
                    break;
                }
                index ++;
            }
        }

        return showOrdersRespDtos;
    }

    @Override
    public List<ShowOrdersRespDto> getShowOrdersRespDtosForAdmin(ShowOrdersReqDto showOrdersReqDto) {
        List<ShowOrdersRespDto> showOrdersRespDtos = new ArrayList<>();
        int index = 0;
        int startNum = (showOrdersReqDto.getStartPageNum()-1)*showOrdersReqDto.getPageRange();
        for (PayeeEntity payeeEntity : payeeMapper.queryAll()) {
            for (OrderEntity orderEntity : orderMapper.queryByC1(
                    payeeEntity.getId(),
                    FormatUtil.strings2String(getIntAuditStatus(showOrdersReqDto.getAuditStatus())),
                    startNum,
                    showOrdersReqDto.getPageRange())) {
                if (index >= startNum && index < startNum + showOrdersReqDto.getPageRange()) {
                    ShowOrdersRespDto showOrdersRespDto = new ShowOrdersRespDto();
                    showOrdersRespDto.setOrderId(orderEntity.getId());
                    showOrdersRespDto.setCreatedTime(orderEntity.getCreatedTime().substring(0, 10));
                    showOrdersRespDto.setPayeeName(payeeEntity.getPayeeName());
                    showOrdersRespDto.setTotalAmount(orderEntity.getTotalAmount());
//                showOrdersRespDto.setAuditStatus(orderEntity.getAuditStatus());
                    showOrdersRespDto.setAuditStatus(getStrAuditStatus(orderEntity.getAuditStatus()));
                    showOrdersRespDto.setExpressCompany(orderEntity.getExpressCompany());
                    showOrdersRespDto.setExpressTrackingCode(orderEntity.getExpressTrackingCode());

                    showOrdersRespDtos.add(showOrdersRespDto);
                } else if (index >= startNum + showOrdersReqDto.getPageRange()){
                    break;
                }
                index ++;
            }
        }

        return showOrdersRespDtos;
    }

    @Override
    public void updateOrderEntity(OrderEntity orderEntity) {
        orderMapper.update(orderEntity);
    }

    @Override
    public void updatePayerEntity(PayerEntity payerEntity) {
        payerMapper.update(payerEntity);
    }

    @Override
    public void updateAddressEntity(AddressEntity addressEntity) {
        addressMapper.update(addressEntity);
    }

    @Override
    public void updateOrderReject(String id, String reason, String desc) {
        orderMapper.updateReject(id, reason, desc, 2);
    }

    @Override
    public void updateOrderPass(String orderId, String expressCompany, String expressTrackingCode) {
        orderMapper.updateExpress(orderId, expressCompany, expressTrackingCode, 1);
    }

    @Override
    public void deleteShoppingTrolleyEntityByOrderId(String orderId) {
        shoppingTrolleyMapper.deleteByOrderId(orderId);
    }

    @Override
    public void insertShoppingTrolleyEntity(ShoppingTrolleyEntity shoppingTrolleyEntity, String orderId) {
        if (shoppingTrolleyEntity.getId() == null) {
            shoppingTrolleyEntity.setId(UUIDUtil.UString(24));
            shoppingTrolleyEntity.setOrderId(orderId);
            shoppingTrolleyEntity.setStatus(0);
            shoppingTrolleyEntity.setCreatedTime(DateUtil.getCurrentDatetime());
        }
        shoppingTrolleyMapper.insert(shoppingTrolleyEntity);
    }

    @Override
    public boolean aliPayOrderEntityStatus(AlipayClient alipayClient, String orderId) throws AlipayApiException {
        String response = query(alipayClient, orderId);
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONObject queryResponse = jsonObject.getJSONObject("alipay_trade_query_response");
        String code = queryResponse.getString("code");
        if ("10000".equals(code)) {
            String tradeStatus = queryResponse.getString("trade_status");
            if ("TRADE_SUCCESS".equals(tradeStatus)) {
                orderMapper.updateStatusById(orderId, 2);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> postWxUnifiedOrderApi(Map<String, String> header, String paras) throws DocumentException {
        Map<String, Object> resp = new HashMap<>();
        String apiUrl = PropertiesUtil.prop("wx_pay_unified_order_url");
        String returnXml = HttpUtils.doPost(apiUrl, header, paras);
        Map<String, Object> map = XMLUtil.xml2mapWithAttr(returnXml, true);
        Map<String, String> xmlMap = (Map)map.get("xml");
        if (xmlMap.get("return_code").equals("FAIL")) {
            resp.put("c", 201);
            resp.put("r", xmlMap.get("return_msg"));
            return resp;
        } else {
            if (xmlMap.get("result_code").equals("FALL")) {
                resp.put("c", 202);
                resp.put("r", xmlMap.get("err_code"));
                return resp;
            } else {
                resp.put("c", 200);
                resp.put("r", xmlMap.get("code_url"));
                return resp;
            }
        }
    }

    @Override
    public boolean createQrCode(String orderId, String codeUrl, int i) throws IOException, WriterException {
        String qrCodePath = PropertiesUtil.prop("qr_code_path") + orderId + ".jpg";
        return QRUtil.createQrCode(qrCodePath, codeUrl, i);
    }

    @Override
    public boolean wxPayOrderEntityStatus(String orderId, Map<String, String> header, String paras) throws DocumentException {
        String apiUrl = PropertiesUtil.prop("wx_pay_query_order_url");
        String returnXml = HttpUtils.doPost(apiUrl, header, paras);
        Map<String, Object> map = XMLUtil.xml2mapWithAttr(returnXml, true);
        Map<String, String> xmlMap = (Map)map.get("xml");
        if ("FAIL".equals(xmlMap.get("return_code"))) {
            return false;
        }
        if ("FAIL".equals(xmlMap.get("result_code"))) {
            return false;
        }
        if ("SUCCESS".equals(xmlMap.get("trade_state"))) {
            orderMapper.updateStatusById(orderId, 2);
            return true;
        }
        return false;
    }

    @Override
    public void updatePayeeEntity(PayeeEditReqDto payeeEditReqDto) {
        payeeMapper.updateByUseId(payeeEditReqDto.getCidno(), payeeEditReqDto.getPayeeName(),
                payeeEditReqDto.getOldCidno(), payeeEditReqDto.getUserId());
        return;
    }

    @Override
    public void updatePhoto(PayeeEditReqDto payeeEditReqDto) {
        String oldName = payeeEditReqDto.getOldName() + "@" + payeeEditReqDto.getOldCidno();
        String newName = payeeEditReqDto.getPayeeName() + "@" + payeeEditReqDto.getCidno();
        FileUtil.rename(IMAGE_PATH, oldName + "—1.jpg", newName+ "—1.jpg");
        FileUtil.rename(IMAGE_PATH, oldName + "—2.jpg", newName + "—2.jpg");

    }

    @Override
    public void deletePayeeEntityByUserId(PayeeDeleteReqDto payeeDeleteReqDto) {
        payeeMapper.deleteByUserId(payeeDeleteReqDto.getCidno(), payeeDeleteReqDto.getUserId());
    }

    private String[] getIntAuditStatus(String[] auditStatus) {
        for (int i = 0; i < auditStatus.length; i++) {
            if (auditStatus[i].equals("待审核")) {
                auditStatus[i] = "0";
            }
            if (auditStatus[i].equals("已发货")) {
                auditStatus[i] = "1";
            }
            if (auditStatus[i].equals("已驳回")) {
                auditStatus[i] = "2";
            }
        }
        return auditStatus;
    }

    // todo 可以用 eum 改写
    private String getStrAuditStatus(Integer auditStatus) {
        if (auditStatus == 0) {
            return "待审核";
        }
        if (auditStatus == 1) {
            return "已发货";
        }
        if (auditStatus == 2) {
            return "已驳回";
        }
        return "未知";
    }
}
