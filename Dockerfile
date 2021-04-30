FROM openjdk:11
ADD target/ohsapp.jar ohsapp.jar
ENTRYPOINT ["java","-jar","ohsapp.jar"]
