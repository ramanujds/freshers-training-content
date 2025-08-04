## **Compute Services in Azure**

| Azure Service                               | Equivalent in AWS                   | Equivalent in GCP                        | Use Case                                                                      |
| ------------------------------------------- | ----------------------------------- | ---------------------------------------- | ----------------------------------------------------------------------------- |
| **Azure Virtual Machines (VMs)**            | EC2                                 | Compute Engine                           | Run OS-level workloads, custom apps, lift-and-shift migration                 |
| **Azure App Service**                       | Elastic Beanstalk / App Runner      | App Engine                               | Deploy web apps & APIs (Node.js, Java, Python) without managing servers       |
| **Azure Container Instances (ACI)**         | AWS Fargate (without orchestration) | Cloud Run (without scale-to-zero)        | Run containers instantly, great for microservices or scheduled jobs           |
| **Azure Kubernetes Service (AKS)**          | EKS                                 | GKE                                      | Managed Kubernetes, full orchestration, autoscaling                           |
| **Azure Functions**                         | AWS Lambda                          | Cloud Functions                          | Serverless code triggered by events (HTTP, timer, queue)                      |
| **Azure Batch**                             | AWS Batch                           | Cloud Batch (Preview)                    | Run parallel, high-performance batch jobs — simulations, ML training          |
| **Azure Virtual Machine Scale Sets (VMSS)** | Auto Scaling Groups                 | Managed Instance Groups                  | Autoscale VMs based on demand                                                 |
| **Azure Dedicated Hosts**                   | Dedicated Hosts                     | Sole-tenant Nodes                        | Host VMs on isolated hardware (compliance/security needs)                     |
| **Azure Service Fabric**                    | ECS (to some extent)                | N/A (GCP doesn’t have direct equivalent) | Microservices platform, used internally by Azure, supports containers and VMs |

---

## Detailed Explanation & Use Cases

### 1. **Azure VMs**

* Like EC2 or Compute Engine
* Offers full OS control (Windows/Linux)
* Use for legacy apps, app servers, custom environments
* Supports scale sets (VMSS) for horizontal scaling

**When to use**: You need full control of the OS, install custom software, or migrate existing apps as-is.

---

### 2. **Azure App Service**

* PaaS offering for Web Apps and APIs
* Abstracts infra — you focus on code
* Supports custom domains, scaling, staging slots, CI/CD

**When to use**: For web apps or REST APIs in .NET, Java, Node.js, etc. that don't need infra management.

---

### 3. **Azure Container Instances (ACI)**

* Lightweight, serverless container runtime
* Starts containers in seconds
* No orchestration (unlike AKS), pay-per-second pricing

**When to use**: Background tasks, API workers, short-lived jobs, event-driven microservices.

---

### 4. **Azure Kubernetes Service (AKS)**

* Fully managed Kubernetes with integrated monitoring, auto-scaling, and AAD
* Supports Windows + Linux nodes, spot VMs, availability zones

**When to use**: Production workloads needing orchestration, microservices, service mesh, advanced networking.

---

### 5. **Azure Functions**

* Event-driven, stateless, serverless functions
* Supports bindings (e.g., trigger from storage queue, HTTP, etc.)
* Auto-scale to 0

**When to use**: Small logic pieces like webhook processors, scheduled tasks, serverless APIs.

---

### 6. **Azure Batch**

* Designed for **large-scale parallel compute jobs**
* You define a pool of VMs; it manages scheduling and execution

**When to use**: Media rendering, genome analysis, big simulations, scientific jobs.

---

### 7. **Azure VMSS**

* Manages **auto-scaling** of VMs based on CPU/memory/load
* Like EC2 Auto Scaling Group or MIG in GCP

**When to use**: Backend services needing elasticity and resilience.

---

## Identity & Access with Compute

Most compute services integrate tightly with:

* **Azure Active Directory (AAD)** — for RBAC and access tokens
* **Managed Identities** — for apps to access Key Vault, Storage, etc. without secrets

---

## Choosing Between Compute Services

| Goal                                         | Use This        |
| -------------------------------------------- | --------------- |
| Full control, legacy migration               | Azure VMs       |
| Web app with auto-scaling & deployment slots | App Service     |
| Containers without Kubernetes                | ACI             |
| Container orchestration                      | AKS             |
| Event-based microservices                    | Azure Functions |
| High-throughput batch processing             | Azure Batch     |

