package com.leshuibao.fragmentTax.controller.endpoint;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.ShowOrdersReqDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrderDtlRespDto;
import com.leshuibao.fragmentTax.dto.response.ShowOrdersRespDto;
import com.leshuibao.fragmentTax.logicalModel.ITradingHallLogical;
import com.leshuibao.fragmentTax.util.FormatUtil;
import com.leshuibao.fragmentTax.viewModel.ITradingHallView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/tradingHall")
@CrossOrigin
public class TradingHallShowController {

    @Autowired
    private ITradingHallView tradingHallView;

    @Autowired
    private ITradingHallLogical tradingHallLogical;

    //todo
    @Path("/showUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showUser() {
        return null;
    }

    @Path("/showPayee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayee(String userId) {
        Map<String, Object> resp = new HashMap<>();
        List<PayeeEntity> payeeEntitys = tradingHallLogical.getPayeeEntitys(userId);
        if (!FormatUtil.isEmpty(payeeEntitys)) {
            resp.put("c", 200);
            resp.put("r", payeeEntitys);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "您没有添加过开票人，请到个人中心添加开票人信息！");
        return resp;
    }

    @Path("/showPayeeByOrderid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayeeByOrderId(String orderId) {
        Map<String, Object> resp = new HashMap<>();
        PayeeEntity payeeEntity = tradingHallLogical.getPayeeEntity(orderId);
        if (!FormatUtil.isEmpty(payeeEntity)) {
            resp.put("c", 200);
            resp.put("r", payeeEntity);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "您没有添加过开票人，请到个人中心添加开票人信息！");
        return resp;
    }

    @Path("/showPayer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayer(String userId) {
        Map<String, Object> resp = new HashMap<>();
        List<PayerEntity> payerEntity = tradingHallLogical.getPayerEntitys(userId);
        if (!FormatUtil.isEmpty(payerEntity)) {
            resp.put("c", 200);
            resp.put("r", payerEntity);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "no this userId");
        return resp;
    }

    @Path("/showPayerByOrderId")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayerByOrderId(String orderId) {
        Map<String, Object> resp = new HashMap<>();
        PayerEntity payerEntity = tradingHallLogical.getPayerEntity(orderId);
        if (!FormatUtil.isEmpty(payerEntity)) {
            resp.put("c", 200);
            resp.put("r", payerEntity);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "no this userId");
        return resp;
    }

    @Path("/showAddress")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showAddress(String id) {
        Map<String, Object> resp = new HashMap<>();
        AddressEntity addressEntity = tradingHallLogical.getAddrEntity(id);
        if (!FormatUtil.isEmpty(addressEntity)) {
            resp.put("c", 200);
            resp.put("r", tradingHallView.getAddrResp(addressEntity));
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "no this userId");
        return resp;
    }

    @Path("/showGoods")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showGoods(String orderId) {

        Map<String, Object> resp = new HashMap<>();
        List<ShoppingTrolleyEntity> shoppingTrolleyEntityList = tradingHallLogical.getGoodsEntityByOrderId(orderId);
        if (!FormatUtil.isEmpty(shoppingTrolleyEntityList)) {
            resp.put("c", 200);
            resp.put("r", shoppingTrolleyEntityList);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "no this userId");
        return resp;

    }

    @Path("/showOrders")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrders(ShowOrdersReqDto showOrdersReqDto) {

        Map<String, Object> resp = new HashMap<>();

        List<ShowOrdersRespDto> showOrdersRespDtos = tradingHallLogical.getShowOrdersRespDtos(showOrdersReqDto);
        if (!FormatUtil.isEmpty(showOrdersRespDtos)) {
            resp.put("c", 200);
            resp.put("r", showOrdersRespDtos);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "没有订单！");
        return resp;
    }

    @Path("/showOrdersForAdmin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrdersForAdmin(ShowOrdersReqDto showOrdersReqDto) {

        Map<String, Object> resp = new HashMap<>();

        List<ShowOrdersRespDto> showOrdersRespDtos = tradingHallLogical.getShowOrdersRespDtosForAdmin(showOrdersReqDto);
        if (!FormatUtil.isEmpty(showOrdersRespDtos)) {
            resp.put("c", 200);
            resp.put("r", showOrdersRespDtos);
            return resp;
        }
        resp.put("c", 400);
        resp.put("r", "没有订单！");
        return resp;
    }

    @Path("/showOrderDtl")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrderDtl(String orderId) {

        Map<String, Object> resp = new HashMap<>();

        OrderEntity orderEntity = tradingHallLogical.getOrderEntity(orderId);
        if (FormatUtil.isEmpty(orderEntity)) {
            resp.put("c", 400);
            resp.put("r", "没有此订单！");
            return resp;
        }

        ShowOrderDtlRespDto orderDtlRespDto = new ShowOrderDtlRespDto(
                orderEntity,
                tradingHallLogical.getPayeeEntity(orderId),
                tradingHallLogical.getPayerEntity(orderId),
                tradingHallLogical.getGoodsEntityByOrderId(orderId),
                tradingHallLogical.getAddrEntity(orderEntity.getAddressId())
        );
        resp.put("c", 200);
        resp.put("r", orderDtlRespDto);
        return resp;
    }
}
