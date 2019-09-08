package com.sky.mapper;

import com.sky.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    //id查询
    @Select("SELECT brandId,brandName FROM brand WHERE brandId=#{brandId}")
    public Brand selectBrand(int brandId);
    //查询全表
    @Select("SELECT brandId,brandName FROM brand")
    public List<Brand> findBrand();
}
