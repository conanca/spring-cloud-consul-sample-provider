FROM reg.dolplay.com/library/xh-baseimage-java:8
MAINTAINER conanca <imconan@gmail.com>

ADD target/spring-cloud-consul-sample-provider-0.1.jar app.jar

# Http port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker-compose"]