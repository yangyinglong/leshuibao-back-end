package com.leshuibao.fragmentTax.viewModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.*;
import com.leshuibao.fragmentTax.dto.response.*;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ITradingHallView {

    OrderEntity getOrderEntity(String key, String payerKey, String orderKey, OrderReqDto orderReqDto);

    OrderEntity getOrderEntity(OrderEditReqDto orderEditReqDto);

    PayerEntity getPayerEntity(String payerKey, OrderReqDto orderReqDto);

    AddressEntity getAddressEntity(String addressKey,String payerKey, OrderReqDto orderReqDto);

    AddressEntity getAddressEntity(String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto);

    ShoppingTrolleyEntity getShoppingTrolleyEntity(String orderKey, ShoppingTrolleyDto shoppingTrolleyDto);

    PaymentEntity getPaymentEntity(PaymentDto paymentDto);

    PayeeEntity getPayeeEntity(PayeeReqDto payeeReqDto);

    InvoiceDeliveryEntity getInvoiceDeliveryEntity(String orderKey, String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto);

    AddrRespDto getAddrResp(AddressEntity addressEntity);

    Map<String,String> getPostWxPayUrlHeader();

    String getUnifiedOrderParas(String body, String productId, double titalFee) throws IOException, DocumentException;

    String getQueryOrderParas(String productId) throws IOException, DocumentException;

//    ShowOrderDtlRespDto getShowOrderDtlRespDto(PayeeEntity payeeEntity, PayerEntity payerEntity, List<ShoppingTrolleyEntity> shoppingTrolleyEntities, AddressEntity addressEntity);
}
