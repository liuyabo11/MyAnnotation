package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @MyAnnotation("ceshi")
    @RequestMapping("/add1")
    public String addData1() {
        //System.out.println("=====addData1=====");
        return "success";
    }

//    @MyAnnotation()
//    @RequestMapping("/add2")
//    public String addData2(String deviceId) {
//        System.out.println("=====addData2=====");
//        return "success";
//    }
//
//    @MyAnnotation()
//    @RequestMapping("/add3")
//    public String addData3(String deviceId) {
//        System.out.println("=====addData3=====");
//        return "success";
//    }
//
//    @MyAnnotation()
//    @RequestMapping("/update1")
//    public String updateData1(String deviceId) {
//        System.out.println("=====updateData1=====");
//        return "success";
//    }



}
