# Books & Authors – Spring Boot + JSP

A Spring Boot MVC application that manages two related entities — **Authors** and **Books** — with Create, Read, and Update operations through JSP views.

## Tech Stack
- Spring Boot 3.2 (Web, Data JPA, Validation)
- JSP + JSTL views, custom CSS
- H2 in-memory database (auto-loaded with 10 sample rows per table)
- JUnit 5 + Mockito for tests
- Maven build

## Run

```bash
mvn spring-boot:run
```

Then open:
- Home:    http://localhost:8080/
- Authors: http://localhost:8080/authors
- Books:   http://localhost:8080/books
- H2 console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:bookdb`)

## Tests

```bash
mvn test
```

## Project Structure
```
src/main/java/com/example/bookapp
 ├── BookAppApplication.java
 ├── DataLoader.java                 # populates 10+10 sample rows
 ├── entity/        Author.java, Book.java   (@Entity, @OneToMany / @ManyToOne)
 ├── repository/    AuthorRepository.java, BookRepository.java (custom INNER JOIN)
 ├── service/       AuthorService.java, BookService.java
 ├── controller/    HomeController, AuthorController, BookController
 └── exception/     GlobalExceptionHandler.java (handles DataIntegrityViolation)
src/main/webapp/WEB-INF/views/*.jsp  (home, authors, author_form, books, book_form, error)
src/main/resources/static/style.css
```

## Operations
1. **Populate** – `DataLoader` seeds 10 authors and 10 books on startup.
2. **Create** – JSP forms post to `POST /authors` and `POST /books`.
3. **Read** – `GET /authors`, `GET /books`. The Books page also shows the result of a custom JPQL **INNER JOIN** query (`findBooksWithAuthors`).
4. **Update** – `GET /books/edit/{id}` → `POST /books/update/{id}` (same pattern for authors).

## Submission
Push the project to GitHub and place the URL in `WRITEUP.pdf`.
