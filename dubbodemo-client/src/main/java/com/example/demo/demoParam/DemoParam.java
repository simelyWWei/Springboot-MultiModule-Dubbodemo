package com.example.demo.demoParam;

import com.example.demo.valid.CheckTimeOrder;
import com.example.demo.valid.DateStrValidator;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@CheckTimeOrder(startTime = "dayIdStart",endTime = "dayIdEnd",formatPattern = "yyyyMMddHHmmss",message = "开始时间必须在结束时间之前")
public class DemoParam implements Serializable {

    @DateStrValidator(formatPattern = "yyyyMMddHHmmss", message = "dayIdStart:日期格式错误")
    private String dayIdStart;

    @DateStrValidator(formatPattern = "yyyyMMddHHmmss", message = "dayIdEnd:日期格式错误")
    private String dayIdEnd;

    @Size(max = 10, message = "最大长度为10")
    private String id;
}
