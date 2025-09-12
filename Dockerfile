FROM maven:3.9.9-eclipse-temurin-24 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:24-jdk-alpine AS deploy

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]