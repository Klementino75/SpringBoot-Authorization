FROM openjdk:17-jdk-slim

VOLUME /tmp

EXPOSE 8080

COPY target/SpringBoot-Authorization-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]