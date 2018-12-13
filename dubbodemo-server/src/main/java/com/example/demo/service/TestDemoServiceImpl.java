package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.api.TestDemoApi;
import com.example.demo.model.TestDemo;
import org.springframework.stereotype.Component;

@Component
@Service
public class TestDemoServiceImpl implements TestDemoApi {
    @Override
    public TestDemo getDemo(String id) {
        TestDemo testDemo = new TestDemo();
        testDemo.setId(id);
        testDemo.setName("come from dubbo-server:hello!");
        return testDemo;
    }
}
