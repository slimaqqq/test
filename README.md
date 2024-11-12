# Cars Pairing Test

## Prerequisites:
- Java 17

## Getting Started
- Run it `./gradlew bootRun`
- Check the application has started successfully: `curl localhost:8080/cars` or visit in a browser.

## Task
This is a basic Spring Boot application connected to an in memory h2 database.

Have a browse of the code! You'll see we already have a controller and a repository with a DB table called 'car'.

Please complete the following tasks and explain your thought process as you go. Don't rush! Quality is more important than quantity :).

Please feel free to google anything you need - in fact, it's encouraged.

At the end of the test, please inspect the [Makefile](Makefile) then run `make delete-test`

### Part 1: 
You'll notice a method exists in `SimpleController` to get cars. 

Implement that to return all cars in the database as json.

### Part 2: 
We have a 3rd party providing cars. 

Create an endpoint to return the *count* of all cars from our third party with colour RED.

### Part 3: 
Add a new method to create a car.
