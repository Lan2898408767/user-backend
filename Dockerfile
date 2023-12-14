#依赖的基础镜像 , maven+JDK
FROM maven:3.5-jdk-8-alpine as builder

#拷贝代码到镜像中
WORKDIR /app
COPY pom.xml .
COPY src ./src

# maven打包时跳过测试
RUN mvn package -DskipTests

# 在容器启动时运行 Web 服务 。
CMD ["java","-jar","/app/target/User-Center-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]

