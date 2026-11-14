FROM eclipse-temurin:21-jdk-alpine
ARG JAR_FILE=target/Ferreteria-industrial-0.0.1.jar
COPY ${JAR_FILE} app_ferreteria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_ferreteria.jar"]