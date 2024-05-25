FROM openjdk:17-jdk-alpine

COPY build/libs/app.jar app.jar

CMD ["java", "-jar", "app.jar"]
