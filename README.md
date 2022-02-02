# rock-paper-scissors
Rock Paper Scissors Game for a Tech Challenge

## How to run
You have two options to run:

## First Option: using docker
**What do you need to run?**
- Docker
- Docker-Compose

To start the application, access */rock-paper-scissors* folder and run the command:
````
docker-compose up -d
````

Wait for the process and access the application:
- http://localhost:3000

To stop the application, just run the command:
````
docker-compose down
````

## Second Option: using NodeServer and Java
**What do you need to run?**
- Node version 16 or higher
- Java 11 or higher

First we need to start the JAVA backend application. Go to  */rock-paper-scissors/backend* and run the command:
````
./gradlew bootrun
````

After this, we can start the frontend application. Go to */rock-paper-scissors/frontend* and run these commands:
````
npm install
npm start
````
Wait for the process and access the application:
- http://localhost:3000

## Code Coverage
You can find the code coverage [here](https://sonarcloud.io/summary/overall?id=andrewsdosreis_rock-paper-scissors).

![image](https://user-images.githubusercontent.com/19553909/152074836-5f4647e7-f3bd-4fe4-a5a8-854d1e993ae9.png)

