## What Is GCP Networking?

GCP Networking is a **software-defined virtual network** that allows you to connect, isolate, and control communication between your resources like:

* Compute Engine (VMs)
* Kubernetes clusters
* Cloud SQL
* Load Balancers
* Internet and external systems

It’s like laying down **virtual roads** between your services in the cloud.

---

## Core Concepts in GCP Networking

Let’s go over the **building blocks**.

---

### 1. **VPC (Virtual Private Cloud)**

A **VPC** is like a private network in the cloud, just like you'd have a home or office network.

* You can have multiple VPCs in a project.
* Each VPC can span multiple **regions** (global scope).
* VPC contains **subnets**, **firewalls**, **routes**, etc.

 **Use Case**: You want to run some VMs in the US and some in India, all under the same private network — you create one VPC with subnets in both regions.

---

### 2. **Subnetworks (Subnets)**

Each VPC is divided into **subnets**, each tied to a **region**.

* Subnets define the **IP address range** for resources in that region.
* You can assign **internal IPs** from the subnet.

 **Use Case**: To organize your app into frontend, backend, and DB tiers, you create separate subnets.

---

### 3. **IP Addressing**

* **Internal IP**: Assigned from the subnet’s range (used within GCP).
* **External IP**: Public IP to allow access over the internet.

 **Use Case**: A VM that hosts a website needs an **external IP**, while your backend services might only need **internal IPs**.

---

### 4. **Firewall Rules**

Used to control **who can connect** to your VM or service.

* **Ingress**: Incoming traffic
* **Egress**: Outgoing traffic
* You define:

    * Source IP ranges
    * Allowed protocols and ports (like TCP:22 for SSH)

**Use Case**: You want only your office IP to SSH into the VM → create an ingress rule for TCP:22.

---

### 5. **Routes**

* Routes define how packets travel within the network.
* **Default route** sends traffic to the internet.
* You can create **custom routes** to send traffic to VPNs or other networks.

---

### 6. **Peering and VPN**

* **VPC Peering**: Connect two VPCs privately.
* **Cloud VPN**: Connect your on-premise network to GCP over a secure VPN.
* **Interconnect**: Dedicated physical line between your data center and GCP.

**Use Case**: You want to securely extend your company’s internal network into the cloud.

---

### 7. **Load Balancing**

Google Cloud offers **global** and **regional** load balancing.

* **Global HTTP(S) Load Balancer**: For web apps with one global IP.
* **Internal Load Balancer**: Balances traffic inside your private network.

**Use Case**: Distribute user traffic to multiple VMs behind a single IP with autoscaling.

---

### 8. **Cloud NAT**

**Network Address Translation (NAT)** allows VMs **without external IPs** to connect to the internet **securely** for outbound access (e.g., to download packages).

**Use Case**: Your backend VM needs to download updates but shouldn’t be publicly accessible.

---

## Example Setup

Let’s say you have a web application:

| Layer        | Resource      | Network Setup                                             |
| ------------ | ------------- | --------------------------------------------------------- |
| Frontend     | Load Balancer | Exposes port 80 globally                                  |
| Web Servers  | GCE VMs       | In a subnet with external IPs or behind a NAT             |
| Database     | Cloud SQL     | Only accessible via internal IP from VMs                  |
| Admin Access | SSH to VM     | Controlled via firewall rule allowing TCP:22 from your IP |

---

## ⚙️ GCP Networking Services Summary

| Service               | Purpose                               |
| --------------------- | ------------------------------------- |
| VPC                   | Your virtual network in GCP           |
| Subnets               | IP range in a region                  |
| Firewall Rules        | Access control                        |
| Cloud Load Balancing  | Distribute traffic                    |
| Cloud NAT             | Outbound internet without external IP |
| VPC Peering / VPN     | Connect networks                      |
| Private Google Access | Access Google APIs from internal IPs  |

---

## Best Practices

1. **Use least privilege in firewall rules** (allow only what’s needed).
2. **Use internal IPs** wherever possible (more secure and cheaper).
3. **Organize services in subnets** by role or function (e.g., frontend/backend/db).
4. **Use labels and service accounts** for managing access and logging.
5. **Use Private Google Access** to securely connect to GCP services from private VMs.

