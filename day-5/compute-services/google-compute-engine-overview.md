## What is Google Compute Engine (GCE)?

**GCE** lets you create and run **virtual machines (VMs)** on Google’s global infrastructure.
Think of it like renting a computer in Google’s data centers where you can install anything — a web server, database, backend app, etc.

It is similar to:

* **AWS EC2**
* **Azure Virtual Machines**

---

## Core Features of GCE

### 1. **Custom Machine Types**

* You can choose exactly how much **CPU and memory** you want.
* Useful if your app doesn’t fit into standard sizes.

> Example: 2 vCPUs and 6.5 GB RAM — tailor-made for your use case.

---

###  **Preemptible VMs (now Spot VMs)**

* Very **low-cost VMs** for short-lived, fault-tolerant tasks.
* Google can **terminate** them anytime (usually within 24 hours).

> Best for: batch jobs, data processing, CI/CD tasks.

---

### **Live Migration**

* GCE can **migrate your VMs live** to other hosts without downtime.
* Great for maintenance or hardware upgrades with no user impact.

---

### **Automatic Restart**

* If a VM crashes, GCE can **restart it automatically** to keep your service available.

---

### **Sustained Use Discounts**

* The **longer** you use a VM in a month, the **more discount** you get — automatically!

---

###  **Multiple OS Options**

* Choose from various Linux distros (Ubuntu, CentOS, Debian), or Windows Server versions.

---

### **Instance Templates & Managed Instance Groups (MIGs)**

* **Templates**: Define configs for VMs (OS, machine type, etc.)
* **MIGs**: Automatically create and scale VMs based on load, using templates.

---

### **Integration with Other GCP Services**

* GCE works seamlessly with:

    * **Cloud Storage** (for storing files)
    * **Cloud SQL** (managed database)
    * **Cloud Load Balancer**
    * **Stackdriver** (now part of **Cloud Operations** for logging & monitoring)

---

## Common Applications / Use Cases of GCE

###  **Hosting Web Applications**

* Deploy full-stack apps (e.g., Java + MySQL)
* Install Nginx/Apache to serve content

> Use Case: Host a Spring Boot backend and React frontend on GCE VMs.

---

### **Big Data & Machine Learning**

* Use high-CPU or GPU-based VMs for:

    * Training ML models
    * Running TensorFlow
    * Processing large datasets

> Use Case: Run Apache Spark jobs or train deep learning models on GPU-enabled VMs.

---

### **Dev/Test Environments**

* Quickly spin up testing environments
* Use preemptible VMs to cut costs

> Use Case: CI/CD pipelines or automated testing VMs that spin up and shut down based on pipeline triggers.

---

### **Running Legacy or Custom Software**

* Some apps don’t fit in containers or PaaS — VMs are still ideal.

> Use Case: Legacy ERP software that requires specific OS/kernel versions.

---

### **Global Web Services**

* Deploy VMs in multiple regions
* Use load balancers to route traffic efficiently

> Use Case: Host a global e-commerce platform with auto-scaling VMs across continents.

---

##  Example: Deploying a Basic Web App on GCE

1. **Create a VM**:

   ```bash
   gcloud compute instances create web-server \
     --zone=us-central1-a \
     --machine-type=e2-medium \
     --image-family=debian-11 --image-project=debian-cloud
   ```

2. **Install Nginx**:

   ```bash
   sudo apt update && sudo apt install nginx -y
   ```

3. **Open firewall**:

   ```bash
   gcloud compute firewall-rules create allow-http \
     --allow tcp:80 \
     --target-tags http-server
   ```

4. **Assign a tag to VM**:

   ```bash
   gcloud compute instances add-tags web-server --tags=http-server
   ```

Now visit the external IP — your web server is live!
