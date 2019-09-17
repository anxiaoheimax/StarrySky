package com.sky.Controller;

import com.sky.model.Brand;
import com.sky.model.Compartment;
import com.sky.model.Kind;
import com.sky.model.Page;
import com.sky.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Brand")
public class BrandController {
    @Resource
    BrandService brandService;
    /*============================================Brand查全表====================================*/
    @ResponseBody
    @RequestMapping("/findBrand.action")
    public List<Brand> findBrand(){
       return brandService.findBrand();
    }
    /*==========================================Kind查全表=============================================================*/
    @ResponseBody
    @RequestMapping("/findKind.action")
    public List<Kind> findKind(){
        return brandService.findKind();
    }
    //===========================================================添加===========================================================
    @ResponseBody
    @RequestMapping("/addBrand.action")
    public String addBrand(@RequestBody Brand brand){
        System.out.println("品牌："+brand);
        Boolean addBrand = brandService.addBrand(brand);
        if(addBrand){
            return "ok";
        }else{
            return "no";
        }
    }
    //==========================================================删除===============================================================
    @ResponseBody
    @RequestMapping("/deleteBrand.action")
    public String deleteBrand(int brandId){
        System.out.println("shanchi :"+brandId);
        Boolean deleteBrand =brandService.deleteBrand(brandId);
        if(deleteBrand){
            return "ok";
        }else{
            return "no";
        }
    }
    //=====================================================修改==========================================================
    @ResponseBody
    @RequestMapping("/updateBrand.action")
    public String updateBrand(@RequestBody Brand brand){
        Boolean updateBrand =brandService.updateBrand(brand);
        if(updateBrand){
            return "ok";
        }else{
            return "no";
        }
    }
    //分页查询
    @ResponseBody
    @RequestMapping("/findByPageBrand.action")
    public HashMap findByPageBrand(Page<Brand> pageBean){
        Page<Brand> byPageBrand = brandService.findByPageBrand(pageBean);
        HashMap findByPage=new HashMap();
        findByPage.put("code",0);
        findByPage.put("msg","");
        findByPage.put("count",byPageBrand.getTotalRows());
        findByPage.put("data",byPageBrand.getDatas());
        return findByPage;
    }













}
