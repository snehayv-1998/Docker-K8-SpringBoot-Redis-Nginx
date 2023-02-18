FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY build/libs/*.jar springbootRedisWithDocker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springbootRedisWithDocker.jar"]