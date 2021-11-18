FROM openjdk:8
VOLUME /tmp
COPY target/*.jar ribastore-delivery.jar
ENTRYPOINT ["java","-jar","/ribastore-delivery.jar"]
EXPOSE 8083