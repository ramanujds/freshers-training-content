Let's walk through the **step-by-step process to autoscale a Java Spring Boot app** running on port **5000** using **Google Compute Engine Managed Instance Groups**.

We'll cover:

1. Create a VM **instance template** that clones your GitHub repo, builds the app, and runs it
2. Create a **health check**
3. Set up a **Managed Instance Group (MIG)** with **autoscaling**
4. Attach to a **Load Balancer** for traffic distribution

---

## Step-by-Step Setup

---

### Step 1: Write a Startup Script

This script will:

* Install JDK, Maven, and Git
* Clone your GitHub repo
* Build the app using `mvn clean package`
* Run the JAR on port 5000

**startup-script.sh**

```bash
#!/bin/bash
# Update and install dependencies
apt-get update
apt-get install -y openjdk-17-jdk maven git

# Clone the GitHub repo
git clone https://github.com/ramanujds/spring-boot-gcp /opt/app

cd /opt/app

# Build the app
mvn clean package

# Run the app on port 5000
nohup java -jar target/*.jar --server.port=5000 > /opt/app/app.log 2>&1 &
```

---

### Step 2: Create an Instance Template

Go to: **Compute Engine → Instance Templates → Create Instance Template**

Configure:

* Name: `java-app-template`
* Machine type: `e2-medium` (or your choice)
* Boot disk: Ubuntu 22.04
* In **Management > Automation**, paste your **startup script** above
* Allow **HTTP** and **custom TCP port 5000** in the firewall section

Click **Create**

---

### Step 3: Create a Health Check

Go to: **Compute Engine → Health checks → Create health check**

Configure:

* Name: `java-app-health-check`
* Protocol: **TCP**
* Port: `5000`
* Healthy threshold: 2
* Unhealthy threshold: 2
* Check interval: 10s

Create the health check.

---

### Step 4: Create a Managed Instance Group (MIG)

Go to: **Compute Engine → Instance Groups → Create Instance Group**

Configure:

* Name: `java-app-group`
* Location: Single zone (e.g., `us-central1-a`)
* Instance template: `java-app-template`
* Initial size: 1
* **Autoscaling**: ON

    * CPU utilization target: 60%
    * Min instances: 1
    * Max instances: 5
* Health check: Select `java-app-health-check`

Click **Create**

---

### Step 5 (Optional): Set Up Load Balancer for Port 5000

> Default HTTP Load Balancer only supports port 80/443. For port 5000, use a **TCP Load Balancer**.

1. Go to **Network Services > Load balancing → Create Load Balancer**
2. Choose **TCP Load Balancer**
3. Backend:

    * Instance group: `java-app-group`
    * Port: `5000`
    * Health check: `java-app-health-check`
4. Frontend:

    * IP: Reserve or use ephemeral
    * Port: `5000`

Click **Create**

---

### Final Output

Now you have:

* A Java app autoscaled based on CPU usage
* Running on **port 5000**
* Load balanced with a TCP load balancer
* Automatically clones, builds, and runs from your GitHub repo

---

## Test It

After deployment:

* Access the load balancer's IP:
  `http://<EXTERNAL_IP>:5000`
* Stress the app to test autoscaling:
  Use Apache Bench or a load tester

---


