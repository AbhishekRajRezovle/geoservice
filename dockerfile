FROM openjdk:8
ADD target/geo-0.0.1-SNAPSHOT.jar geo_app.jar
ENTRYPOINT ["java","-jar","/geo_app.jar"]