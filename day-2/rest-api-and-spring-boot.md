## **Module 2: Spring Boot Essentials & REST API Development**

**Duration**: \~2.5 hours (can be extended with deeper integration)

---

### **Module Overview**

This module focuses on setting up a Spring Boot application, understanding its components, and building RESTful APIs using Spring’s layered architecture. Trainees will create a **Notebook Management API**.

---

### **Learning Objectives**

By the end of this module, participants will be able to:

* Set up a Spring Boot application from scratch
* Build RESTful APIs using Controllers, Services, and Repositories
* Understand dependency injection, application structure, and Spring annotations
* Test APIs using Postman or Swagger

---

### **Prerequisites**

* Basic knowledge of Java (object-oriented concepts)
* Familiarity with REST concepts and HTTP methods
* Completion of Module 1: Modern Java Programming Essentials

---

### **Topics Covered**

| **Topic**                          | **Details**                                                                                 |
| ---------------------------------- | ------------------------------------------------------------------------------------------- |
| **1. Introduction to Spring Boot** | - What is Spring Boot?<br>- Auto-configuration, starters, dependencies                      |
| **2. Project Structure**           | - Application class, Controller, Service, Repository                                        |
| **3. Annotations Deep Dive**       | - `@RestController`, `@GetMapping`, `@PostMapping`, `@Autowired`, `@Service`, `@Repository` |
| **4. Dependency Injection**        | - Constructor-based vs Field injection                                                      |
| **5. Create CRUD APIs**            | - Full set of CRUD operations for Notes                                                     |
| **6. API Testing**                 | - Use Postman or Swagger for testing                                                        |

---

### **Hands-On Activities**

#### *Activity 1: Initialize Spring Boot App*

* Use Spring Initializr to generate a Maven project
* Add dependencies: Spring Web, Lombok, Spring Boot DevTools

#### *Activity 2: Create a Basic REST API*

* Create a Note class with `id`, `title`, `content`, `createdAt`
* Create `NoteController`, `NoteService`, and a fake in-memory repo
* Implement basic CRUD: Create, Get All, Get by ID, Delete

#### *Activity 3: Test Using Postman*

* Test GET, POST, DELETE endpoints
* Modify JSON request/response bodies

#### *Activity 4: Implement Swagger UI*

* Add `springdoc-openapi-ui` dependency
* Auto-generate documentation for existing endpoints

---

### **Notebook App Case Study - API Design**

> You’re building the backend for a **Notebook App** that allows users to:
>
> * Create, read, update, and delete notes
> * Search notes by title
> * Filter notes by date
>
> Implement a version of these APIs in Spring Boot and test them.

---

### **Module Exit Criteria**

By the end of this module, participants should be able to:

* Build a functional REST API in Spring Boot
* Understand and implement layered architecture (Controller → Service → Repository)
* Use annotations and dependency injection properly
* Test APIs using Postman and generate OpenAPI docs with Swagger

