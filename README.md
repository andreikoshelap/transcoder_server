# transcoder solution
- This project is about creating a filter or several filters. Commonly such filters are used for mapping the transmitted data. 
Therefore, the project is called 'TRANSCODER'.
- The Backend is formed using Spring Boot. H2 was used as the database. Java 11, Maven 3.3.9.
- The "city_capital" table is used as a test data table. Assumed that the filter affects messages generated based on this table,
that is, the filter limits the data according to the criterion.
- Forming the criterion, the Filter class from the Reflection library was used to determine the name of the field and its type

- There are Thymeleaf and Swagger were used as supporting tools for visual effect and check of the requests' functionality..

- All requests were verified using Postman for Windows version 10.14.5.

- After the Tomcat server is up, the operator can open the http://localhost:8080 page. This page will have links to swagger and the database.

