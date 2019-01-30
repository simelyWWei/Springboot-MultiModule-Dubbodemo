package com.example.demo.controllor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.api.TestDemoApi;
import com.example.demo.model.TestDemo;
import com.example.demo.param.DemoParam;
import com.example.demo.validator.group.CheckSequence;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
    public String testDubbo(@Validated({CheckSequence.class}) DemoParam params, BindingResult result){
        if (result.hasErrors()) {
            if(result.hasErrors()) {
                for(ObjectError error : result.getAllErrors()) {
                    return error.getDefaultMessage();
                }
            }
        }

        TestDemo testDemo = testDemoApi.getDemo(params.getId(),params.getDayIdStart(),params.getDayIdEnd());
        return testDemo.toString();
    }

    @RequestMapping(value = "/testRestTemplate",method = RequestMethod.GET)
    public String testRestTemplate(){
        String result = testDemoApi.getApiDate();
        return result;
    }

}
