# Spring Boot CRUD Application
This is a sample Spring Boot application that manages CRUD operations for the Cliente entity. Created to learn the Spring framework. It uses Thymeleaf, String Data JPA, Spring MVC, MySQL as its database and includes a ClienteController class that manages the CRUD operations.

## Features
This application provides the following main functionalities:

- **Listing clients:** The listar() method maps to the /listar endpoint and retrieves all clients from the IClienteService, adding them to the model, and returning the "listar" view.
- **Creating a new client:** The crear() method maps to the /form endpoint for the GET request and initializes a new Cliente object, adding it to the model along with a title, and returning the "form" view to create a new client.
- **Editing an existing client:** The editar() method maps to the /form/{id} endpoint for the GET request and retrieves an existing Cliente object with the specified id. If found, the method adds the client to the model along with a title and returns the "form" view to edit the client.
- **Saving a client:** The guardar() method maps to the /form endpoint for the POST request and validates the client object passed. If no errors are found, it saves the client to the database.

## Technologies Used
This application uses the following technologies:

- **Thymeleaf:** A Java-based server-side template engine, used to display the information on the screen. The provided listar.html file uses Thymeleaf directives such as th:text, th:href, and th:each to render the data of clients on the HTML page.
- **Spring Data JPA:** Used for handling database operations. The SpringBootDataJpaApplication.java file has the @SpringBootApplication annotation, which indicates it's a Spring Boot application. Additionally, the repository classes in the app extend JpaRepository, which is a part of Spring Data JPA, to manage the database operations for the entities.
- **Spring MVC:** Used for handling web requests and responses. The ClienteController class in ClienteController.java demonstrates the use of Spring MVC through annotations like @Controller, @GetMapping, and @PostMapping, which handle the routing and processing of web requests.

## Installation
To install this application, you will need to:

- Clone this repository using git clone https://github.com/DavileGonzaPe/spring-boot-data-jpa.
- Install Java and Maven if you haven't already done so.
- Install MySQL and create a database named db_springboot.
- Update the application.properties file with your MySQL credentials.

## Usage
To use this application, you will need to:

- Run mvn spring-boot:run to start the application.
- Open a web browser and go to http://localhost:8080/listar to view the list of clients.
- Click the "Crear nuevo cliente" button to create a new client or click the "Editar" button to edit an existing client.

## Configuration
This application uses MySQL as its database. The application.properties file specifies the MySQL configuration with the following lines:

```
spring.datasource.url=jdbc:mysql://localhost/db_springboot
spring.datasource.username=root
spring.datasource.password=sasa
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

You can update these lines to match your MySQL configuration.
