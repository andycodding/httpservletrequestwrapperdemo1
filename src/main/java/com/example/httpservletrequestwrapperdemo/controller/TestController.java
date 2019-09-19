package com.example.httpservletrequestwrapperdemo.controller;

import com.example.httpservletrequestwrapperdemo.compont.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/param")
    public Object param(String uid,String name){
        System.out.println(uid);
        return uid;
    }


    @GetMapping("/bean")
    private Object gets(User user){
        System.out.println(user.getName()+user.getUid());
        return user;
    }

    @GetMapping("/bean2")
    private Object getsss(User user){
        System.out.println(user.getName()+user.getUid());
        return user;
    }


}
