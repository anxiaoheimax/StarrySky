package com.sky.Controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sky.model.Liquor;
import com.sky.model.Page;
import com.sky.service.LiquorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Liquor")
public class LiquorController {
    @Resource
    LiquorService liquorService;

    //添加
    @ResponseBody
    @RequestMapping("/addLiquor.action")
    public String  addLiquor(@RequestBody Liquor liquor){
        Boolean insertLiquor = liquorService.insertLiquor(liquor);
        if(insertLiquor){
            return "ok";
        }else{
           return "no";
        }

    }
    //删除
    @ResponseBody
    @RequestMapping("/deleteLiquor.action")
    public String deleteLiquor(int liquorId){
        System.out.println("================shanchu ===================");
        System.out.println("前端传递的id"+liquorId);
        Boolean deleteLiquor = liquorService.deleteLiquor(liquorId);
        if(deleteLiquor){
            return "ok";
        }else{
            return "no";
        }
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateLquor.action")
    public String updateLquor(@RequestBody Liquor liquor){
        Boolean updateLiquor = liquorService.updateLiquor(liquor);
        if(updateLiquor){
            return "ok";
        }else{
            return "no";
        }
    }
    //用id查单个
    @RequestMapping("/selectLiquor.action")
    public ModelAndView selectLiquor(int id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("findbyid");
        Liquor liquor = liquorService.findLiquorByid(id);
        System.out.println("查询Byid："+liquor);
        modelAndView.addObject("liquor",liquor);
        return modelAndView;
    }
    //tiaojian分页查
    @ResponseBody
    @RequestMapping("/findPage.action")
    public HashMap findPage(Page<Liquor> liquorPage){
System.out.println(liquorPage.getPageNow()+""+liquorPage.getPageRows());
        Page<Liquor> liquorByPage = liquorService.findLiquorByPage(liquorPage);
        System.out.println("=======查找========="+liquorByPage);
        HashMap findByPage=new HashMap();
        findByPage.put("code",0);
        findByPage.put("msg","");
        findByPage.put("count",liquorByPage.getTotalRows());
        findByPage.put("data",liquorByPage.getDatas());
        return findByPage;
    }
}
