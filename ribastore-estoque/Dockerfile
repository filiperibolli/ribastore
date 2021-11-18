FROM openjdk:8
VOLUME /tmp
COPY target/*.jar ribastore-estoque.jar
ENTRYPOINT ["java","-jar","/ribastore-estoque.jar"]
EXPOSE 8081