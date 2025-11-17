Books REST API Project 📚🖥️
Overview

This project demonstrates a RESTful API for managing a collection of books, including CRUD operations and ordering books. It is implemented in Java using JAX-RS (Jersey) and MariaDB as the backend database.

The project includes:

Server-side REST service for books (BooksRestService)

Client-side REST client to consume the API (BooksRestClient)

Database access via BooksDao

XML and JSON support for API responses

Features

List available books in XML or JSON.

Retrieve a specific book by ID.

Register new books.

Update existing book details.

Delete books.

Order books, which decrements the availability count.

Project Structure
gr.uniwa.booksrest
│
├─ BooksRestService.java       # Server-side REST endpoints
├─ ApplicationConfig.java      # Configures REST application path
├─ BooksRestClient.java        # Client-side REST client
├─ model/
│   └─ Books.java              # Book entity for server
├─ client/
│   └─ Books.java              # Book entity for client
│   └─ RestDbClient.java       # Client test application
├─ database/
│   └─ BooksDao.java           # Database access object
└─ service/
    └─ BooksService.java       # REST service interface

REST Endpoints
Endpoint	HTTP Method	Produces / Consumes	Description
/BooksService/booksxml	GET	application/xml	Get all available books in XML
/BooksService/booksjson	GET	application/json	Get all available books in JSON
/BooksService/booksxml/{id}	GET	application/xml	Get book by ID in XML
/BooksService/booksjson/{id}	GET	application/json	Get book by ID in JSON
/BooksService/RegisterBooks	POST	application/x-www-form-urlencoded	Register a new book
/BooksService/UpdateBooks	PUT	application/x-www-form-urlencoded	Update existing book
/BooksService/OrderBooks	POST	application/x-www-form-urlencoded	Order a book
/BooksService/DeleteBooks/{id}	DELETE	text/html	Delete a book by ID
Database

Database: MariaDB

Table: books

CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    availability INT
);


The BooksDao class handles all database operations like insert, update, delete, and select.

How to Run
Server

Set up MariaDB and create rest_db with books table.

Import the Java project into your IDE (NetBeans, Eclipse, etc.).

Configure the BooksDao connection with your database credentials.

Deploy the project to Tomcat / Glassfish / any Java EE server.

The REST API is accessible at:

http://localhost:8081/WebBooksRestPrg/webresources/BooksService

Client

Compile and run RestDbClient.java.

The client demonstrates all operations:

BooksRestClient client = new BooksRestClient();

// Get books in XML
String booksXml = client.getAvailableBooksXml();

// Get books in JSON
String booksJson = client.getAvailableBooksJson();

// Register a new book
Books newBook = new Books();
newBook.setID(1);
newBook.setTitle("Java Programming");
newBook.setAuthor("Georgia");
newBook.setAvailability(10);
client.RegisterBooks(newBook);


The client prints responses for each operation to the console.

Dependencies

JAX-RS / Jersey

MariaDB JDBC driver

Java 8+

Servlet container (Tomcat / Glassfish)

Example Output
Books List (xml): <books><book>...</book></books>
Books List (json): [{"id":1,"title":"Java Programming","author":"Georgia","availability":10}]
Register book result: <h3>success</h3>
Update book result: <h3>success</h3>
Order book result: <h3>success</h3>
Delete book result: <h3>success</h3>

Author

Georgia Papapanagiotou
Educational project demonstrating REST API, client-server communication, and database operations in Java.