package com.sky.mapper;

import com.sky.model.Liquor;
import com.sky.model.Page;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface LiquorMapper {
    //用id查
    @Select("SELECT liquorId,liquor_name,brandId,origin,price,production_date,alcoholic_strength,picture,kindId" +
            " FROM liquor" +
            " WHERE liquor.`liquorId`=#{liquorId}")

    public Liquor selectliquorById(int id);
    //查总记录数
    @Select("<script>"+
            "SELECT COUNT(*) FROM liquor" +
            " WHERE 1=1" +
            "<if test='condition.liquor_name!=null'>"+
            "AND liquor_name like CONCAT('%',#{condition.liquor_name},'%')</if>"+
            "</script>")
    public int selectcount(Page<Liquor> pageBean);

    //===============================================条件分页查================================================================================
    @Select("<script>"+
            "SELECT liquorid,liquor_name,brand.*,origin,price,production_date,alcoholic_strength,picture,kind.*" +
            "FROM liquor,brand,kind"+
            " WHERE liquor.`brandId`=brand.`brandId`" +
            " AND liquor.`kindId`=kind.`kindId`"+
            "<if test='condition.liquor_name!=null'>"+
            "AND liquor_name like CONCAT('%',#{condition.liquor_name},'%') "+
            "</if>"+
            "ORDER BY liquorId DESC LIMIT #{startIndex},#{pageRows}"+
            "</script>")
    @Results(value = {
            @Result(id = true,property = "liquorId",column = "liquorId"),
            @Result(property = "liquor_name",column = "liquor_name"),
            @Result(property = "brand",one = @One(select ="com.sky.mapper.BrandMapper.selectBrand"),column = "brandId"),
            @Result(property = "origin",column = "origin"),
            @Result(property = "price",column = "price"),
            @Result(property = "production_date",column = "production_date"),
            @Result(property = "alcoholic_strength",column = "alcoholic_strength"),
            @Result(property = "picture",column = "picture"),
            @Result(property = "kind",one = @One(select ="com.sky.mapper.KindMapper.selectKind"),column = "kindId")

    })
    public List<Liquor> selectliquorByPage(Page<Liquor> pageBean);
    //==============================================添加==============================================================================
    @Insert("INSERT INTO liquor(liquor_name,brandId,origin,price,production_date,alcoholic_strength,kindId) " +
            "VALUES (#{liquor_name},#{brand.brandId},#{origin},#{price},#{production_date},#{alcoholic_strength},#{kind.kindId})")
    public int insertLiquor(Liquor liquor);
    //修改
    @Update("UPDATE liquor SET liquor_name=#{liquor_name},origin=#{origin},price=#{price},alcoholic_strength=#{alcoholic_strength} WHERE liquorId=#{liquorId};")
    public int updateliquor(Liquor liquor);
    //删除
    @Delete("DELETE FROM liquor WHERE liquorId=#{id}")
    public int deleteliquor(int id);
}
