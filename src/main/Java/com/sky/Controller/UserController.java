package com.sky.Controller;

import com.sky.model.User;
import com.sky.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping("/fondUser.action")
    public String fondUser(HttpSession session, String userName, String password){

        User user = userService.findUser(userName);
        if(password.equals(user.getUpassword())){
            session.setAttribute("user",user);
            return "ok";
        }else {
            return "no";
        }
    }
}
