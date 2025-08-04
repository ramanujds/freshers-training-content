## **1. Important Azure Services**

Here’s a categorized list of **core Azure services** along with **use cases**:

### Compute

| **Service**                         | **Description**                               | **Use Case**                                                    |
| ----------------------------------- | --------------------------------------------- | --------------------------------------------------------------- |
| **Azure Virtual Machines (VM)**     | IaaS offering for running OS and applications | Host custom apps, migrate legacy systems                        |
| **App Services**                    | PaaS for hosting web apps, REST APIs          | Deploy Node.js, .NET, Java apps without managing infrastructure |
| **Azure Functions**                 | Serverless compute                            | Run small units of code on triggers like HTTP, timer, queues    |
| **Azure Kubernetes Service (AKS)**  | Managed Kubernetes                            | Orchestrate containerized workloads at scale                    |
| **Azure Container Instances (ACI)** | Lightweight containers without orchestration  | Quick microservices or job runs without managing VMs            |

---

### Storage

| **Service**      | **Description**                      | **Use Case**                        |
| ---------------- | ------------------------------------ | ----------------------------------- |
| **Blob Storage** | Object storage for unstructured data | Store media files, backups, logs    |
| **Azure Files**  | Fully managed file shares            | Shared drives across VMs            |
| **Disk Storage** | Persistent block storage for VMs     | Attach high-performance SSDs to VMs |

---

### Networking

| **Service**                | **Description**                       | **Use Case**                                   |
| -------------------------- | ------------------------------------- | ---------------------------------------------- |
| **Virtual Network (VNet)** | Private network within Azure          | Isolate resources securely                     |
| **Application Gateway**    | Layer 7 load balancer with WAF        | Secure web traffic                             |
| **Azure Front Door**       | Global HTTP/HTTPS load balancing      | Accelerate and secure web apps globally        |
| **ExpressRoute**           | Dedicated private connection to Azure | Low latency, high security for on-prem → cloud |

---

### Databases

| **Service**                             | **Description**               | **Use Case**                                |
| --------------------------------------- | ----------------------------- | ------------------------------------------- |
| **Azure SQL Database**                  | Managed relational DB (PaaS)  | Modern .NET or Java apps needing SQL Server |
| **Cosmos DB**                           | Globally distributed NoSQL DB | Event-driven, IoT, large-scale web apps     |
| **Azure Database for PostgreSQL/MySQL** | Managed OSS DB engines        | Use PostgreSQL or MySQL in Azure            |

---

### DevOps & CI/CD

| **Service**        | **Description**                            | **Use Case**                     |
| ------------------ | ------------------------------------------ | -------------------------------- |
| **Azure DevOps**   | CI/CD pipelines, Repos, Boards, Test Plans | Complete DevOps lifecycle        |
| **GitHub Actions** | CI/CD directly from GitHub                 | Build, test, deploy apps on push |

---

### AI & Analytics

| **Service**                 | **Description**              | **Use Case**                        |
| --------------------------- | ---------------------------- | ----------------------------------- |
| **Azure Synapse Analytics** | Big data + data warehouse    | Complex data queries, analytics     |
| **Azure Machine Learning**  | Build/train/deploy ML models | AI projects, training custom models |
| **Power BI Embedded**       | Embedded analytics           | Show dashboards in apps             |

---

### Identity & Security

| **Service**                          | **Description**                | **Use Case**                   |
| ------------------------------------ | ------------------------------ | ------------------------------ |
| **Azure Active Directory (AAD)**     | Identity and access management | Single sign-on, RBAC, MFA      |
| **Key Vault**                        | Store secrets, keys, certs     | Secure credentials for apps    |
| **Azure Defender / Security Center** | Cloud-native threat protection | Secure workloads and resources |

---

## **2. Azure vs AWS vs GCP – Key Comparison**

| Feature          | **Azure**                                           | **AWS**                                 | **GCP**                                 |
| ---------------- | --------------------------------------------------- | --------------------------------------- | --------------------------------------- |
| **Global Reach** | 60+ regions                                         | 102+ zones in 32 regions                | 38 regions (fast-growing)               |
| **Strength**     | Hybrid cloud, enterprise integrations (Windows, AD) | Richest service offering, market leader | Strong in AI/ML, Kubernetes             |
| **Compute**      | VM, AKS, Functions                                  | EC2, EKS, Lambda                        | GCE, GKE, Cloud Functions               |
| **Storage**      | Blob, Files, Queues                                 | S3, EFS, Glacier                        | Cloud Storage, Filestore                |
| **Database**     | SQL DB, Cosmos DB                                   | RDS, DynamoDB, Aurora                   | Cloud SQL, Bigtable, Firestore          |
| **AI/ML**        | Azure ML, Cognitive Services                        | SageMaker, Rekognition, Translate       | Vertex AI, Vision AI, AutoML            |
| **CI/CD**        | Azure DevOps, GitHub Actions                        | CodePipeline, CodeBuild                 | Cloud Build, Cloud Deploy               |
| **Hybrid Cloud** | Strong (Arc, Stack, AAD)                            | Outposts                                | Anthos                                  |
| **Kubernetes**   | AKS (tight AAD integration)                         | EKS (flexible but complex)              | GKE (best-in-class automation)          |
| **Pricing**      | Competitive with committed usage                    | Pay-as-you-go, spot pricing             | Sustained discounts, AI-focused billing |

---

## When to Choose What?

* **Azure**: Best for enterprises already using Microsoft stack (Windows Server, AD, SQL Server), and hybrid cloud.
* **AWS**: Most mature, vast ecosystem — ideal for startups, large-scale apps, and those needing bleeding-edge services.
* **GCP**: Best for ML/AI heavy apps, analytics, and tight Kubernetes automation.

---

## Example Scenario

**You want to build a web app using containers, with a SQL backend, CI/CD, and secure secret storage.**

### Azure:

* AKS for container orchestration
* Azure SQL for DB
* Azure DevOps + GitHub for CI/CD
* Key Vault for secrets

### AWS:

* EKS + Fargate
* RDS (SQL Server or Aurora)
* CodePipeline + CodeBuild
* Secrets Manager

### GCP:

* GKE
* Cloud SQL
* Cloud Build
* Secret Manager

