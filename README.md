# TBR Backend

This project is a Java Spring Boot application that will eventually serve as a backend for the associated [tbr-react](https://github.com/aedifice/tbr-react) frontend. The TBR (or "To Be Read") app is an example reading list application.

This app connects with OpenLibrary APIs to retrieve information on books.

## Using the service

### Running the service

This project uses Java SDK version 17 and requires Maven. To build and run the server, use the command:
```
mvn spring-boot:run
```

### Using the service's endpoints

Once the service is up and running, you can currently test the application by accessing:
```
GET localhost:8080/isbn?isbn={isbnNumber}
```

This will retrieve an abbreviated book object that includes a link to the book's OpenLibrary page and links to search for the book within WorldCat and Bookshop.
