package com.sky.service;

import com.sky.mapper.CompartmentMapper;
import com.sky.model.Compartment;
import com.sky.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompartmentService {
    @Resource
    CompartmentMapper compartmentMapper;
    //============================================添加============================================
    public Boolean addCompartment(Compartment compartment){
        return compartmentMapper.addCompartment(compartment)>0;
    }
    //============================================修改=========================================================
    public Boolean updateCompartment(Compartment compartment){
        return compartmentMapper.updateCompartment(compartment)>0;
    }
    //==============================================删除=========================================================
    public Boolean deleteCompartment(int compId){
        return compartmentMapper.deleteCompartment(compId)>0;
    }
    //=======================================查询==================================================
    public Page<Compartment> findByPageCompartment(Page<Compartment> pageBean){
        //查记录数
        pageBean.setTotalRows(compartmentMapper.countCompartment(pageBean));
        pageBean.setDatas(compartmentMapper.findByPageCompartment(pageBean));
        return pageBean;
    }
    //==================================================预定或退订===============================================================
    public Boolean reserveOrUnsubscribe(Compartment compartment){
        return compartmentMapper.reserveOrUnsubscribe(compartment)>0;
    }


}
