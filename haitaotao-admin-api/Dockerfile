# docker build -t haitaotao-admin-api:latest .
# 引用镜像 jdk8精简版
FROM openjdk:8-jdk-alpine
# 作者
MAINTAINER yangyang "965114346@qq.com"

# 指定工作目录
WORKDIR /app

ADD target/haitaotao-admin-api-1.0-SNAPSHOT.jar /app/haitaotao-admin-api.jar

# 配置系统变量
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

EXPOSE 8083

ENTRYPOINT ["java","-jar","/app/haitaotao-admin-api.jar"]