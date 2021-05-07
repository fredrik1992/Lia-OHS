FROM openjdk:11
ADD target/ohsapp.war ohsapp.war
ENTRYPOINT ["java","-jar","ohsapp.war"]
