FROM tomcat:jdk8-openjdk

VOLUME /tmp

ARG DEPENDENCY=./target

COPY ${DEPENDENCY}/wm-spring-boot-docker-0.1.0.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]