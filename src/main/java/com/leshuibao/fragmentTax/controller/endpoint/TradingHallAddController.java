package com.leshuibao.fragmentTax.controller.endpoint;


import com.alipay.api.AlipayClient;
import com.leshuibao.fragmentTax.dao.entity.ShoppingTrolleyEntity;
import com.leshuibao.fragmentTax.dto.request.*;
import com.leshuibao.fragmentTax.logicalModel.ITradingHallLogical;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import com.leshuibao.fragmentTax.viewModel.ITradingHallView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static com.leshuibao.fragmentTax.util.AliPayUtil.createFrom;
import static com.leshuibao.fragmentTax.util.AliPayUtil.initAlipayClient;

@Component
@Path("/tradingHall")
@CrossOrigin
public class TradingHallAddController {

    @Autowired
    private ITradingHallView tradingHallView;

    @Autowired
    private ITradingHallLogical tradingHallLogical;

    AlipayClient alipayClient = initAlipayClient();

    @Path("/addOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addOrder(OrderReqDto orderReqDto) {

        Map<String, Object> resp = new HashMap<>();

        String orderKey = UUIDUtil.RInt(24);
        String payerKey = UUIDUtil.UString(24);
        String addressKey = UUIDUtil.UString(24);

        try {
            tradingHallLogical.addOrderEntity(tradingHallView.getOrderEntity(orderKey, payerKey, addressKey, orderReqDto));
            tradingHallLogical.addPayerEntty(tradingHallView.getPayerEntity(payerKey, orderReqDto));
            tradingHallLogical.addAddressEntty(tradingHallView.getAddressEntity(addressKey, payerKey, orderReqDto));
            for (ShoppingTrolleyDto shoppingTrolleyDto : orderReqDto.getShoppingTrolleyDtos()) {
                tradingHallLogical.addShoppingTrolley(tradingHallView.getShoppingTrolleyEntity(orderKey, shoppingTrolleyDto));
            }

            resp.put("c", 200);
            resp.put("r", orderKey);

            return resp;
        } catch (Exception e) {
            System.err.println(e);
        }

        resp.put("c", 400);
        resp.put("r", "失败");

        return resp;
    }

