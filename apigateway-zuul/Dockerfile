FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar apigateway-zuul.jar
ENTRYPOINT ["java","-jar","/apigateway-zuul.jar"]
EXPOSE 5555