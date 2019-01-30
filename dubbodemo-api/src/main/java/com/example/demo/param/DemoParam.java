package com.example.demo.param;

import com.example.demo.validator.DateStr;
import com.example.demo.validator.group.FirstClass;
import com.example.demo.validator.group.SecondClass;
import com.example.demo.validator.TimeOrder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@TimeOrder(groups = {SecondClass.class},startTime = "dayIdStart",endTime = "dayIdEnd",formatPattern = "yyyyMMddHHmmss",message = "开始时间必须在结束时间之前")
public class DemoParam implements Serializable {

    @DateStr(groups = {FirstClass.class},formatPattern = "yyyyMMddHHmmss", message = "dayIdStart:日期格式错误")
    private String dayIdStart;

    @DateStr(groups = {FirstClass.class},formatPattern = "yyyyMMddHHmmss", message = "dayIdEnd:日期格式错误")
    private String dayIdEnd;

    @Size(max = 10, message = "最大长度为10")
    private String id;
}
