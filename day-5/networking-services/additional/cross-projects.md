## Ways to Enable Communication Between Projects

There are multiple ways depending on what kind of resources you're trying to connect and whether they're in the **same organization**.

---

### 1. **Shared VPC (Best for Same Organization)**

* **Use case**: Centralize networking while allowing multiple projects to deploy resources.
* **How it works**:

    * One project (host project) contains the **VPC network**.
    * Other projects (service projects) share this VPC.
    * VM instances in service projects can **use subnets and IPs from the host project's VPC**.

Works **only within the same organization**.

---

### 2. **VPC Network Peering (For Any Projects)**

* **Use case**: Connect VPC networks from different projects.
* **How it works**:

    * Set up **VPC peering** between the two VPCs (from different projects).
    * Routes and firewall rules must be configured.
    * CIDR blocks must not overlap.

Works across **projects and even across organizations**, as long as permissions are handled.

---

### 3. **Cloud SQL Auth Proxy or Public IP (For DB Access Across Projects)**

* **Cloud SQL with Public IP**:

    * Add the IP/subnet of the other project’s VM to **Authorized Networks**.
* **Cloud SQL Auth Proxy**:

    * Use IAM roles and service account keys to allow secure access from another project.

Good for database access **without VPC peering**.

---

### 4. **Cross-Project IAM Roles and Service Accounts**

* Give permissions to service accounts or users from **other projects**.
* Useful for:

    * **Cloud Storage access**
    * **Pub/Sub**
    * **BigQuery**
    * **Cloud SQL Proxy authentication**

Must grant correct IAM roles to **principals from the other project**.

---



## 1. **Connect via Public IP (Simplest Option)**

### Prerequisites:

* Cloud SQL instance must have a **public IP**.
* You know the **public IP address** of the VM.
* Both projects are in **any GCP organization or even external**.

### Steps:

1. **Enable Public IP for Cloud SQL** (in Project B):

    * Go to SQL > Your DB instance > Connections
    * Under **Public IP**, enable it.

2. **Add the VM’s IP to Authorized Networks**:

    * Still under **Connections > Authorized networks**
    * Add VM’s external IP from Project A.
    * Save changes.

3. **Firewall Rule (if needed)**:

    * On SQL instance's project (Project B), allow inbound traffic on TCP port `3306`.

4. **Connect from VM**:

   ```bash
   mysql -h [DB_PUBLIC_IP] -u [USER] -p
   ```

**Works across all projects**, easy to test.
**Less secure**, traffic goes over the internet (use SSL ideally).

---

## 2. **Connect via Private IP + VPC Peering (Secure Option)**

Use if you want the **VM to connect via internal IP**, avoiding public internet.

### Steps:

1. **Private IP for Cloud SQL (Project B)**:

    * Enable **Private IP** and set up VPC peering with your service network.
    * Get the internal IP address of the database.

2. **VPC Peering Between Projects**:

    * Peer the VPC of Project A (VM) and Project B (Cloud SQL).
    * Go to `VPC network > VPC peering` in both projects.
    * Set up peering both ways.
    * Ensure **non-overlapping CIDR ranges**.

3. **Firewall Rules**:

    * In Project B, allow **TCP 3306** from the IP range of Project A’s subnet.

4. **Test Connection from VM (Project A)**:

   ```bash
   mysql -h [DB_PRIVATE_IP] -u [USER] -p
   ```

Highly secure.
More setup required. Projects need coordination.

---

## 3. **Use Cloud SQL Auth Proxy (Recommended for Apps)**

### Why use:

* Secure by default
* Handles authentication via IAM
* No need to expose DB to internet or use peering

### Steps:

1. **Create a service account in Project B (SQL project)** with:

    * `Cloud SQL Client` role

2. **Grant access to this service account in Project A**:

    * Share service account or create a new one in Project A with proper roles.

3. **Install Cloud SQL Auth Proxy on the VM**:

    * Run the proxy with the DB instance connection string.
    * Connect your Spring Boot app or CLI to `localhost:3306`.

Best for production apps.
Requires a bit more setup with IAM and service accounts.

---

## Best Practice

| For                           | Recommendation           |
| ----------------------------- | ------------------------ |
| Simple, quick access          | Public IP + whitelist IP |
| Secure, private network       | Private IP + VPC Peering |
| Secure with IAM, no VPC setup | Cloud SQL Auth Proxy     |

Here’s a **step-by-step guide** using the **Google Cloud Console** to set up **VM (in Project A)** to connect to **Cloud SQL over Private IP (in Project B)** using **VPC Peering**.

---

## Architecture Overview

* **Project A**: Contains the **VM**
* **Project B**: Contains the **Cloud SQL instance** with **Private IP enabled**
* Goal: Allow VM in Project A to connect securely over private IP to DB in Project B

---

## Step 1: Enable Private IP on Cloud SQL (Project B)

1. Go to **SQL > Your Instance** in Project B.
2. Click **Edit**.
3. Under **Connections**, find the **Network** section.
4. Enable **Private IP** if not already enabled.

    * You will be prompted to select a **VPC network**.
    * Select the VPC where the Cloud SQL will reside.
5. Save changes and wait for Cloud SQL to provision a **private IP address**.

---

## Step 2: Check/Configure VPC Subnets (Both Projects)

* Go to **VPC network > VPC networks**.
* Ensure **Project A** and **Project B** have **non-overlapping IP ranges**.

    * Example:

        * Project A: `10.10.0.0/16`
        * Project B: `10.20.0.0/16`

> VPC peering requires unique IP ranges.

---

## Step 3: Create VPC Peering Between Projects

You need to do this **in both projects**.

### In Project A (VM project):

1. Go to **VPC network > VPC network peering**.
2. Click **Create connection**.
3. Fill details:

    * **Name**: `peer-to-db`
    * **Your VPC network**: Select your VM's VPC
    * **Peered VPC network**: Choose **“Another project”**

        * Enter **Project B ID**
        * Enter **VPC name** from Project B (Cloud SQL's network)
4. Click **Create**.

### In Project B (DB project):

1. Go to **VPC network > VPC network peering**.
2. Click **Create connection**.
3. Fill details:

    * **Name**: `peer-to-vm`
    * **Your VPC network**: Select the Cloud SQL’s VPC
    * **Peered VPC network**: Choose **“Another project”**

        * Enter **Project A ID**
        * Enter **VPC name** from Project A (VM’s network)
4. Click **Create**.

After a few seconds, both sides should show **ACTIVE** status.

---

## Step 4: Update Routes and Firewall Rules

### Firewall in Project B (SQL):

1. Go to **VPC network > Firewall**.
2. Click **Create Firewall Rule**.
3. Name: `allow-sql-from-peer`
4. **Network**: Same as SQL VPC
5. **Targets**: All instances or specific tags
6. **Source IP ranges**: The **subnet CIDR of Project A’s VPC** (e.g., `10.10.0.0/16`)
7. **Protocols/Ports**: Check `Specified protocols and ports`

    * TCP: `3306`
8. Click **Create**.

---

## Step 5: Connect from VM (Project A)

From your VM’s terminal:

```bash
mysql -h [SQL_PRIVATE_IP] -u [USER] -p
```

You should be able to connect securely via private IP!

---

## Verify Connectivity

* Ping the SQL instance's **private IP** from your VM
* If ping works and MySQL connection fails, check:

    * MySQL user permissions
    * Firewall
    * Peering routes (should be auto-created)

