
## 项目简介
一个微服务架构中的服务提供者示例项目。仅是最简化的演示，基于spring-cloud-consul实现。


## 使用
1. 启动consul
2. 启动服务提供者。运行本项目入口类。注:可修改端口，运行多个实例，以观察负载均衡效果
3. 运行[该项目](http://192.168.82.98/conanca/spring-cloud-consul-sample-consumer)测试用例——SampleServiceTest，观察结果


## rancher上部署运行
1. 先编译jar包
 ```
 mvn package
 ```
2. build docker镜像并push至镜像仓库
  ```
  docker build . -t "reg.dolplay.com/conanca/spring-cloud-consul-sample-provider:0.1"
  docker push reg.dolplay.com/conanca/spring-cloud-consul-sample-provider:0.1
  ```
3. rancher上“添加应用栈”，“导入COMPOSE”时选择/rancher/目录下的配置文件

## 附录
#### docker运行consul
```
docker run -d -p 8300:8300 -p 8400:8400 -p 8500:8500 -p 8600:8600 -e 'CONSUL_LOCAL_CONFIG={"skip_leave_on_interrupt": true}' --name=node0 consul:0.7.5 agent -server -client=0.0.0.0 -node=node0 -bootstrap-expect=1 -bind=127.0.0.1 -data-dir=/tmp/consul -ui
```