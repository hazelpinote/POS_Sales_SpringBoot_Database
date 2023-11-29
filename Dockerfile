FROM maven:latest-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/pos_sales-0.0.1-SNAPSHOT.jar pos_sales.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","pos_sales.jar"]
