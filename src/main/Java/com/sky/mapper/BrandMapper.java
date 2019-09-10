package com.sky.mapper;

import com.sky.model.Brand;
import com.sky.model.Compartment;
import com.sky.model.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandMapper {
    //id查询
    @Select("SELECT brandId,brandName FROM brand WHERE brandId=#{brandId}")
    public Brand selectBrand(int brandId);
    //查询全表
    @Select("SELECT brandId,brandName FROM brand")
    public List<Brand> findBrand();
    //添加
    @Insert("INSERT INTO brand(brandName) VALUES(#{brandName})")
    public int addBrand(Brand brand);
    //删除
    @Delete("DELETE FROM brand WHERE brandId=#{brandId}")
    public int deleteBrand(int brandId);
    //修改
    @Update("UPDATE brand SET brandName=#{brandName} WHERE brandId=#{brandId}")
    public int updateBrand(Brand brand);
    //分页查询
    @Select("<script>" +
            "SELECT *FROM brand" +
            " where 1=1" +
            "<if test='condition.brandName!=null'>" +
            " AND brandName like CONCAT('%',#{condition.brandName},'%')" +
            "</if>" +
            " ORDER BY brandId DESC LIMIT #{startIndex},#{pageRows}" +
            "</script>")
    public List<Brand> findBrandByPage(Page<Brand> pageBean);
    //================================================查总记录数=========================================
    @Select("<script>" +
            "SELECT COUNT(*) FROM brand" +
            " where 1=1" +
            "<if test='condition.brandName!=null'>" +
            "AND brandName like CONCAT('%',#{condition.brandName},'%')</if>" +
            "</script>")
    public int countBrand(Page<Brand> pageBean);

}
