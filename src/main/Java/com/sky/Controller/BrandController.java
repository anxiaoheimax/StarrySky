package com.sky.Controller;

import com.sky.model.Brand;
import com.sky.model.Kind;
import com.sky.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

}
