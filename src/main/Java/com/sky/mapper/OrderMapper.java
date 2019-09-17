package com.sky.mapper;

import com.sky.model.Order;
import com.sky.model.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {
    //==================================================添=加=================================================
    @Insert("INSERT INTO `order`(Uid,compId,money,order_date,payment)" +
            " VALUES(#{Uid},#{compId},#{money},#{order_date},#{payment})")
    @Options(useGeneratedKeys=true, keyProperty="orderId", keyColumn="id")
    public int addOrder(Order order);
    //==================================================删除===========================================
    @Delete("DELETE FROM `order` WHERE orderId=#{orderId};")
    public int deleteOrder(int orderId);
    //Uid,compId,money,order_date,payment
    //=================================================分页查询======================================================
    @Select("<script>" +
            "SELECT orderId,Uid,compId,money,payment,order_date FROM `order`" +
            " where 1=1" +
            "<if test='condition.Uid!=null'> AND Uid=#{condition.Uid}</if>" +
            "<if test='condition.compId!=null'> AND compId=#{condition.compId}</if>" +
            "<if test='condition.money!=null'> AND money>=#{condition.money}</if>" +
            " ORDER BY orderId DESC LIMIT #{startIndex},#{pageRows}" +
            "</script>")
    public List<Order> findBypageOrder(Page<Order> pageBean);
    //==========================================查记录数============================================
    @Select("<script>" +
            "SELECT COUNT(*) FROM `order`" +
            " where 1=1" +
            "<if test='condition.Uid!=null'> AND Uid=#{condition.Uid}</if>" +
            "<if test='condition.compId!=null'> AND compId=#{condition.compId}</if>" +
            "<if test='condition.money!=null'> AND money>=#{condition.money}</if>" +
            "</script>")
    public int countOrder(Page<Order> pageBean);

    //修改
    @Update("UPDATE `order` SET payment=#{payment} WHERE orderId=#{orderId};")
    public int updateOrder(Order order);


    /*查月销售额*/
}
