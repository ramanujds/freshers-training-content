## **Module 1: Modern Java Programming Essentials**

**Duration**: \~1.5 hours (can be extended based on exercises)


### **Module Overview**

This module introduces key modern Java features starting from **Java 8 onwards**, focusing on writing cleaner, more concise, and maintainable code that is essential for backend development using Spring Boot.

---

### **Learning Objectives**

By the end of this module, participants will be able to:

* Understand and apply functional programming principles in Java
* Use lambda expressions and streams to simplify collection operations
* Work with `Optional`, `var`, and immutable data using `Records`
* Refactor imperative-style code to functional-style code

---

### **Prerequisites**

* Familiarity with Java syntax and object-oriented programming
* Understanding of classes, objects, and interfaces
* IDE setup (IntelliJ, Eclipse, or VS Code with Java)

---

### **Topics Covered**

| **Topic**                             | **Details**                                                                     |
| ------------------------------------- | ------------------------------------------------------------------------------- |
| **1. Functional Interfaces**          | - Concept and usage in Java<br>- `@FunctionalInterface` annotation              |
| **2. Lambda Expressions**             | - Syntax, types, and practical examples<br>- Sorting, filtering collections     |
| **3. Stream API**                     | - Declarative data processing<br>- `filter()`, `map()`, `collect()`, `reduce()` |
| **4. Optional**                       | - Avoiding `NullPointerException`<br>- `isPresent`, `ifPresent`, `orElse`       |
| **5. Records (Java 16+)**             | - Creating immutable data carriers easily                                       |
| **6. `var` and Local Type Inference** | - Writing concise code with inferred types                                      |

---

### **Hands-On Activities**

1. **Convert Old-Style Loops to Streams**

    * Task: Given a list of `Note` objects, use stream API to filter, map, and sort based on title or creation date.

2. **Create Functional Interfaces for Actions**

    * Define a functional interface for `NoteFormatter`
    * Pass lambda to customize how notes are printed

3. **Use `Optional` in Service Layer**

    * Simulate retrieving a note and return default if not found

4. **Refactor POJOs to Records**

    * Refactor `NoteDTO` to use `record` instead of verbose class

---

### **Mini Case Study for Notebook App**

> You're building a **Notebook App API**.
> Implement the following using modern Java:
>
> * A method to return all starred notes created in the last 7 days (use Stream API)
> * A formatter using functional interface to pretty print a note
> * Return an `Optional<Note>` if a note exists by ID

---

### **Module Exit Criteria**

Participants should now be able to:

* Use lambdas and streams fluently in Java code
* Apply modern Java features in their Spring Boot services
* Write more expressive and safe code using `Optional` and `record`

---
