package com.sky.mapper;

import com.sky.model.Jrd;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JrdMapper {
    //查全表
    @Select("SELECT * FROM jurisdiction")
     public List<Jrd> selectJrd();
    //查id
    @Select("SELECT jurisdiction.`jrdId`,jrdName title,url href,spId FROM grade,jurisdiction WHERE grade.`jrdId`=jurisdiction.`jrdId`AND uId=#{uId}")
    public List<Jrd> findJrd(int uId);
}
