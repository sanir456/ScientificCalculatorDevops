FROM openjdk:11
EXPOSE 9090
ADD target/ScientificCalculatorDevops-0.0.1-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]