# Back-end Pairing Service

This is a basic Spring Boot application connected to an in memory h2 database.

Have a browse of the code! You'll see we already have a simple web controller and a repository
with a DB table called 'car'.

Please complete the following tasks. Don't rush! Quality is
more important than quantity :)

### Part 1: 
You'll notice a method exists in `SimpleController` to get cars. 

Implement that to return all cars in the database as json.

### Part 2: 
We have a 3rd party providing cars. 

Use them to seed the database, then create a method to return the *count* of all cars with colour RED.

### Part 3: 
Add a new method to create a car.

### Part 4:
Delete the repo with `make remove-test`
