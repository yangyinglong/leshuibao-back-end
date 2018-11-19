package com.leshuibao.fragmentTax.dto.response;

import com.leshuibao.fragmentTax.dao.entity.*;

import java.util.List;

public class ShowOrderDtlRespDto {

    private OrderEntity orderEntity;
    private PayeeEntity payeeEntity;
    private PayerEntity payerEntity;
    private List<ShoppingTrolleyEntity> shoppingTrolleyEntities;
    private AddressEntity addressEntity;

    public ShowOrderDtlRespDto() {
    }

    public ShowOrderDtlRespDto(OrderEntity orderEntity, PayeeEntity payeeEntity, PayerEntity payerEntity, List<ShoppingTrolleyEntity> shoppingTrolleyEntities, AddressEntity addressEntity) {
        this.orderEntity = orderEntity;
        this.payeeEntity = payeeEntity;
        this.payerEntity = payerEntity;
        this.shoppingTrolleyEntities = shoppingTrolleyEntities;
        this.addressEntity = addressEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public PayeeEntity getPayeeEntity() {
        return payeeEntity;
    }

    public void setPayeeEntity(PayeeEntity payeeEntity) {
        this.payeeEntity = payeeEntity;
    }

    public PayerEntity getPayerEntity() {
        return payerEntity;
    }

    public void setPayerEntity(PayerEntity payerEntity) {
        this.payerEntity = payerEntity;
    }

    public List<ShoppingTrolleyEntity> getShoppingTrolleyEntities() {
        return shoppingTrolleyEntities;
    }

    public void setShoppingTrolleyEntities(List<ShoppingTrolleyEntity> shoppingTrolleyEntities) {
        this.shoppingTrolleyEntities = shoppingTrolleyEntities;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
