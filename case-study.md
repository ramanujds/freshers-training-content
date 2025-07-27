# **Personal Finance Tracker for Enterprise Users**

---

## **Project Summary**

Design and develop a **cloud-native Personal Finance Tracker** to help employees and customers in a financial institution monitor and manage their expenses, investments, and savings. It must be secure, scalable, and cloud-ready, integrating structured and unstructured data sources and deploying over GCP.

The application will allow:

* User registration and authentication
* Creating multiple financial accounts (bank, wallet, credit card)
* Recording income and expenses with categories and tags
* Generating summaries and reports
* Logging activity and usage behavior

---

## **Key Modules**

| Module       | Tech Stack/Concept                                  | Output                                         |
| ------------ | --------------------------------------------------- | ---------------------------------------------- |
| SDLC & Agile | Agile stories, Jira boards, Git branching strategy  | Project setup and stories mapped               |
| Git & GitHub | Git CLI, branching, PRs                             | GitHub repo with main/dev/feature branches     |
| Java         | Modern Java, streams, lambdas, records              | Core classes and service logic                 |
| Spring Boot  | REST APIs, Validation, Exception Handling           | Endpoints for CRUD & reporting                 |
| SQL          | MySQL/PostgreSQL                                    | RDBMS schema for users, accounts, transactions |
| NoSQL        | MongoDB                                             | User activity logs, dynamic tagging, reports   |
| Cloud        | GCP (App Engine, Cloud SQL, Firestore), Azure intro | Cloud deployment with storage                  |

---

## **User Personas**

1. **Customer** – End user tracking personal expenses and income
2. **Financial Advisor** – Views clients' reports and financial behavior
3. **Admin** – Manages app configurations and audit logs

---

## **User Stories by Module**

---

### **Module 1: SDLC, Agile & Git**

| ID      | User Story                                                                                                                       | Outcome                         |
| ------- | -------------------------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| SDLC-01 | As a Product Owner, I want to define epics and stories for each module so that the development can be iterative.                 | Jira board with defined backlog |
| GIT-01  | As a Developer, I want to use Git for version control with proper branching strategy so that parallel features can be developed. | GitHub repo with branches, PRs  |

---

### **Module 2: Java Core Services**

| ID      | User Story                                                                          | Outcome                              |
| ------- | ----------------------------------------------------------------------------------- | ------------------------------------ |
| JAVA-01 | As a Developer, I want to use records to model DTOs and request payloads cleanly.   | Defined records for user/account     |
| JAVA-02 | As a Developer, I want to use streams and lambdas to process transaction summaries. | Stream API to summarize monthly data |

---

### **Module 3: Spring Boot API Layer**

| ID        | User Story                                                                   | Outcome                                    |
| --------- | ---------------------------------------------------------------------------- | ------------------------------------------ |
| SPRING-01 | As a user, I want to register and log in securely.                           | REST endpoints for `/register`, `/login`   |
| SPRING-02 | As a user, I want to add multiple accounts with balances and types.          | `/accounts` API                            |
| SPRING-03 | As a user, I want to add transactions (income/expense) for my accounts.      | `/transactions` API                        |
| SPRING-04 | As a user, I want to retrieve summaries and recent expenses.                 | `/reports/monthly`, `/transactions/recent` |
| SPRING-05 | As a developer, I want validations for user input.                           | Bean validation on input models            |
| SPRING-06 | As a developer, I want proper error handling to show user-friendly messages. | Global exception handler with status codes |
| SPRING-07 | As a tester, I want unit tests for each service method.                      | JUnit + Mockito-based unit tests           |

---

### **Module 4: SQL Database Integration**

| ID     | User Story                                                                            | Outcome                        |
| ------ | ------------------------------------------------------------------------------------- | ------------------------------ |
| SQL-01 | As a DBA, I want to design a normalized schema for users, accounts, and transactions. | MySQL/PostgreSQL schema        |
| SQL-02 | As a user, I want to retrieve my total expenses for a given month.                    | SQL `GROUP BY`, `JOIN` queries |
| SQL-03 | As an admin, I want inactive accounts to be flagged automatically.                    | Stored procedure or scheduler  |

---

### **Module 5: MongoDB for Logs and Reports**

| ID       | User Story                                                                                  | Outcome                                      |
| -------- | ------------------------------------------------------------------------------------------- | -------------------------------------------- |
| NOSQL-01 | As a system, I want to store user activities like login, logout, and failed login attempts. | MongoDB `user_logs` collection               |
| NOSQL-02 | As a user, I want to tag my transactions with custom tags for filtering.                    | Dynamic tags in embedded arrays              |
| NOSQL-03 | As a user, I want monthly summaries to load fast.                                           | Precomputed documents in `monthly_summaries` |
| NOSQL-04 | As a developer, I want to search logs for specific user activity during audits.             | Mongo filters + indexing                     |

---

### **Module 6: Cloud Deployment (GCP)**

| ID       | User Story                                                                   | Outcome                                    |
| -------- | ---------------------------------------------------------------------------- | ------------------------------------------ |
| CLOUD-01 | As a DevOps engineer, I want to deploy my Spring Boot app on GCP App Engine. | App Engine deployment YAML                 |
| CLOUD-02 | As a database admin, I want to host the MySQL database on Cloud SQL.         | Connected via JDBC                         |
| CLOUD-03 | As a data engineer, I want to store audit logs in Firestore.                 | Logs redirected from Mongo/DB to Firestore |
| CLOUD-04 | As a business user, I want the system to be available with HTTPS.            | GCP Load Balancer & SSL                    |

---

## **Testing & Validation Stories**

| ID      | User Story                                                                      | Outcome                           |
| ------- | ------------------------------------------------------------------------------- | --------------------------------- |
| TEST-01 | As a QA, I want to test all API endpoints with Postman.                         | Postman collection                |
| TEST-02 | As a QA, I want to write unit tests for all service and repository layers.      | JUnit tests with 80%+ coverage    |
| TEST-03 | As a Developer, I want to use GitHub Actions to run tests automatically on PRs. | CI pipeline with unit test runner |

---

## Final Output

| Deliverable | Description                              |
| --------- | ---------------------------------------- |
| Codebase  | Java Spring Boot app with GitHub repo    |
| Databases | MySQL + MongoDB schemas and queries      |
| Cloud Infra | GCP App Engine, Cloud SQL, Firestore     |
| Docs     | Swagger/OpenAPI docs for all endpoints   |
| Security | Basic authentication with JWT (optional) |
| Testing | Unit tests, Postman tests, mock tests    |

---
