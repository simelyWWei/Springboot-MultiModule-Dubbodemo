package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.api.TestDemoApi;
import com.example.demo.model.TestDemo;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = TestDemoApi.class, loadbalance = "roundrobin")
public class TestDemoServiceImpl implements TestDemoApi {
    @Override
    public TestDemo getDemo(String id, String dayIdStart, String dayIdEnd) {
        TestDemo testDemo = new TestDemo();
        testDemo.setId(id);
        testDemo.setDayIdStart(dayIdStart);
        testDemo.setDayIdEnd(dayIdEnd);
        testDemo.setDescript("come from dubbo-server:hello!");
        return testDemo;
    }
}
