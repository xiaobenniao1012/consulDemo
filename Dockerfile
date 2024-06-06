# 使用官方的Java运行时作为父镜像
FROM openjdk:8-jdk-alpine

# 定义参数
ARG APP_PORT
ARG JAR_FILE

# 将本地文件复制到 Docker 容器中的 /（根目录）下，并且在容器中的文件名会被命名为 app.jar
COPY ${JAR_FILE} app.jar

# 对外暴露的端口
EXPOSE ${APP_PORT}

# 指定容器启动时要运行的命令
ENTRYPOINT ["java","-jar","/app.jar"]