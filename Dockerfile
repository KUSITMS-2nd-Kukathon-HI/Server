FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/kukathon-hi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} kukathon-hi.jar

ENTRYPOINT ["java","-jar","/kukathon-hi.jar"]