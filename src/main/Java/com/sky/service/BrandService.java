package com.sky.service;


import com.sky.mapper.BrandMapper;
import com.sky.mapper.KindMapper;
import com.sky.model.Brand;
import com.sky.model.Kind;
import com.sky.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService {
    @Resource
    BrandMapper brandMapper;
    @Resource
    KindMapper kindMapper;
    /*===========================================================用id查询====================================*/
    public Brand selectBrand(int brandId ){
        return brandMapper.selectBrand(brandId);
    }

    /*=============================================================Brind查全表================================================*/
    public List<Brand> findBrand(){
        return brandMapper.findBrand();
    }

    /*============================================================Kind查全表===============================================*/
    public List<Kind> findKind(){
        return kindMapper.findKind();
    }
    //==========================================================添加=====================================================
    public Boolean addBrand(Brand brand){
        return brandMapper.addBrand(brand)>0;
    }
    //=========================================================删除=============================================
    public Boolean deleteBrand(int brandId){
        return brandMapper.deleteBrand(brandId)>0;
    }
    //===========================================================修改=============================================
    public Boolean updateBrand(Brand brand){
        return brandMapper.updateBrand(brand)>0;
    }
    //=============================================================分页查询================================
    public Page<Brand> findByPageBrand(Page<Brand> pageBean){
        pageBean.setTotalRows(brandMapper.countBrand(pageBean));
        pageBean.setDatas(brandMapper.findBrandByPage(pageBean));
        return pageBean;
    }

}
