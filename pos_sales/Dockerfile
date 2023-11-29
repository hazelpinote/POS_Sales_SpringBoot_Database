FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
