package com.example.demo.dao;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseDemo {
    private String msg;
    private String code;
    private Map<String,String> dataMap;
    private String dataList;
}
