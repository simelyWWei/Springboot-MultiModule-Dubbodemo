package com.example.demo.api;

import com.example.demo.model.TestDemo;

public interface TestDemoApi {
    TestDemo getDemo(String id,String dayIdStart,String dayIdEnd);
}
