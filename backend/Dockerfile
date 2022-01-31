FROM openjdk:11
COPY ./build/libs/*-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["/bin/sh", "-c" , "java -jar app.jar"]