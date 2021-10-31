# TodoList-BackEnd
                                                  TODO-LIST-APPLICATION

This application is built to create a list of todos with task name and description and displays details when a todo is created/updated. User can add a todo, edit/update todo and delete todo.

Technologies Used 

1.	Spring Boot- Spring Boot framework is used to develop the application as it provides automatic configuration to simplify the process of development. Spring boot also provides an embedded server to deploy and run the application as compared to other Spring framework where developers must deploy the web archive to an external tomcat server and do other lengthy configurations.

2.	Jacoco – Jacoco plugin is used for code coverage. It is a Maven plugin which records execution coverage data. It creates code coverage reports from this execution data.

3.	Log Captor dependency -Log Captor is used to mock logging outputs like info(), error() and debug(). It is very helpful for unit testing methods with void return types 

4.	MVC Architecture – Model View Controller architecture is followed for developing the application to divide the application into 3 components. Model is used for writing the business logic by having a separate service layer and database layer. View is for data rendering and UI components. The Controller acts as an interface between the Model and View and listens to the incoming user requests and process them.

5.	Angular- Angular 8 is used to develop the UI.

6.	H2 database – It is an open-source relational database and very fast. It is an in-memory database which means it does not persist the data and on every application start-up it will create new table and data. It is primarily used for testing purposes and developing POCs. It provides h2 console server for viewing the tables and data and it can be easily configured in a spring boot application by enabling the h2 console to true like spring.h2.console.enabled=true 
After the startup of back-end application, H2 console will be available at localhost:8081/h2-console
7.	Spring Data JPA – It is a java persistence API for handling the CRUD (Create Read Update Delete) operations. A Crud Repository is used for generic CRUD operations and for interacting with the database.

8.	Mockito – For writing unit test cases Mockito framework is used. The advantage of using Mockito is that it does not require a database connection or reading a property file for testing any functionality.

9.	Logger- A log file is maintained for generating the application logs, which can be very helpful in a production environment when the application is live, and if there is any error or bug in the application it can be easily tracked down by accessing the log files.

Instructions for building and running the application – 

1.	Back End – Download the source code of the back-end application and import the project in IDE of your choice. Go to project location where pom.xml lives (/TodoList-BackEnd-master) and build the application using mvn clean install (Download and install maven if not already for building the back end application). After the application is build, run the application as “Run as Spring Boot project”. After application has started, hit REST end point http://localhost:8081/todos/v1/getAll to verify that it returns a blank array which means there are no entries yet in the database but the request is completed OK.

2.	Front End – Download the source code of the front-end project. Download and Install Visual studio code IDE if not present already. Open VS code and go to File -> Open Folder and go to the location where front-end code is downloaded and select the folder TodoList-FrontEnd-master. Install Angular 8 if not already and use command npm install to download the project dependencies. After installation of project dependencies, use command npm start to start the front-end application. After start of the application hit URL http://localhost:4200/ to see the home page of the application. Make sure the back end is running or the war file is deployed to an external server when creating/editing/deleting TODOs.

3.	Accessing the database console – H2 database is used for persisting values. After the back-end server is up either by running the application via an IDE or by deploying the application war available at (TodoList-BackEnd-master/target/ TodoList-0.0.1-SNAPSHOT.war)  in an external server (Tomcat). H2 console will be available at localhost:8081/h2-console


            Testing the REST endpoints using a web browser –
1.	Get All Todos - http://localhost:8081/todos/v1/getAll - Use this GET end point to see the no of todo objects created in the database.
2.	Get Todo based in ID (PK) - http://localhost:8081/todos/v1/edit/?id=1 – Use this GET end point to see single Todo based on the id. The id is incremental, as the todos get created ids will be incremented by 1.
3.	To test POST end points, Postman can be used.

The code coverage of the application is 92% and can be found at location - / TodoList-BackEnd-master/target/site/jacoco/index.html.

The application can be extended by following ways if given more time :-

1.	Adding sub tasks to already present list of tasks.
2.	Adding priority to tasks like HIGH, MEDIUM, LOW and sort, filter tasks based on priority.
3.	Use spring security for authentication and authorization of the application and making it more secure.
4.	Add unit test cases in the front -end application (I had to spend some extra time in the front end development pertaining to some issues due to which could not complete the test cases).  
5.	Create a functionality to add Completion Date of a task and send an automated email to the user when the completion date is less than 24 hours .
