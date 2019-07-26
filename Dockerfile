FROM java:8
EXPOSE 8184
ADD /target/dhl_miniprojekt.jar dhl_miniprojekt.jar
ENTRYPOINT ["java", "-jar", "dhl_miniprojekt.jar"]


