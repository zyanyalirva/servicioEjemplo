FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

VOLUME /tmp

ARG DEPENDENCY=./target

COPY ${DEPENDENCY}/wm-spring-boot-docker-0.1.0.jar /usr/app

RUN sh -c 'touch wm-spring-boot-docker-0.1.0.jar'

ENTRYPOINT ["java","-jar","wm-spring-boot-docker-0.1.0.jar"]