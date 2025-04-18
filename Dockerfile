# ---------- etapa 1 : compila el proyecto ----------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn -q clean package -DskipTests   # genera target/*.jar

# ---------- etapa 2 : imagen final ligera ----------
FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Render asigna su propio puerto en $PORT → respétalo
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]