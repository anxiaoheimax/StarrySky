package com.sky.service;

import com.sky.mapper.DetailsMapper;
import com.sky.model.Details;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DetailsService {
    @Resource
    DetailsMapper detailsMapper;
    //========================================添加=======================================
    @Transactional
    public Boolean addDetails(Details details){
        return detailsMapper.addDetails(details)>0;
    }
    //==========================================删除===================================
    @Transactional
    public Boolean deleteDetails(int orderId){
        return detailsMapper.deleteDetails(orderId)>0;
    }
    //=========================================查询====================================
    public List<Details> findDetails(int orderId){
        return detailsMapper.findDetails(orderId);
    }


}
