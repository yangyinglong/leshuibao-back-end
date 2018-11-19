package com.leshuibao.fragmentTax.viewModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.*;
import com.leshuibao.fragmentTax.dto.response.*;
import com.leshuibao.fragmentTax.util.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TradingHallView implements ITradingHallView {

    @Override
    public OrderEntity getOrderEntity(String orderKey, String payerKey, String addressKey, OrderReqDto orderReqDto) {

        OrderEntity orderEntity = new OrderEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            orderEntity.setId(orderKey);
            orderEntity.setTradeName(orderReqDto.getTradeName());
            orderEntity.setTaxRate(orderReqDto.getTaxRate());
            orderEntity.setPayeeId(orderReqDto.getPayeeId());
            orderEntity.setPayerId(payerKey);
            orderEntity.setAddressId(addressKey);
            orderEntity.setExpressCompany(orderReqDto.getExpressCompany());
            orderEntity.setExpressFee(orderReqDto.getExpressFee());
            orderEntity.setTotalAmount(orderReqDto.getTotalAmount());
            orderEntity.setTotalTaxAmount(orderReqDto.getTotalTaxAmount());
            orderEntity.setAuditStatus(0); // 0 待审核 1 已发货 2 已驳回
            orderEntity.setStatus(0);
            orderEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return orderEntity;
        }

        return null;
    }

    @Override
    public OrderEntity getOrderEntity(OrderEditReqDto orderEditReqDto) {

        OrderEntity orderEntity = new OrderEntity();

        if (FormatUtil.isEmpty(orderEditReqDto)) return orderEntity;

        orderEntity.setId(orderEditReqDto.getOrderId());
        orderEntity.setTradeName(orderEditReqDto.getTradeName());
        orderEntity.setTaxRate(orderEditReqDto.getTaxRate());
        orderEntity.setPayeeId(orderEditReqDto.getPayeeId());
        orderEntity.setPayerId(orderEditReqDto.getPayerEntity().getId());
        orderEntity.setPayeeId(orderEntity.getPayeeId());
        orderEntity.setAddressId(orderEditReqDto.getAddressEntity().getId());
        orderEntity.setExpressCompany(orderEditReqDto.getExpressCompany());
        orderEntity.setExpressFee(Float.parseFloat(orderEditReqDto.getExpressFee())); // todo 用工具类修改
        orderEntity.setTotalAmount(Float.parseFloat(orderEditReqDto.getTotalAmount())); // todo 用工具类修改
        orderEntity.setTotalTaxAmount(Float.parseFloat(orderEditReqDto.getTotalTaxAmount())); // todo 用工具类修改

        return orderEntity;
    }

    @Override
    public PayerEntity getPayerEntity(String payerKey, OrderReqDto orderReqDto) {

        PayerEntity payerEntity = new PayerEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            payerEntity.setId(payerKey);
            payerEntity.setPayerCode(orderReqDto.getPayerDto().getPayerCode());
            payerEntity.setPayerName(orderReqDto.getPayerDto().getPayerName());
            payerEntity.setUserId(orderReqDto.getUserId());
            payerEntity.setPayerAddr(orderReqDto.getPayerDto().getPayerAddr());
            payerEntity.setPayerPhone(orderReqDto.getPayerDto().getPayerPhone());
            payerEntity.setPayerBank(orderReqDto.getPayerDto().getPayerBank());
            payerEntity.setPayerBankNo(orderReqDto.getPayerDto().getPayerBankNo());
            payerEntity.setPayerType(0);// todo 如果这个方法重用，那么这个标示需要从调用时传过来
            payerEntity.setStatus(0);
            payerEntity.setMemo(orderReqDto.getPayerDto().getPayerMemo());
            payerEntity.setCreateTime(DateUtil.getCurrentDatetime());

            return payerEntity;
        }

        return null;
    }


    @Override
    public AddressEntity getAddressEntity(String addressKey, String payerKey, OrderReqDto orderReqDto) {

        AddressEntity addressEntity = new AddressEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            addressEntity.setId(addressKey);
            addressEntity.setAddress(orderReqDto.getAddress());
            addressEntity.setAddresseeId(payerKey);
            addressEntity.setAddresseeType(0);
            addressEntity.setStatus(0);
            addressEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return addressEntity;
        }
        return null;
    }

    @Override
    public AddressEntity getAddressEntity(String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto) {
        AddressEntity addressEntity = new AddressEntity();

        if (!FormatUtil.isEmpty(invoiceDeliveryReqDto)) {
            addressEntity.setId(addressKey);
            addressEntity.setAddress(invoiceDeliveryReqDto.getAddress());
            addressEntity.setAddresseeId(invoiceDeliveryReqDto.getUserId());
            addressEntity.setAddresseeType(1);
            addressEntity.setStatus(0);
            addressEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return addressEntity;
        }
        return null;
    }


    @Override
    public ShoppingTrolleyEntity getShoppingTrolleyEntity(String orderKey, ShoppingTrolleyDto shoppingTrolleyDto) {

        ShoppingTrolleyEntity shoppingTrolleyEntity = new ShoppingTrolleyEntity();

        if (!FormatUtil.isEmpty(shoppingTrolleyDto)) {
            shoppingTrolleyEntity.setId(UUIDUtil.UString(24));
            shoppingTrolleyEntity.setOrderId(orderKey);
            shoppingTrolleyEntity.setGoodsName(shoppingTrolleyDto.getGoodsName());
            shoppingTrolleyEntity.setGoodsType(shoppingTrolleyDto.getGoodsType());
            shoppingTrolleyEntity.setMeasureUnit(shoppingTrolleyDto.getMeasureUnit());
            shoppingTrolleyEntity.setBuyedNum(shoppingTrolleyDto.getBuyedNum());
            shoppingTrolleyEntity.setPrice(shoppingTrolleyDto.getPrice());
            shoppingTrolleyEntity.setSalesVolume(shoppingTrolleyDto.getSalesVolume());
            shoppingTrolleyEntity.setTax(shoppingTrolleyDto.getTax());
            shoppingTrolleyEntity.setTaxAmount(shoppingTrolleyDto.getTaxAmount());
            shoppingTrolleyEntity.setStatus(0);
            shoppingTrolleyEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return shoppingTrolleyEntity;
        }

        return null;
    }

    @Override
    public PaymentEntity getPaymentEntity(PaymentDto paymentDto) {

        PaymentEntity paymentEntity = new PaymentEntity();

        if (!FormatUtil.isEmpty(paymentDto)) {
            paymentEntity.setId(UUIDUtil.UString(24));
            paymentEntity.setUserId(paymentDto.getUserId());
            paymentEntity.setOrderId(paymentDto.getOrderId());
            paymentEntity.setPayType(paymentDto.getPayType());
            paymentEntity.setPayTraceCode(paymentDto.getPayCode());
            paymentEntity.setPayFor(paymentDto.getPayFor());
            paymentEntity.setStatus(0);
            paymentEntity.setCreateTime(DateUtil.getCurrentDatetime());

            return paymentEntity;
        }

        return null;
    }

    @Override
    public PayeeEntity getPayeeEntity(PayeeReqDto payeeReqDto) {

        PayeeEntity payeeEntity = new PayeeEntity();

        if (!FormatUtil.isEmpty(payeeReqDto)) {
            payeeEntity.setId(UUIDUtil.UString(24));
            payeeEntity.setPayeeName(payeeReqDto.getPayeeName());
            payeeEntity.setPayeeCidno(payeeReqDto.getCidno());
            payeeEntity.setPayeeCidUrl(payeeReqDto.getCid_url());
            payeeEntity.setUserId(payeeReqDto.getUserId());
            payeeEntity.setPayeeType(0); // todo 根据传过来的进行设定
            payeeEntity.setStatus(0);
            payeeEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return payeeEntity;
        }

        return null;
    }

    @Override
    public InvoiceDeliveryEntity getInvoiceDeliveryEntity(String orderKey, String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto) {

        InvoiceDeliveryEntity deliveryEntity = new InvoiceDeliveryEntity();

        if (!FormatUtil.isEmpty(invoiceDeliveryReqDto)) {
            deliveryEntity.setId(orderKey);
            deliveryEntity.setUserId(invoiceDeliveryReqDto.getUserId());
            deliveryEntity.setAddressId(addressKey);
            deliveryEntity.setExpressCompany(invoiceDeliveryReqDto.getExpressCompany());
            deliveryEntity.setStatus(0);
            deliveryEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return deliveryEntity;
        }

        return null;
    }

    @Override
    public AddrRespDto getAddrResp(AddressEntity addressEntity) {

        AddrRespDto addrRespDto = new AddrRespDto();

        addrRespDto.setAddress(addressEntity.getAddress());
        addrRespDto.setAddressee_id(addressEntity.getAddresseeId());
        addrRespDto.setAddressee_type(addressEntity.getAddresseeType());
        addrRespDto.setId(addressEntity.getId());

        return addrRespDto;
    }

    @Override
    public Map<String, String> getPostWxPayUrlHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/xml");
        return headers;
    }

    @Override
    public String getUnifiedOrderParas(String body, String productId, double titalFee) throws IOException, DocumentException {
        Map<String, Object> paras = new HashMap<>();

        String appId = PropertiesUtil.prop("wx_pay_app_id");
        String mchId = PropertiesUtil.prop("wx_pay_mch_id");
        String nonceStr = UUIDUtil.RBase(UUIDUtil.BASECHAR, 10);
        String timeStamp = DateUtil.getSysDatetimeString();
        String key = PropertiesUtil.prop("wx_pay_key");
        String spbillCreateIP = PropertiesUtil.prop("wx_pay_spbill_create_ip");
        String notifyUrl = PropertiesUtil.prop("wx_pay_notify_url");
        String tradeType = "NATIVE";
        String sign = WXPayUtil.CreateUnifiedOrderSign(appId, mchId, nonceStr, timeStamp, productId, key, spbillCreateIP, notifyUrl, tradeType, body, titalFee);

        paras.put("appid", appId);
        paras.put("mch_id", mchId);
        paras.put("nonce_str", nonceStr);
        paras.put("sign", sign);
        paras.put("body", body);
        paras.put("out_trade_no", productId);
        paras.put("total_fee", titalFee);
        paras.put("spbill_create_ip", spbillCreateIP);
        paras.put("notify_url", notifyUrl);
        paras.put("trade_type", tradeType);

        Document doc = XMLUtil.map2xml(paras, "xml");
        return XMLUtil.formatXml(doc);
    }

    @Override
    public String getQueryOrderParas(String productId) throws IOException, DocumentException {
        Map<String, Object> paras = new HashMap<>();

        String appId = PropertiesUtil.prop("wx_pay_app_id");
        String mchId = PropertiesUtil.prop("wx_pay_mch_id");
        String nonceStr = UUIDUtil.RBase(UUIDUtil.BASECHAR, 10);
        String key = PropertiesUtil.prop("wx_pay_key");
        String sign = WXPayUtil.CreateQueryOrderSign(appId, mchId, nonceStr, productId, key);
        paras.put("appid", appId);
        paras.put("mch_id", mchId);
        paras.put("nonce_str", nonceStr);
        paras.put("sign", sign);
        paras.put("out_trade_no", productId);

        Document doc = XMLUtil.map2xml(paras, "xml");
        return XMLUtil.formatXml(doc);
    }

}
