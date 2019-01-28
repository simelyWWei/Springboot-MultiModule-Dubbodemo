# Springboot-MultiModule-Dubbodemo
使用springboot多模块模式搭建dubbo的测试demo

本示例项目中配置了一个dubbo项目，包含三个模块
springboot-dubbo-api、springboot-dubbo-server和
springboot-dubbo-client。
把server分为api(服务接口定义)和server（服务实现）两个子module。
在springboot-dubbo-server和springboot-dubbo-client的pom中
都添加了对dubbo、zk及springboot-dubbo-api的依赖。

1、dubbo的最新官网配置
2、整合自定义参数校验，对日期格式以及日期顺序的校验
