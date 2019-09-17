package com.sky.mapper;

import com.sky.model.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartItemMapper{
    //添加
    @Insert("INSERT INTO `cart`(liquorId,number,total_price,Uid) " +
            "VALUES(#{liquorId},#{number},#{total_price},#{uid})")
    public int addCartItem(CartItem cartItem);
    //删除
    @Delete("DELETE FROM `cart` WHERE cartId=#{cartID}")
    public int deleteCartItem(int cartId);
    //清空购物车
    @Delete("DELETE FROM `cart` WHERE Uid=#{Uid}")
    public int deleteByUid(int Uid);
    //修改
    @Update("UPDATE `cart` SET number=#{number},total_price=#{total_price} WHERE cartId=#{cartId}")
    public int updateCartItem(CartItem cartItem);
    //查询
    @Select("SELECT * FROM `cart` WHERE Uid=#{Uid} ORDER BY cartId DESC")
    @Results(value = {
            @Result(id = true,property = "cartId",column = "cartId"),
            @Result(property = "liquorId",column = "liquorId"),
            @Result(property = "number",column = "number"),
            @Result(property = "total_price",column = "total_price"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "liquor",one = @One(select ="com.sky.mapper.LiquorMapper.selectliquorById"),column = "liquorId")

    })
    public List<CartItem> findByUid(int Uid);














    //通过uid 和liquorId  进行查询
    @Select("SELECT * FROM `cart` where Uid=#{uid} and liquorId=#{liquorId}")
    public CartItem findByUidlId(CartItem cartItem);

}
