FROM openjdk:11
ADD target/lab5-0.0.1-SNAPSHOT.jar lab5.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","lab5.jar"]