FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=api/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","app.jar"]