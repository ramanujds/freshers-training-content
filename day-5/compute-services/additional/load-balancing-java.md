Let’s walk through a **step-by-step guide** to set up an **HTTP Load Balancer in GCP using the Console** for your **Spring Boot application** that runs on **port 80**.

We'll assume you're using a **Managed Instance Group (MIG)** running your app (e.g., cloned and built from the GitHub repo) and serving it on port 80.

---

## Goal:

Set up a **Global HTTP Load Balancer** to:

* Distribute incoming HTTP traffic to a group of VMs
* Use **port 80** (default for web apps)
* Autoscale the backend VMs
* Health-check the VMs to ensure only healthy ones get traffic

---

## Prerequisites:

* You’ve already created:

    * An **Instance Template** with a startup script
    * A **Managed Instance Group (MIG)** based on the template
    * Your Spring Boot app listens on **port 80**

---

## Step-by-Step Guide: HTTP Load Balancer on GCP Console

---

### Step 1: Set Up a Health Check

1. Go to **Navigation Menu → Compute Engine → Health checks**
2. Click **Create health check**
3. Name: `spring-health-check`
4. Protocol: **HTTP**
5. Port: `80`
6. Request path: `/` (or your app’s health endpoint)
7. Keep defaults and click **Create**

---

### Step 2: Create a Backend Service

1. Go to **Navigation Menu → Network Services → Load balancing**
2. Click **Create Load Balancer**
3. Select **HTTP(S) Load Balancing → Start configuration**
4. Choose:

    * **From Internet to my VMs**
    * Click **Continue**

#### Configure Backend:

5. Click **Backend Configuration**
6. Click **Create a backend service**

    * Name: `spring-backend-service`
    * Protocol: **HTTP**
    * Port: `80`
    * Backend type: **Instance group**
7. Click **Add backend**

    * Select your MIG (e.g., `java-app-group`)
    * Set balancing mode: **Rate or CPU**
8. Set **Capacity** as needed (e.g., 100%)
9. Select the health check: `spring-health-check`
10. Click **Create**

---

### Step 3: Configure URL Map and Frontend

#### Host and Path Rules:

1. Click **Host and path rules**

    * Use the default rule: `/* → spring-backend-service`

#### Frontend Configuration:

2. Click **Frontend Configuration**

    * Name: `spring-frontend`
    * Protocol: **HTTP**
    * IP version: **IPv4**
    * Port: **80**
    * Select/create a new IP address (static or ephemeral)

---

### Step 4: Review and Create

1. Click **Review and finalize**
2. Click **Create**

⏳ Wait a few minutes for the load balancer to be provisioned.

---

### Step 5: Test It

1. Once it’s ready, you'll see an **external IP address** under **Frontend**
2. Visit:

   ```
   http://<EXTERNAL_IP>
   ```
3. You should see your **Spring Boot application homepage**.

---

## What Happens Behind the Scenes

* Load Balancer listens on port **80**
* Distributes traffic to healthy VMs in the **MIG**
* Automatically balances across regions if multi-region is set up
* VMs scale based on CPU or request load
* Load balancer removes unhealthy instances automatically

---

## Optional – HTTPS

You can add **SSL certificates** later to enable **HTTPS** using GCP’s **HTTP(S) Secure Load Balancer** with auto-managed certs.

