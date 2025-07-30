# 第一阶段：编译打包（使用Maven镜像）
# 选择包含JDK的Maven镜像，版本与项目JDK一致（如JDK 17）
FROM maven:3.8.5-openjdk-17 AS builder

#设置工作目录
WORKDIR /app

#复制pom.xml和源代码到容器
COPY pom.xml .

# 仅下载依赖到本地仓库（不编译代码）
RUN mvn dependency:go-offline -B

COPY src ./src

#打包spring boot应用
RUN mvn clean package -DskipTests

#第二阶段 运行环境
FROM openjdk:17-slim

#设置工作目录
WORKDIR /app


#从第一阶段复制打包好的JAR文件到当前目录
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]


#优先使用这个命令构建，单个镜像
#docker buildx build -t my-spring-app:latest --load .

#在powershell 中运行打包会有详细
#docker compose up -d --build