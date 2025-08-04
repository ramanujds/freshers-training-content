## What is Autoscaling?

**Autoscaling** automatically adds or removes VM instances in a managed instance group (MIG) based on load (like CPU utilization). This helps:

* Maintain performance during traffic spikes
* Save costs during idle times

---

## Prerequisites

Before you can set up autoscaling, you need:

* A **VM Instance Template** (used to create identical VMs)
* A **Managed Instance Group (MIG)**
* A **Load Balancer (optional but common)**

---

## Step-by-Step: Set Up Autoscaling Using Cloud Console

---

### Step 1: Create an Instance Template

1. Go to **Compute Engine > Instance templates**
2. Click **"Create instance template"**
3. Configure:

    * Name: `my-template`
    * Machine type: `e2-medium` or as needed
    * Boot disk: Ubuntu/Debian/CentOS, etc.
    * Add a **startup script** if you want software to be installed on boot
4. Click **Create**

---

### Step 2: Create a Managed Instance Group (MIG)

1. Go to **Compute Engine > Instance groups**

2. Click **"Create instance group"**

3. Set:

    * Name: `my-instance-group`
    * Location: `Single zone` (for now)
    * Zone: `us-central1-a` (or your choice)
    * Instance template: `my-template`
    * Autoscaling: **Turn ON**

4. Configure autoscaling settings:

    * **Minimum number of instances**: 1
    * **Maximum number of instances**: 5
    * **Autoscaling metric**: CPU Utilization
    * **Target CPU utilization**: 60% (default is fine)

5. Click **Create**

Your MIG now automatically adds/removes VMs based on load!

---

### Step 3 (Optional but Recommended): Attach a Load Balancer

1. Go to **Network services > Load balancing**
2. Create an **HTTP load balancer**
3. Set up:

    * Backend: your **Managed Instance Group**
    * Frontend: create a new IP + port 80
4. Create health checks
5. Finish and **create** the load balancer

This lets your traffic be evenly distributed across the autoscaled VMs.

---

## Autoscaling with gcloud CLI (Optional)

### Create an instance template:

```bash
gcloud compute instance-templates create my-template \
    --machine-type=e2-medium \
    --image-family=debian-11 \
    --image-project=debian-cloud
```

### Create a managed instance group with autoscaling:

```bash
gcloud compute instance-groups managed create my-group \
    --base-instance-name=my-vm \
    --template=my-template \
    --size=1 \
    --zone=us-central1-a
```

### Enable autoscaling:

```bash
gcloud compute instance-groups managed set-autoscaling my-group \
    --max-num-replicas=5 \
    --min-num-replicas=1 \
    --target-cpu-utilization=0.6 \
    --cool-down-period=60 \
    --zone=us-central1-a
```

---

## How It Works

* If the **average CPU usage exceeds 60%**, new VMs will be added
* If the usage drops below the threshold, instances will be deleted
* **Health checks** ensure only healthy instances receive traffic

---

## Best Practices

* Use **startup scripts** in your template to auto-install app dependencies
* Always configure **health checks** for reliability
* Combine with **Load Balancers** for high availability
* Monitor with **Cloud Monitoring and Logging**

