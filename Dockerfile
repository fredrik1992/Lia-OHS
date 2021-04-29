FROM openjdk:11
ADD target/ohsapp.jar ohsapp.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","ohsapp.jar"]
