
## **Module 3: Exception Handling, Validation & Unit Testing in Spring Boot**

**Duration**: \~2 hours

---

### **Module Overview**

This module covers how to make your Spring Boot APIs **robust**, **safe**, and **testable** by implementing input validation, proper exception handling, and writing unit tests for services and controllers.

---

### **Learning Objectives**

By the end of this module, participants will be able to:

* Validate incoming API payloads using annotations
* Handle exceptions globally using `@ControllerAdvice`
* Return proper HTTP status codes and error responses
* Write basic unit tests for service and controller layers using JUnit and Mockito

---

### **Prerequisites**

* Completion of REST API development using Spring Boot
* Familiarity with Java exceptions, annotations, and JSON structure

---

### **Topics Covered**

| **Topic**                                              | **Details**                                                                                          |
| ------------------------------------------------------ | ---------------------------------------------------------------------------------------------------- |
| **1. Input Validation with Bean Validation (JSR-380)** | - Use `@NotBlank`, `@Size`, `@Email`, `@Pattern` in DTOs<br>- Use `@Valid` in controller methods     |
| **2. Global Exception Handling**                       | - `@ControllerAdvice` and `@ExceptionHandler` for global error mapping<br>- Custom exception classes |
| **3. Standard API Error Response**                     | - Use `ResponseEntity` and structured JSON errors (timestamp, message, status)                       |
| **4. Unit Testing Overview**                           | - Use JUnit 5 and Mockito for writing unit tests<br>- Mocking Service and Repository layers          |
| **5. Writing Controller and Service Tests**            | - Use `@WebMvcTest`, `@MockBean`, and `@SpringBootTest`                                              |

---

### **Hands-On Activities**

#### *Activity 1: Add Validation to Note DTO*

```java
public class NoteDTO {
   @NotBlank(message = "Title is required")
   private String title;

   @Size(max = 500, message = "Content can't exceed 500 characters")
   private String content;
}
```

#### *Activity 2: Add Global Exception Handler*

```java
@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<?> handleValidationErrors(...) { ... }

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<?> handleNotFound(...) { ... }
}
```

#### *Activity 3: Write Unit Tests*

* Write test for service method: `getNoteById()`
* Use `Mockito.when()` to simulate repository response
* Write mock MVC test for `GET /notes/{id}` with `@WebMvcTest`

---

### **Notebook App Case Study Tasks**

> Extend your existing Notebook App APIs with:
>
> * Input validation for `NoteDTO`
> * Return `400 Bad Request` for invalid inputs
> * Return `404 Not Found` for missing notes with a custom error message
> * Write unit tests for:
    >
    >   * Creating a note
>   * Retrieving a note
>   * Handling invalid input

---

### **Module Exit Criteria**

By the end of this module, participants will:

* Ensure API reliability through structured error responses
* Validate inputs with zero manual checks
* Understand and apply unit testing to improve confidence in code
* Be able to demo a clean and fault-tolerant API layer

