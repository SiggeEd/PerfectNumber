# PerfectNumber
Worldline Code test

How to run:
You can either: Open the folder in an IDE and run the SpringBootApplication called PerfectNumberApplication

Or: open a command prompt window and go to the project directory and enter the command: mvnw clean package. 
This will build the project and create a target folder.
Next enter the command: java -jar target\spring-boot-rest-2-0.0.1-SNAPSHOT.jar 
to start the server.

The server will start on http://localhost:8080

Use an API platform such as Postman to send requests to the APIs. 
The request URL will be http://localhost:8080/perfectnumber/single or http://localhost:8080/perfectnumber/inrange 


Check single number:
Select POST request and enter http://localhost:8080/perfectnumber/single as the request URL 
For the query params use 'num' as key and the number you want to check as the value.
num: numberToCheck
The response will either be true or false depending on if the number that was selected as value is a perfect number or not.

Check numbers in range:
Select POST request and enter http://localhost:8080/perfectnumber/inrange as the request URL
For the query params use 'start' and 'end' as keys with the number you want to check from as the value to 'start' 
and the number you want to check to as the value to 'end'.
start: numberToCheckFrom
end: numberToCheckTo
The response will be a list that contains every perfect number between the 'start' and 'end' values.

____________________________________

In the package com.worldlineapi.perfectnumber you'll find the class PerfectNumberApplication which contains the main method and is
used to start the API on localhost:8080. in the package .controller you'll find the controller for the POST requests to the APIs, 
which handles the posts and the responses from the API. In the package .service you'll find the code for the perfect number algorithm.
The package contains an interface and a class.

In the test folder you'll find JUnit tests for the code.
