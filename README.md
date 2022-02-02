# rock-paper-scissors
Rock Paper Scissors Game for a Tech Challenge

## How to run
You have two options to run.

## First Option: using docker
What do you need to run?
Docker and Docker-Compose

To start the application, access /rock-paper-scissors folder and run the command:
docker-compose up -d

Wait for the process and access the application:
http://localhost:3000

To stop the application, just run the command:
docker-compose down

## Second Option: using NodeServer and Java
What do you need to run?
- Node version 16 or higher
- Java 11 or higher

First, go to /rock-paper-scissors/backend and run the command below to start the JAVA backend application:
./gradlew bootrun

After this, go to /rock-paper-scissors/frontend and run these commands:
npm install
npm start

Wait for the process and access the application:
http://localhost:3000

## Code Coverage
To see code coverage and analysys click here.

