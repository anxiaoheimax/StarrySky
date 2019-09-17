package com.sky.Controller;

import com.sky.model.Compartment;
import com.sky.model.Page;
import com.sky.service.CompartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Compartment")
public class CompartmentController {
    @Resource
    CompartmentService compartmentService;
    //添加
    @ResponseBody
    @RequestMapping("/addCompartment.action")
    public String addCompartment(@RequestBody Compartment compartment ){
        Boolean addComp = compartmentService.addCompartment(compartment);
        if(addComp){
            return "ok";
        }else{
            return "no";
        }
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateCompartment.action")
    public String updateCompartment(@RequestBody Compartment compartment ){
        Boolean updateComp = compartmentService.updateCompartment(compartment);
        if(updateComp){
            return "ok";
        }else{
            return "no";
        }
    }
    //删除
    @ResponseBody
    @RequestMapping("/deleteCompartment.action")
    public String deleteCompartment(int compTd){
        System.out.println("shanchu++++++++++++++++++++="+compTd);
        Boolean deleteComp = compartmentService.deleteCompartment(compTd);
        if(deleteComp){
            return "ok";
        }else{
            return "no";
        }
    }
    //分页
    @ResponseBody
    @RequestMapping("/findByPageComp.action")
    public HashMap findByPageCompartment(Page<Compartment> pageBean){
        Page<Compartment> byPageCompartment = compartmentService.findByPageCompartment(pageBean);
        HashMap findByPage=new HashMap();
        findByPage.put("code",0);
        findByPage.put("msg","");
        findByPage.put("count",byPageCompartment.getTotalRows());
        findByPage.put("data",byPageCompartment.getDatas());
        return findByPage;
    }
    //预定或者退订
    @ResponseBody
    @RequestMapping("/reserveOrUnsubscribe.action")
    public String reserveOrUnsubscribe(@RequestBody Compartment compartment){
        Boolean rOu = compartmentService.reserveOrUnsubscribe(compartment);

        if(rOu){
            return "ok";
        }else{
            return "no";
        }
    }


    @ResponseBody
    @RequestMapping("/selectcomp.action")
    public List<Compartment> selectcomp(){
        List<Compartment> selectcomp = compartmentService.selectcomp();
        System.out.println("kongxiang:"+selectcomp);
        return selectcomp;
    }

}
