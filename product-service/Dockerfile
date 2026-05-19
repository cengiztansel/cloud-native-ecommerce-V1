# Maven ile build etmek yerine, halihazırda listedeki imaj kullanımı-Docker Image Reuse
# FROM eclipse-temurin:21-jdk-alpine # 21-alpine: en küçüğü budur.
# WORKDIR /app
# COPY target/*.jar app.jar
# EXPOSE 8081
# ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/product-service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]

