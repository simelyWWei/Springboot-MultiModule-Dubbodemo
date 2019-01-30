package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate的配置文件
 *
 * @author 魏巍
 * @date 2019/1/8 14:35
 */
@Configuration
public class RestTemplateConfig {

    @Bean("restTemplateForLabel")
    public RestTemplate restTemplateForLabel(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean("restTemplateForLocationHistory")
    public RestTemplate restTemplateForLocationHistory(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }

}
