FROM maven:3.5.2-jdk-8 AS build
WORKDIR /usr/src/app

COPY src ./src
COPY pom.xml .
RUN mvn -f ./pom.xml clean package

FROM openjdk:8-jdk-alpine
LABEL maintainer="Ed Briggler <edward.briggler@gmail.com>"
VOLUME /tmp
RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser -G appuser
USER appuser
COPY --from=build /usr/src/app/target/trump-tweets.jar /app.jar
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]