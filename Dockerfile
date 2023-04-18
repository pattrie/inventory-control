FROM openjdk:15

WORKDIR /apps

COPY target/inventory-control-0.0.1-SNAPSHOT.jar /apps

CMD [ "java", "-jar", "/apps/inventory-control-0.0.1-SNAPSHOT.jar" ]