FROM java:8
COPY build/libs/chautari-0.0.1-SNAPSHOT.jar chautari-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","chautari-0.0.1-SNAPSHOT.jar"]