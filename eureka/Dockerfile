FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar eureka.jar
ENTRYPOINT ["java","-jar","/eureka.jar"]
EXPOSE 8761