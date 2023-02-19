Steps to use backend services:
-> Pull Docker image from Docker Hub path: https://hub.docker.com/r/qwkz/backend-services/tags
-> Run the backend services locally with command: docker container run --publish 4000:4000 qwkz/backend-services:latest

Steps to run the aggregation service:
-> Download and unzip the code from Github path:
-> Run the project from command prompt from the folder it was unzipped with command: mvn spring-boot:run
-> Tomcat server runs on port 8080. 
-> Open browser and hit the below service for aggregation service:
 http://127.0.0.1:8080/aggregation?shipmentsOrderNumbers=987654321,123456789&trackOrderNumbers=987654321,123456789&pricingCountryCodes=NL,CN 
 -> http://127.0.0.1:8080/aggregation