    /**
     * 支付宝支付接口
     * @param
     * @return
     */
    @Path("/aliPay")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> aliPay(PayReqDto payReqDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            String from = createFrom(alipayClient, payReqDto.getOrderId(), payReqDto.getAllAmount());
            resp.put("c", 200);
            resp.put("r", from);
            return resp;
        } catch (Exception e) {
            System.err.printf(String.valueOf(e));
        }
        resp.put("c", 400);
        resp.put("r", "请求支付宝支付失败！");
        return resp;
    }

    /**
     * 微信支付接口
     * @param payReqDto
     * @return
     */
    @Path("/wxPay")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> wxPay(PayReqDto payReqDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
             Map<String, String> header = tradingHallView.getPostWxPayUrlHeader();
             String paras = tradingHallView.getUnifiedOrderParas("乐税宝", payReqDto.getOrderId(), payReqDto.getAllAmount());
             resp = tradingHallLogical.postWxUnifiedOrderApi(header, paras);
             if ((int)resp.get("c") == 200) {
                 String codeUrl = (String)resp.get("r");
                 if (tradingHallLogical.createQrCode(payReqDto.getOrderId(), codeUrl, 2000)){
                     resp.put("r", "创造成功"); //todo 给一个二维码
                 }else {
                     resp.put("c", 203);
                     resp.put("r", "二维码生成失败");
                 }
                 return resp;
             }
             return resp;
        } catch (Exception e) {
            System.err.println(String.valueOf(e));
        }
        resp.put("c", 400);
        resp.put("r", "请求微信支付失败！");
        return resp;
    }

    /**
     * 阿里支付订单查询
     * @param orderId
     * @return
     */
    @Path("/aliPayQuery")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> aliPayQuery(String orderId) {
        Map<String, Object> resp = new HashMap<>();
        try {
            boolean queryResult =  tradingHallLogical.aliPayOrderEntityStatus(alipayClient, orderId);
            if (queryResult) {
                resp.put("c", 200);
                resp.put("r", "买家已付款");
            } else {
                // 如果阿里支付查询结果为未支付，则调用微信查询
                resp= wxPayQuery(orderId);
            }

            return resp;
        } catch (Exception e) {
            System.err.printf(String.valueOf(e));
        }
        resp.put("c", 400);
        resp.put("r", "查询失败！");
        return resp;
    }

    /**
     * 微信订单查询
     * @param orderId
     * @return
     */
    @Path("/wxPayQuery")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> wxPayQuery(String orderId) {
        Map<String, Object> resp = new HashMap<>();
        try {
            Map<String, String> header = tradingHallView.getPostWxPayUrlHeader();
            String paras = tradingHallView.getQueryOrderParas(orderId);
            boolean queryResult =  tradingHallLogical.wxPayOrderEntityStatus(orderId, header, paras);
            if (queryResult) {
                resp.put("c", 200);
                resp.put("r", "买家已付款");
            } else {
                resp.put("c", 201);
                resp.put("r", "买家未付款");
            }

            return resp;
        } catch (Exception e) {
            System.err.printf(String.valueOf(e));
        }
        resp.put("c", 400);
        resp.put("r", "查询失败！");
        return resp;
    }




    @Path("/editOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editOrder(OrderEditReqDto orderEditReqDto) {

        Map<String, Object> resp = new HashMap<>();

        try {
            tradingHallLogical.updateOrderEntity(tradingHallView.getOrderEntity(orderEditReqDto));

            tradingHallLogical.deleteShoppingTrolleyEntityByOrderId(orderEditReqDto.getOrderId());
            for (ShoppingTrolleyEntity shoppingTrolleyEntity : orderEditReqDto.getShoppingTrolleyEntitys()) {
                tradingHallLogical.insertShoppingTrolleyEntity(shoppingTrolleyEntity, orderEditReqDto.getOrderId());
            }
            tradingHallLogical.updatePayerEntity(orderEditReqDto.getPayerEntity());
            tradingHallLogical.updateAddressEntity(orderEditReqDto.getAddressEntity());

            resp.put("c", 200);
            resp.put("r", "修改成功！");

            return resp;
        }catch (Exception e){
            System.err.printf(String.valueOf(e));
        }

        resp.put("c", 400);
        resp.put("r", "修改请求更新到数据失败！");

        return resp;
    }

    @Path("/addPayment")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addPayment(PaymentDto paymentDto) {

        Map<String, Object> resp = new HashMap<>();

        try {
            tradingHallLogical.addPaymentEntity(tradingHallView.getPaymentEntity(paymentDto));

            resp.put("c", 200);
            resp.put("r", "1");
        } catch (Exception e) {
            System.err.println(e);
        }
        resp.put("c", 400);
        resp.put("r", "付款记录存储失败");
        return resp;
    }

    @Path("/addPayee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addPayee(PayeeReqDto payeeReqDto) {

        Map<String, Object> resp = new HashMap<>();
        try {
            tradingHallLogical.addPayeeEntity(tradingHallView.getPayeeEntity(payeeReqDto));

            resp.put("c", 200);
            resp.put("r", "增加开票人信息成功");
            return resp;
        } catch (Exception e) {
            System.err.println(e);
        }
        resp.put("c", 400);
        resp.put("r", "增加开票人信息失败");
        return resp;
    }

    /**
     * 获取支付状态
     * @param paymentAmountReqDto
     * @return
     */
    @Path("/getPaymentAmount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getPaymentAmount(PaymentAmountReqDto paymentAmountReqDto) {

        Map<String, Object> resp = new HashMap<>();
        try {
            // todo
            resp.put("c", 200);
            resp.put("r", "支付情况");
            return resp;
        } catch (Exception e) {
            System.err.println(e);
        }
        resp.put("c", 400);
        resp.put("r", "查询失败");
        return resp;
    }

    @Path("/addInvoicedelivery")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addInvoicedelivery(InvoiceDeliveryReqDto invoiceDeliveryReqDto) {

        Map<String, Object> resp = new HashMap<>();

        String orderKey = UUIDUtil.UString(24); // act as invoiceDelivery id
        String addressKey = UUIDUtil.UString(24);
        try {
            tradingHallLogical.addInvoiceDeliveryEntity(tradingHallView.getInvoiceDeliveryEntity(orderKey, addressKey, invoiceDeliveryReqDto));
            tradingHallLogical.addAddressEntty(tradingHallView.getAddressEntity(addressKey, invoiceDeliveryReqDto));

            resp.put("c", 200);
            resp.put("r", "保存发票邮寄申请信息成功");
            return resp;
        } catch (Exception e) {
            resp.put("c", 400);
            resp.put("r", "保存发票邮寄申请信息失败");
            return resp;
        }
    }

    /**
     * 驳回接口
     * @param rejectReasonReqDto
     * @return
     */
    @Path("/rejectInvoice")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> rejectInvoice(RejectReasonReqDto rejectReasonReqDto) {

        Map<String, Object> resp = new HashMap<>();


        try {
            tradingHallLogical.updateOrderReject(rejectReasonReqDto.getId(), rejectReasonReqDto.getReason(), rejectReasonReqDto.getDesc());

            resp.put("c", 200);
            resp.put("r", "驳回成功");
            return resp;
        } catch (Exception e) {
            resp.put("c", 400);
            resp.put("r", "驳回失败");
            return resp;
        }
    }

    /**
     * 审核通过接口
     * @param passInvoiceReqDto
     * @return
     */
    @Path("/passInvoice")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> passInvoice(PassInvoiceReqDto passInvoiceReqDto) {

        Map<String, Object> resp = new HashMap<>();


        try {
            tradingHallLogical.updateOrderPass(passInvoiceReqDto.getOrderId(), passInvoiceReqDto.getExpressCompany(), passInvoiceReqDto.getExpressTrackingCode());

            resp.put("c", 200);
            resp.put("r", "审核通过");
            return resp;
        } catch (Exception e) {
            resp.put("c", 400);
            resp.put("r", "审核失败");
            return resp;
        }
    }
}
