FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar configuration.jar
ENTRYPOINT ["java","-jar","/configuration.jar"]
EXPOSE 8888