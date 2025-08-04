## **1. Using Azure Portal** (GUI – similar to AWS Console / GCP Console)

1. **Login** to [Azure Portal](https://portal.azure.com).
2. In the search bar, type **"Virtual Machines"** and click **Create → Azure virtual machine**.
3. **Basics Tab**:

    * **Subscription**: Choose your subscription.
    * **Resource Group**: Create a new one or use existing (like AWS “VPC project” or GCP “Project” concept).
    * **VM Name**: `my-ubuntu-vm`
    * **Region**: Select nearest location (e.g., *East US*, *Central India*).
    * **Availability options**: Choose **No infrastructure redundancy** (or choose **Availability Zone** for HA).
    * **Image**: Select **Ubuntu Server 22.04 LTS**.
    * **Size**: Pick a size (like AWS instance type or GCP machine type).
    * **Authentication type**:

        * **SSH public key** (recommended) — paste your public key.
        * Or password (less secure).
4. **Disks Tab**:

    * OS Disk type: Standard SSD or Premium SSD (similar to AWS EBS / GCP Persistent Disk).
5. **Networking Tab**:

    * Virtual Network (VNet) & Subnet: Auto-created if new.
    * Public IP: Enable if you need external access.
    * NIC network security group: Select **Basic** and allow SSH (port 22).
6. **Management / Monitoring Tabs**:

    * Keep defaults or enable monitoring.
7. **Review + Create**:

    * Review configuration and click **Create**.
8. **Access VM**:

    * From terminal:

      ```bash
      ssh azureuser@<public-ip>
      ```

      (Replace with your username & public IP from Azure portal.)

---

## **2. Using Azure CLI** (Automation – like AWS CLI or gcloud)

You’ll need **Azure CLI** installed and logged in:

```bash
az login
```

### **Create Resource Group**

```bash
az group create --name myResourceGroup --location eastus
```

### **Create Ubuntu VM**

```bash
az vm create \
  --resource-group myResourceGroup \
  --name myUbuntuVM \
  --image Ubuntu2204 \
  --admin-username azureuser \
  --generate-ssh-keys
```

This will:

* Create a VNet, subnet, and public IP
* Deploy Ubuntu 22.04 LTS VM
* Generate SSH keys (stored in `~/.ssh/`)

### **Connect to VM**

```bash
ssh azureuser@<public-ip>
```

---

## **3. Key Azure vs AWS/GCP Differences**

* Azure automatically creates a **VNet** & **Subnet** for the VM (like AWS default VPC / GCP default network).
* Azure **Availability Zones** must be explicitly selected during creation if you want redundancy.
* Azure **Managed Disks** are by default attached — no manual EBS/Persistent Disk creation needed.
* In CLI, `--image Ubuntu2204` is shorthand for the full URN of the Ubuntu image.

