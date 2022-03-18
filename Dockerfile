FROM openjdk:8-jre
MAINTAINER taogang

COPY /target/*.jar /app.jar

CMD ["--server.port=7070"]

EXPOSE 7070

ENTRYPOINT ["java","-jar","app.jar"]
