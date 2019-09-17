package com.sky.Controller;

import com.sky.model.Jrd;
import com.sky.service.JrdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/Jrd")
public class JrdController {
    @Resource
    JrdService jrdService;

    @ResponseBody
    @RequestMapping("/findJrdByRid.action")
    public List<Jrd> findJrdByRid(int uId){
        System.out.println("jingru ；"+uId);
        return jrdService.findJrd(uId);
    }
}
