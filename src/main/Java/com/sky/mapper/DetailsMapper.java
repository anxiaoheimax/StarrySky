package com.sky.mapper;

import com.sky.model.Details;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DetailsMapper {
    //===============================================添加===============================
    @Insert("INSERT INTO `details`(orderId,liquorId,number) VALUES(#{orderId},#{liquorId},#{number})")
    public int addDetails(Details details);
    //====================================================删除============================
    @Delete("DELETE FROM `details` WHERE orderId=#{orderId}")
    public int deleteDetails(int orderId);
    //=============================================条件查询==================================
    @Select("SELECT *FROM `details`where orderId=#{orderId} ORDER BY orderId DESC")
    public List<Details> findDetails(int orderId);
}
