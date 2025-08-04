
## Step-by-Step: Connecting from GCE VM to Cloud SQL (Private IP)

### Step 1: Ensure Private IP is Enabled for Cloud SQL

1. Go to **SQL → Your Instance → Connections**
2. In **Network interfaces**, check if a **Private IP** is listed
3. If not:

    * Click **"Add Network Interface"**
    * Choose your **VPC network and region**
    * Click **Save**

This makes your Cloud SQL instance accessible via internal IP within your VPC.

---

### Step 2: Ensure GCE VM is in Same VPC & Region

Check your VM's:

* **VPC network**
* **Region and zone** (Cloud SQL works best within the same region)

If not the same, consider creating a new VM in the correct VPC/region.

---

### Step 3: Install MySQL Client (on GCE VM)

SSH into the VM:

```bash
sudo apt update
sudo apt install mysql-client -y
```

---

### Step 4: Get Cloud SQL Private IP

* Go to your Cloud SQL instance
* Under **"Instance details" → "Private IP"**, copy the IP address

---

### Step 5: Connect to Cloud SQL from GCE VM

```bash
mysql -h <PRIVATE_IP> -u root -p
```

* Replace `<PRIVATE_IP>` with the one from previous step
* Enter the password when prompted

You should now be inside MySQL CLI connected to Cloud SQL via private IP.

---

## GCP Firewall Rule for MySQL (Optional if not already open)

If your VPC doesn’t allow internal traffic to port `3306`:

1. Go to **VPC network → Firewall rules**
2. Create a new rule:

    * Name: `allow-mysql-internal`
    * Targets: **All instances in the network**
    * Source: `10.0.0.0/8` or your subnet CIDR
    * Protocols: `tcp:3306`

