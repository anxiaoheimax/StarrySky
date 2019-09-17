package com.sky.service;

import com.sky.mapper.JrdMapper;
import com.sky.model.Jrd;
import com.sky.util.JrdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JrdService {
    @Resource
    JrdMapper jrdMapper;
    //查全表
    public List<Jrd> selectJrd(){
        return jrdMapper.selectJrd();
    }
    //查id
    public List<Jrd> findJrd(int uId){
        return JrdUtil.toTree(jrdMapper.findJrd(uId));
    }
}
