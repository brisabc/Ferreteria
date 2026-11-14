# Etapa 1: Compilar el proyecto con Maven y Java 21
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app_ferreteria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_ferreteria.jar"]

#FROM eclipse-temurin:21-jdk-alpine

#ARG JAR_FILE=target/Ferreteria-industrial-0.0.1.jar

#COPY ${JAR_FILE} app_ferreteria.jar

#EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "app_ferreteria.jar"]