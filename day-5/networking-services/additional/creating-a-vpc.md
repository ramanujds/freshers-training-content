

## Step-by-Step: Create a VPC in GCP Console

### 1. **Open GCP Console**

Go to:
[https://console.cloud.google.com/](https://console.cloud.google.com/)

---

### 2. **Navigate to VPC Network**

From the left-hand menu (navigation pane):

* Click **“VPC network”**
* Then click **“VPC networks”**

---

### 3. **Click “Create VPC Network”**

You’ll be taken to a configuration page.

---

### 4. **Basic Configuration**

* **Name**: Give your VPC a unique name (e.g., `my-custom-vpc`)
* **Subnet creation mode**: Choose `Custom` (so you can define your own subnets)

---

### 5. **Add Subnets**

Click **“Add subnet”** and enter:

* **Name**: e.g., `frontend-subnet`
* **Region**: Choose a region (e.g., `us-central1`)
* **IP address range**: e.g., `10.0.1.0/24`

Repeat this to add more subnets if needed (e.g., `backend-subnet`, `db-subnet`).

---

### 6. **Firewall Rules (Optional but Recommended)**

You can allow some basic traffic like:

* `Allow HTTP traffic`: Allow TCP:80
* `Allow HTTPS traffic`: Allow TCP:443
* `Allow SSH`: Allow TCP:22

These rules can also be configured later under **VPC → Firewall Rules**.

---

### 7. **DNS and Routing**

Leave defaults unless you have specific requirements.

---

### 8. **Click “Create”**

GCP will create the VPC and the subnets.

---

## After Creating the VPC

* You can now **launch VMs** inside this VPC using any of the subnets.
* Set **firewall rules** to control access.
* Use **Cloud NAT** for private outbound internet access if needed.

