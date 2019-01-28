package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TestDemo implements Serializable {
    private String id;
    private String descript;
    private String dayIdStart;
    private String dayIdEnd;
}
