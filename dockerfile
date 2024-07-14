FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
EXPOSE 8080
ADD target/springboot-k8s-0.0.1.jar springboot-k8s.jar
ENTRYPOINT ["java","-jar","/springboot-k8s.jar"]