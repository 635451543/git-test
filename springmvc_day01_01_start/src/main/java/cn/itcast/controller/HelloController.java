package cn.itcast.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制类
@Controller
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello springmvc");
        return "success";
    }
}
