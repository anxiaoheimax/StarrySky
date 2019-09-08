package com.sky.mapper;

import com.sky.model.Kind;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KindMapper {
    //========================================用id查询=========================================
    @Select("SELECT * FROM kind WHERE kindId=#{kindId}")
    public Kind selectKind(int kindId);

    //========================================查全表===========================================
    @Select("SELECT * FROM kind")
    public List<Kind> findKind();

}
