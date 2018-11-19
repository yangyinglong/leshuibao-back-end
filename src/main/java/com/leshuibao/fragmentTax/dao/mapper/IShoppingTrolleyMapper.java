package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.ShoppingTrolleyEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IShoppingTrolleyMapper {
    @Select("SELECT `id`, `order_id`, `goods_name`, `goods_type`, `measure_unit`, `buyed_num`, `price`, `sales_volume`, `tax`, `tax_amount`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `shopping_trolley`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsType", column = "goods_type"),
            @Result(property = "measureUnit", column = "measure_unit"),
            @Result(property = "buyedNum", column = "buyed_num"),
            @Result(property = "price", column = "price"),
            @Result(property = "salesVolume", column = "sales_volume"),
            @Result(property = "tax", column = "tax"),
            @Result(property = "taxAmount", column = "tax_amount"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<ShoppingTrolleyEntity> queryAll();

    @Select("SELECT `id`, `order_id`, `goods_name`, `goods_type`, `measure_unit`, `buyed_num`, `price`, `sales_volume`, `tax`, `tax_amount`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `shopping_trolley` WHERE `order_id` = #{order_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsType", column = "goods_type"),
            @Result(property = "measureUnit", column = "measure_unit"),
            @Result(property = "buyedNum", column = "buyed_num"),
            @Result(property = "price", column = "price"),
            @Result(property = "salesVolume", column = "sales_volume"),
            @Result(property = "tax", column = "tax"),
            @Result(property = "taxAmount", column = "tax_amount"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<ShoppingTrolleyEntity> queryByOrderId(@Param("order_id") String order_id);

    @Select("SELECT `id`, `order_id`, `goods_name`, `goods_type`, `measure_unit`, `buyed_num`, `price`, `sales_volume`, `tax`, `tax_amount`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `shopping_trolley` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsType", column = "goods_type"),
            @Result(property = "measureUnit", column = "measure_unit"),
            @Result(property = "buyedNum", column = "buyed_num"),
            @Result(property = "price", column = "price"),
            @Result(property = "salesVolume", column = "sales_volume"),
            @Result(property = "tax", column = "tax"),
            @Result(property = "taxAmount", column = "tax_amount"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    ShoppingTrolleyEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `shopping_trolley`(`id`, `order_id`, `goods_name`, `goods_type`, `measure_unit`, `buyed_num`, `price`, `sales_volume`, `tax`, `tax_amount`, `status`, `memo`, `created_time`) VALUES(#{id}, #{orderId}, #{goodsName}, #{goodsType}, #{measureUnit}, #{buyedNum}, #{price}, #{salesVolume}, #{tax}, #{taxAmount}, #{status}, #{memo}, #{createdTime})")
    void insert(ShoppingTrolleyEntity shopping_trolleyEntity);

    @Update("UPDATE `shopping_trolley` SET id=#{id}, order_id=#{orderId}, goods_name=#{goodsName}, goods_type=#{goodsType}, measure_unit=#{measureUnit}, buyed_num=#{buyedNum}, price=#{price}, sales_volume=#{salesVolume}, tax=#{tax}, tax_amount=#{taxAmount}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(ShoppingTrolleyEntity shopping_trolleyEntity);

    @Delete("DELETE FROM `shopping_trolley` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Delete("DELETE FROM `shopping_trolley` WHERE `order_id` = #{orderId}")
    void deleteByOrderId(@Param("orderId") String orderId);

}