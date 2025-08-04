## **1. Cloud Storage (Object Storage)**

### a. **Choose the Right Storage Class**

* Use:

    * **Standard** for frequently accessed data (e.g., active app content)
    * **Nearline** for monthly access (e.g., monthly backups)
    * **Coldline** for quarterly access
    * **Archive** for long-term archival
* Automate transitions using **lifecycle policies**

### b. **Enable Versioning** (for backups or rollback)

```bash
gsutil versioning set on gs://my-bucket/
```

### c. **Use Signed URLs or IAM for Access Control**

* Signed URLs for temporary access (e.g., sharing files)
* IAM roles to manage who can read/write buckets

### d. **Enable Bucket Locking for Compliance**

* Use retention policies for data governance (e.g., WORM storage)

---

## **2. Persistent Disks (Block Storage for VMs)**

### a. **Right-Size Your Disks**

* Use **SSD** for high IOPS needs (e.g., DBs)
* Use **HDD** or **Balanced PD** for general workloads

### b. **Take Regular Snapshots**

* Automate snapshot schedules for backups
* Use snapshot schedules in VM disk settings

### c. **Avoid Disk Resize Mistakes**

* You can **increase** disk size, but **cannot decrease** it—plan ahead

### d. **Use Separate Disks for OS and Data**

* Makes it easier to backup/restore and manage performance

---

## **3. Filestore (NFS Shared Storage)**

### a. **Match Tier to Workload**

* Use **basic** for dev/test workloads
* Use **enterprise/performance tiers** for production or high IOPS

### b. **Mount Correctly Across VMs**

* Ensure VMs use the correct mount point and have access permissions

### c. **Monitor Throughput and Capacity**

* Watch for slow reads/writes; scale up or switch tiers if needed

---

## **4. Local SSDs**

### a. **Do Not Use for Critical Data**

* Data is lost on VM stop or crash
* Only use for temporary processing or caching

### b. **Use with High-I/O Apps**

* Suitable for high-speed workloads like video transcoding, caching, ML preprocessing

---

## **5. Cloud Storage Lifecycle Management**

Use lifecycle policies to automatically:

* Transition objects to cheaper storage
* Delete old versions or objects after a retention period

Example (set to archive after 365 days):

```json
{
  "rule": [
    {
      "action": {"type": "SetStorageClass", "storageClass": "ARCHIVE"},
      "condition": {"age": 365}
    }
  ]
}
```

---

## **6. Security Best Practices (All Storage Types)**

* Use **IAM Roles** with least privilege
* Use **Customer-Managed Encryption Keys (CMEK)** for extra control
* Enable **Audit Logs** to track access
* Use **VPC Service Controls** to prevent data exfiltration

---

## **7. Cost Optimization Tips**

* Use **storage class lifecycle transitions**
* Clean up unused disks or buckets
* Compress files before uploading
* Use **Coldline/Archive** for rarely accessed data
* Avoid leaving orphaned snapshots or volumes

---

## **8. Monitoring and Alerts**

* Use **Cloud Monitoring** and **Cloud Logging** to:

    * Monitor disk usage and IOPS
    * Track access to storage buckets
    * Set alerts on unusual activity or cost spikes

---

## Summary Table of Best Practices

| Area             | Best Practices                                             |
| ---------------- | ---------------------------------------------------------- |
| Cloud Storage    | Use correct class, versioning, IAM, lifecycle rules        |
| Persistent Disks | Snapshots, separation of OS/data, choose right type        |
| Filestore        | Match tier to usage, mount properly, monitor usage         |
| Local SSD        | Use for temp data only, ensure backups if needed           |
| Security         | Use IAM, CMEK, Audit Logs, VPC Service Controls            |
| Cost             | Lifecycle rules, delete unused resources, compress uploads |
| Monitoring       | Set alerts, use logs, monitor performance                  |

