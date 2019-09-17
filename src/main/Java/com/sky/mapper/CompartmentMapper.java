package com.sky.mapper;

import com.sky.model.Compartment;
import com.sky.model.Liquor;
import com.sky.model.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompartmentMapper {
    //============================================添加=======================================================
    @Insert("INSERT INTO compartment(compName,compState,comptype) VALUES(#{compName},1,#{comptype})")
    public int addCompartment(Compartment compartment);
    //==============================================修改=======================================================
    @Update("UPDATE compartment SET compName=#{compName},comptype=#{comptype} WHERE compId=#{compId}")
    public int updateCompartment(Compartment compartment);
    //===============================================删除==============================================
    @Delete("DELETE FROM compartment WHERE compId=#{compId};")
    public int deleteCompartment(int compId);
    //==============================================条件分页查询 =====================================
    @Select("<script>" +
            "SELECT *FROM compartment" +
            " where 1=1" +
            "<if test='condition.compName!=null'>" +
            " AND compName like CONCAT('%',#{condition.compName},'%')" +
            "</if>" +
            " ORDER BY compId DESC LIMIT #{startIndex},#{pageRows}" +
            "</script>")
    public List<Compartment> findByPageCompartment(Page<Compartment> pageBean);
    //================================================查总记录数=========================================
    @Select("<script>" +
            "SELECT COUNT(*) FROM compartment" +
            " where 1=1" +
            "<if test='condition.compName!=null'>" +
            "AND compName like CONCAT('%',#{condition.compName},'%')</if>" +
            "</script>")
    public int countCompartment(Page<Compartment> pageBean);
    //==============================================预定/退订==============================================
    @Update("UPDATE compartment SET compState=#{compState},reserve_date=#{reserve_date} WHERE compId=#{compId}")
    public int reserveOrUnsubscribe(Compartment compartment);

    //查空闲
    @Select("SELECT * FROM compartment where compState=1")
    public List<Compartment> selectcomp();
}
