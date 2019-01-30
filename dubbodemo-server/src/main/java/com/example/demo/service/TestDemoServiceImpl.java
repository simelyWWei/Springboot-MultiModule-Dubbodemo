package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.TestDemoApi;
import com.example.demo.dao.ResponseDemo;
import com.example.demo.model.TestDemo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
@Service(interfaceClass = TestDemoApi.class, loadbalance = "roundrobin")
public class TestDemoServiceImpl implements TestDemoApi {

    @Resource
    RestTemplate restTemplateForLabel;

    @Override
    public TestDemo getDemo(String id, String dayIdStart, String dayIdEnd) {
        TestDemo testDemo = new TestDemo();
        testDemo.setId(id);
        testDemo.setDayIdStart(dayIdStart);
        testDemo.setDayIdEnd(dayIdEnd);
        testDemo.setDescript("come from dubbo-server:hello!");
        return testDemo;
    }

    @Override
    public String getApiDate() {
        String url = "http://open.wodata.local:81/apiimsi/1.0/telNoByImsi?imsi={imsi}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer 1faeb95752efeb92f067441632c29b36");
        Map<String,String> params = new HashMap<>(1);
        params.put("imsi","460010190627135");

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(null,headers);
        ResponseEntity<ResponseDemo> exchange = restTemplateForLabel.exchange(url, HttpMethod.GET, request, ResponseDemo.class, params);
        ResponseDemo object = exchange.getBody();
        if(object !=null ){
            return object.getDataMap().get("telno");
        }
        return null;

    }
}
