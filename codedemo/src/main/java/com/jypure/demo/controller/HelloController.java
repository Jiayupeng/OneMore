package com.jypure.demo.controller;

import com.jypure.demo.spring.SpringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/11:42
 */
@RestController
public class HelloController {

    Integer count = 0;

    @Autowired
    private SpringService springService;

    @RequestMapping("/")
    public String hello(){
        return "Hello,greeting by jupure!";

    }

    @RequestMapping("/say")
    public String saySth(){
        return springService.saySth();
    }

    /**
     * 测试内部类
     * @return
     */
    @RequestMapping("/print")
    public String printInner(){

        SpringService.InnerClass inner = springService.getInner();
        System.out.println("print " + count + "次");
        count++;
        return inner.toString();

    }

    /**
     * 测试countDownLatch
     * @return
     */
    @RequestMapping("/exe")
    public String execute(){
        springService.fillInfo();

        return "fill info finished";
    }

}
