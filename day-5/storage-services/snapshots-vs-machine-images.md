## **1. Snapshot**

### **What is a Snapshot?**

A **snapshot** is a **backup of the disk** (Persistent Disk or Boot Disk) of a virtual machine (VM). It captures the current state of the disk at a point in time.

* It is **incremental** (after the first full snapshot, only changes are saved)
* You can restore it to create a new disk
* Can be scheduled automatically

### **Use Cases**

* Back up VM before updates or deployments
* Disaster recovery for disk failures
* Clone disks to test environments

### **Key Features**

* Supports standard and SSD persistent disks
* Can be stored in **multi-regional**, **regional**, or **custom locations**
* Can be used across projects if permissions allow

### **How to Create a Snapshot**

**Using gcloud:**

```bash
gcloud compute disks snapshot my-disk --snapshot-names=my-disk-backup
```

**Using Console:**

1. Go to Compute Engine → Disks
2. Select a disk → Click “Create Snapshot”
3. Name it and choose storage location

### **Restoring from a Snapshot**

```bash
gcloud compute disks create new-disk --source-snapshot=my-disk-backup --zone=us-central1-a
```

---

## **2. Machine Image**

### **What is a Machine Image?**

A **machine image** captures **everything needed to recreate a VM**, including:

* Boot disk and any attached data disks
* Instance properties (like machine type, labels, metadata)
* Network configuration
* Service accounts
* Permissions

It's more comprehensive than a snapshot.

### **Use Cases**

* Create reusable templates for VMs
* Backup entire VM configurations
* Migrate or replicate VMs across projects or environments

### **Key Features**

* Useful for **automating deployments** or **standardizing environments**
* Includes full VM config + data
* Can be shared across projects

### **How to Create a Machine Image**

**Using gcloud:**

```bash
gcloud compute machine-images create my-machine-image --source-instance=my-vm --source-instance-zone=us-central1-a
```

**Using Console:**

1. Go to Compute Engine → VM Instances
2. Select the instance → Click “Create Machine Image”

### **Creating a VM from a Machine Image**

```bash
gcloud compute instances create new-vm --source-machine-image=my-machine-image
```

---

## **Snapshot vs. Machine Image – Key Differences**

| Feature           | Snapshot    | Machine Image                             |
| ----------------- | ----------- | ----------------------------------------- |
| Captures          | Only disks  | Disks + VM configuration                  |
| Use Case          | Disk backup | Full VM template or backup                |
| Includes metadata | No          | Yes (e.g., machine type, labels, network) |
| Incremental       | Yes         | No (full image each time)                 |
| Restores          | Disks only  | Entire VM (with option to customize)      |
| Suitable for      | Backups     | Cloning or templating VMs                 |

---

## When to Use What?

* **Use Snapshots** if:

    * You want a quick disk backup
    * You only need the data (not VM config)
    * You’re doing frequent, space-efficient backups

* **Use Machine Images** if:

    * You want to clone entire VMs
    * You're standardizing VM setups (like base templates)
    * You want to replicate a complete environment

