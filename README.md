
## 项目简介
一个微服务架构中的服务提供者示例项目。仅是最简化的演示，基于spring-cloud-consul实现。


## 使用
1. 启动consul,并修改确认consul地址——bootstrap.yml
2. 启动服务提供者。运行本项目入口类。注:可修改端口，运行多个实例，以观察负载均衡效果。
3. 运行[该项目](http://192.168.82.98/gongchengdong/spring-cloud-consul-sample-consumer)测试用例——SampleServiceTest，观察结果