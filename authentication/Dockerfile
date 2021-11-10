FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar authentication.jar
ENTRYPOINT ["java","-jar","/authentication.jar"]
EXPOSE 8088