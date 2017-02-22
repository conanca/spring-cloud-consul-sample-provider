FROM reg.news.cn/library/xh-baseimage-java:8
MAINTAINER gongchengdong <gongchengdong@news.cn>

ADD target/spring-cloud-consul-sample-provider-0.1.jar app.jar

# Http port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker-compose"]