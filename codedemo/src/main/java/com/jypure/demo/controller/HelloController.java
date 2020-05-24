package com.jypure.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/11:42
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){

        return "Hello,greeting by jupure!";

    }

}
