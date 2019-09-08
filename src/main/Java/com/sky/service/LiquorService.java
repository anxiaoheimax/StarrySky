package com.sky.service;

import com.sky.mapper.LiquorMapper;
import com.sky.model.Liquor;
import com.sky.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LiquorService {

    @Resource
    LiquorMapper liquorMapper;
    //用id查

    public Liquor findLiquorByid(int id){

      return liquorMapper.selectliquorById(id);
    }
    //==================================查总记录数

    public int Liquorcount(Page<Liquor> pageBean){

        return liquorMapper.selectcount(pageBean);
    }
    //=====================================条件分页查询

    public Page<Liquor> findLiquorByPage(Page<Liquor> pageBean){
        //查询记录数   并向Page中赋值
        pageBean.setTotalRows(liquorMapper.selectcount(pageBean));
        System.out.println(liquorMapper.selectcount(pageBean));
        List<Liquor> liquorList = liquorMapper.selectliquorByPage(pageBean);
        pageBean.setDatas(liquorList);
        return pageBean;
    }
    //======================================修改
    @Transactional
    public Boolean  updateLiquor(Liquor liquor){
        return liquorMapper.updateliquor(liquor)>0;

    }
    //========================================添加
    @Transactional
    public Boolean  insertLiquor(Liquor liquor){
        return liquorMapper.insertLiquor(liquor)>0;

    }
    //============================================删除
    @Transactional
    public Boolean deleteLiquor(int id){
         return liquorMapper.deleteliquor(id)>0;
    }
}
