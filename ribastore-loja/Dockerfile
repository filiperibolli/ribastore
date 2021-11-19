FROM openjdk:8
VOLUME /tmp
COPY target/*.jar ribastore-loja.jar
ENTRYPOINT ["java","-jar","/ribastore-loja.jar"]
EXPOSE 8080