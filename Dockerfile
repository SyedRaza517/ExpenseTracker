FROM openjdk:17

ADD target/ExpenseTracker-0.0.1-SNAPSHOT.jar ExpenseTracker-0.0.1-SNAPSHOT.jar

EXPOSE 8282

ENTRYPOINT ["java","-jar", "ExpenseTracker-0.0.1-SNAPSHOT.jar"]
