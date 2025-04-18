
FROM amazoncorretto:21-alpine-jdk
COPY target/Hospital-0.0.1-SNAPSHOT app.jar
ENTRYPOINT ["java", "-jar", "./app.jar"]

