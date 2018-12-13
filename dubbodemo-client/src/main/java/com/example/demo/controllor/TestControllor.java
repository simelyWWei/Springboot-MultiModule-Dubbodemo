package com.example.demo.controllor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.api.TestDemoApi;
import com.example.demo.model.TestDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllor {

    @Reference(interfaceClass = TestDemoApi.class,check = false)
    private TestDemoApi testDemoApi;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return "Hello World!";
    }

    @RequestMapping(value = "/testdubbo",method = RequestMethod.GET)
    public String testDubbo(){
        String id = "001";
        TestDemo testDemo = testDemoApi.getDemo(id);
        return testDemo.toString();
    }

}
