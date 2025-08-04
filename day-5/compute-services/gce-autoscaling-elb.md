

# GCE Autoscaling and Elastic Load Balancer

---

## **GCE Autoscaling**

### What is Autoscaling?

**Autoscaling** is the ability to **automatically increase or decrease** the number of VM instances based on **real-time demand**.

### Where it’s used?

With **Managed Instance Groups (MIGs)**.

> A **Managed Instance Group (MIG)** is a group of identical VM instances managed as a single unit.

---

### Why Use Autoscaling?

* Saves **money** — you don't pay for unused VMs
* Ensures **performance** during traffic spikes
* Helps with **fault tolerance** — if some VMs fail, new ones replace them

---

### How It Works

1. You define **autoscaling policies** for your MIG:

    * CPU utilization
    * Load balancer capacity
    * Stackdriver monitoring metrics
    * Schedule-based (e.g., night vs. daytime traffic)

2. GCE watches the metric.

3. It **adds or removes VMs** in the group accordingly.

---

### Example Use Case

You run an e-commerce site that gets more traffic during weekends.
You configure your MIG to:

* Scale out when CPU usage > 60%
* Scale in when CPU usage < 20%

---

### Sample Command

```bash
gcloud compute instance-groups managed create web-app-group \
    --base-instance-name web-app \
    --template web-app-template \
    --size 2 \
    --zone us-central1-a
```

Enable autoscaling:

```bash
gcloud compute instance-groups managed set-autoscaling web-app-group \
    --max-num-replicas 10 \
    --min-num-replicas 2 \
    --target-cpu-utilization 0.6 \
    --cool-down-period 90
```

---

## **Elastic Load Balancer (HTTP(S) Load Balancer)**

### What is an Elastic Load Balancer?

It’s a **fully-managed** service that **distributes incoming traffic** across your backend VMs **globally or regionally**.

Google’s HTTP(S) Load Balancer is **elastic** — it scales automatically based on traffic volume.

---

### Components of Load Balancing in GCE

1. **Frontend Configuration** – Public IP + protocol (HTTP, HTTPS)
2. **Backend Services** – Your MIGs (groups of VMs)
3. **URL Map / Routing Rules** – Decide which request goes where
4. **Health Checks** – Periodically check if backends are healthy

---

### Benefits

| Feature                   | Description                              |
| ------------------------- | ---------------------------------------- |
| 🌍 Global load balancing  | Directs users to closest healthy backend |
| 🔁 Auto-scaling backend   | Works with MIGs                          |
| ⚙️ Smart routing          | Based on URL, headers, cookies           |
| 🔐 HTTPS support          | SSL termination at the load balancer     |
| 📊 Logging and monitoring | Integrated with Cloud Logging/Monitoring |

---

### Example Use Case

You have users from India, the US, and Europe.
You deploy MIGs in `us-central1`, `asia-south1`, and `europe-west1`.

Google’s load balancer:

* Sends Indian users to `asia-south1`
* Sends US users to `us-central1`
* Automatically **reroutes** if any region fails

---

### Sample Architecture

```
[ User Requests ]
       |
       v
+----------------------+
|   HTTPS Load Balancer|
+----------------------+
       |
       v
[ Backend Service (MIGs in multiple zones) ]
       |
       v
[ VM Instances (web servers) ]
```

---

### Setting Up Load Balancer

1. Create a **MIG**
2. Define **instance template**
3. Configure **health check**
4. Set up **backend service**
5. Attach **URL map**
6. Create **frontend IP and DNS**

---

## Use Case: Autoscaling + Load Balancer

### Example Scenario
You deploy a Java-based Spring Boot backend for a ride-hailing app.

* Use a **MIG** to run the app on multiple VMs.
* Configure **autoscaling** to handle rush-hour traffic.
* Add **HTTP(S) Load Balancer** for:

    * Global user access
    * SSL support
    * Intelligent routing

Result:
✅ High availability,
✅ Cost-effective scaling,
✅ Great user experience

---
