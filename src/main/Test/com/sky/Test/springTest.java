package com.sky.Test;

import com.sky.model.Brand;
import com.sky.model.Kind;
import com.sky.model.Liquor;
import com.sky.model.Page;
import com.sky.service.BrandService;
import com.sky.service.LiquorService;
import com.sky.util.DateUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class springTest {
   /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("MySpring.xml");
    //查酒品   通过id
    @Test
    public void test1(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        System.out.println(liquorService.findLiquorByid(2));
    }
    //查酒品牌    通过id
    @Test
    public void test2(){
        BrandService brnadService= (BrandService) applicationContext.getBean("brandService");
        System.out.println(brnadService.selectBrand(2));
    }
   *//* //查记录总数
    @Test
    public void test3(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        int liquorcount = liquorService.Liquorcount(new HashMap());
        System.out.println(liquorcount);
    }*//*
    //分页查酒品
   *//* @Test
    public void test4(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        Page<Liquor> page=new Page();
        page.setPageNow(1);//当前页数
        page.setPageRows(3);//每页显示记录数
        HashMap condition=new HashMap();
        Page<Liquor> liquorByPage = liquorService.findLiquorByPage(page, condition);
        System.out.println("page===="+liquorByPage);

    }*//*

    //修改
    @Test
    public void updateliquor(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        Boolean updatenumber=liquorService.updateLiquor(new Liquor(5,128));
        System.out.println("修改记录数："+updatenumber);

    }
    //删除
    @Test
    public void deleteliquor(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        Boolean updatenumber=liquorService.deleteLiquor(7);
        //System.out.println("删除记录数："+updatenumber);

    }
    //添加
    @Test
    public void insertLiquor(){
        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        //Boolean updatenumber=liquorService.insertLiquor(new Liquor("朋克",new Brand(1),"英国",102, DateUtil.StringtoDate("1999-10-01"),5.6f,new Kind(2)));
        //System.out.println("添加记录数："+updatenumber);

    }


    //条件分页查询
    @Test
    public void findByPage(){
        Page<Liquor> page=new Page();

        LiquorService liquorService = (LiquorService) applicationContext.getBean("liquorService");
        System.out.println(liquorService.findLiquorByPage(page));
    }














*/
}
