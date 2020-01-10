package com.mj.myvedio.controllers;

import com.mj.myvedio.utils.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response<String> login(String userName, String password){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken  token = new UsernamePasswordToken(userName,password);
            token.setRememberMe(true);
            subject.logout();
            try {
                subject.login(token);
            }catch (Exception ex){
                return Response.createError("登录失败："+ ex.getMessage());
            }
            return Response.createSuccess("登录成功", "1111111111");
        }

        return Response.createSuccess("登录成功");
    }
}
