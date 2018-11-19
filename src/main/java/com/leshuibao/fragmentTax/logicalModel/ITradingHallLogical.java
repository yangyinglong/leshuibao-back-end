package com.leshuibao.fragmentTax.logicalModel;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.google.zxing.WriterException;
import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.OrderReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.dto.request.ShowOrdersReqDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrderDtlRespDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrdersRespDto;
import com.leshuibao.fragmentTax.dto.response.UserRespDto;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ITradingHallLogical {


    void addOrderEntity(OrderEntity orderEntity);

    void addPayerEntty(PayerEntity payerEntity);

    void addAddressEntty(AddressEntity addressEntity);

    void addShoppingTrolley(ShoppingTrolleyEntity shoppingTrolleyEntitie);

    void addPaymentEntity(PaymentEntity paymentEntity);

    void addPayeeEntity(PayeeEntity payeeEntity);

    void addInvoiceDeliveryEntity(InvoiceDeliveryEntity invoiceDeliveryEntity);

    OrderEntity getOrderEntity(String orderId);

    List<PayerEntity> getPayerEntitys(String userId);

    PayerEntity getPayerEntity(String userId);

    List<PayeeEntity> getPayeeEntitys(String userId);

    PayeeEntity getPayeeEntity(String orderId);

    AddressEntity getAddrEntity(String id);

    List<ShoppingTrolleyEntity> getGoodsEntityByOrderId(String orderId);

    void updateShoppingTrolleyEntity(ShoppingTrolleyEntity shoppingTrolleyEntity);

    List<ShowOrdersRespDto> getShowOrdersRespDtos(ShowOrdersReqDto showOrdersReqDto);

    List<ShowOrdersRespDto> getShowOrdersRespDtosForAdmin(ShowOrdersReqDto showOrdersReqDto);

    void updateOrderEntity(OrderEntity orderEntity);

    void updatePayerEntity(PayerEntity payerEntity);

    void updateAddressEntity(AddressEntity addressEntity);

    void updateOrderReject(String id, String reason, String desc);

    void updateOrderPass(String orderId, String expressCompany, String expressTrackingCode);

    void deleteShoppingTrolleyEntityByOrderId(String orderId);

    void insertShoppingTrolleyEntity(ShoppingTrolleyEntity shoppingTrolleyEntity, String orderId);

    boolean aliPayOrderEntityStatus(AlipayClient alipayClient, String orderId) throws AlipayApiException;

    Map<String, Object> postWxUnifiedOrderApi(Map<String, String> header, String paras) throws DocumentException;

    boolean createQrCode(String orderId, String codeUrl, int i) throws IOException, WriterException;

    boolean wxPayOrderEntityStatus(String orderId, Map<String,String> header, String paras) throws DocumentException;
}
