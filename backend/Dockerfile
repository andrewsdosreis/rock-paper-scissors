# FROM openjdk:11-jre-slim
# COPY ./build/libs/*-0.0.1-SNAPSHOT.jar /usr/app/app.jar
# WORKDIR /usr/app
# EXPOSE 8080
# ENTRYPOINT ["/bin/sh", "-c" , "java -jar app.jar"]

# build
FROM gradle:7.3.3-jdk-alpine AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME
COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src
RUN gradle build || return 0
COPY . .
RUN gradle clean build

# container
FROM openjdk:11-jre-slim
ENV ARTIFACT_NAME=rock-paper-scissors-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}