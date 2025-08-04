
## Options to Connect Across VPCs

### **1. VPC Peering (Private IP access only)**

If you want to **connect via private IP**, you need to establish **VPC peering** between the two VPCs.

#### Requirements:

* Both VPCs must be **in the same project**, or **use VPC Network Peering across projects**.
* The VPC where the **Cloud SQL instance resides** must have **private IP enabled**.
* Create a **VPC peering** between:

    * The VPC containing the VM
    * The **Google-managed service network** of the Cloud SQL VPC

#### Steps:

1. Go to **VPC network > VPC network peering**.
2. Create a **peering connection** between the two VPCs.
3. Ensure **non-overlapping CIDR ranges**.
4. Update **routes and firewall rules** to allow traffic (TCP `3306` for MySQL).

> **Note:** VPC peering is **not transitive**. If you peer A to B and B to C, A cannot reach C.

---

### **2. Use Public IP (if Private IP is not possible)**

You can connect to the Cloud SQL instance using its **public IP**, regardless of VPCs.

#### Requirements:

* Cloud SQL instance must have a **public IP**.
* You must **authorize the VM’s external IP** (or subnet) in **SQL > Connections > Authorized Networks**.
* Ensure **outbound firewall rules** allow TCP traffic to `3306`.

This is simpler but **less secure** unless you use **SSL/TLS or Cloud SQL Auth Proxy**.

---

### **3. Use Cloud SQL Auth Proxy**

Cloud SQL Auth Proxy allows **secure connection** to Cloud SQL instances (public or private IP) using service accounts, **without exposing IPs**.

#### Benefits:

* Works across VPCs
* Adds authentication and encryption
* Reduces networking complexity

> You install the proxy on the VM, authenticate using a service account, and connect to `localhost` instead of using IPs.

---


