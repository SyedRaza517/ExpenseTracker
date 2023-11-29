FROM openjdk:8

ADD target/ExpenseTracker-0.0.1-SNAPSHOT.jar ExpenseTracker-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","ExpenseTracker-0.0.1-SNAPSHOT.jar"]
