FROM openjdk:11-jre-slim
COPY ./build/libs/rock-paper-scissors-0.0.1-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["/bin/sh", "-c" , "java -jar app.jar"]