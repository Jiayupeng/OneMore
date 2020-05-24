package com.jypure.demo.controller;

import com.jypure.demo.spring.CommonService;

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
    private CommonService commonService;

    @RequestMapping("/")
    public String hello(){
        return "Hello,greeting by jupure!";

    }

    @RequestMapping("/say")
    public String saySth(){
        return commonService.saySth();
    }

    /**
     * 测试内部类
     * @return
     */
    @RequestMapping("/print")
    public String printInner(){

        CommonService.InnerClass inner = commonService.getInner();
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
        commonService.fillInfo();

        return "fill info finished";
    }

}
