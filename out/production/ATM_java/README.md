# Overview
For this project, I started with only knowing how to print something out in Java. Having finished the first version (are projects ever truly finished?) 
I've learned so much more about Java and how to work with its syntax and now feel more comfortable in taking on other Java based projects.

This software has three different classes and a mySQL database. The main class is my ATM class, this one will pull everything together and 
start the program. My Database class is in charge of connecting to the database, and querying the data we need. Lastly, my Transactions class
will utilize a bit from the Database class and run updates based off of the user input (withdrawing from accounts).

When I wrote this program, I went in wanting to teach myself Java. But as I started brainstorming how I wanted to complete this 
project, I decided I wanted to learn how to connect a database to my program as well. By writing this software I learned how to 
use Java and MySQL together with object-oriented programming to mimic an ATM.


[//]: # ()
[//]: # ({Provide a link to your YouTube demonstration.  It should be a 4-5 minute demo of the software running and a 
walkthrough of the code.  Focus should be on sharing what you learned about the language syntax.})

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment
I used IntelliJ as my IDE and created a database in MySQL. I also used Git and GitHub to make it open source.

* IntelliJ
* Git & GitHub
* MySQL 8.0

For this program, I used Java as my main language and little bit from SQL to run the queries. Because I was using
SQL, this also required that I imported java sql to help with exceptions, run statements, etc. I also used java util
to read data in from the user.

Languages
* Java version 17.0.3
* SQL

Libraries
* java sql
* java util Scanner


# Useful Websites

* [Data Base practice with IntelliJ IDEA Community Edition Java, MySQL, Database Navigator plugin](https://www.youtube.com/watch?v=AshoqjeaPkc)
* [Geeks for Geeks - Java](https://www.geeksforgeeks.org/java/?ref=shm)
* [A Java MySQL UPDATE example](https://alvinalexander.com/java/java-mysql-update-query-example/)

# Future Work
I've done a lot on this project and taught myself Java in the process, however there are still some changes I would
like to update/improve on in the future.

* Work on performance for bigger databases.

* Figure out a more efficient way of connecting to the database.

* Write their receipts to a text file on their computer.

* Get it to always show two decimal places.
