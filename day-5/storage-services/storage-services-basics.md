## **Storage Services in Google Cloud Platform (GCP)**

GCP offers various types of storage services, each suited for different use cases like storing files, running databases, or sharing files between virtual machines.

Let’s explore each type one by one:

---

### 1. **Cloud Storage** (Object Storage)

**What it is**:
A highly durable, scalable, and cost-effective service for storing unstructured data like files, images, videos, logs, backups, and so on.

**Key Features**:

* Stores data as objects in *buckets*
* Supports multiple *storage classes* for different access patterns:

    * Standard: Frequently accessed data
    * Nearline: Accessed about once a month
    * Coldline: Accessed a few times a year
    * Archive: Rarely accessed, long-term storage
* Global access via URL or API
* Versioning and lifecycle rules

**Use Cases**:

* Hosting static website content
* Backup and archival of logs or media
* Data lake for analytics

**Example Commands**:

```bash
gsutil mb gs://my-bucket/
gsutil cp file.txt gs://my-bucket/
```

---

### 2. **Persistent Disks** (Block Storage)

**What it is**:
Block-level storage used by Compute Engine virtual machines. Acts like a physical hard drive.

**Types**:

* Standard persistent disk (HDD)
* SSD persistent disk
* Balanced persistent disk

**Key Features**:

* Can be attached to one or more VMs
* Data persists even after VM shutdown
* Snapshots supported for backups

**Use Cases**:

* Operating system disk for VMs
* Hosting databases like MySQL or PostgreSQL
* Storing application data

---

### 3. **Filestore** (File Storage)

**What it is**:
A fully managed Network File System (NFS) for shared file storage between multiple VMs.

**Key Features**:

* Mountable on multiple Compute Engine VMs
* Simple to configure and use
* Available in basic and high-performance tiers

**Use Cases**:

* Shared configuration or media files
* Applications that require file-level access across instances
* CMS or shared development environments

---

### 4. **Local SSDs**

**What it is**:
High-speed, physically attached SSDs for temporary storage needs on a VM.

**Key Features**:

* Very fast I/O performance
* Temporary (data lost when the VM is stopped or deleted)
* Lower latency than persistent disks

**Use Cases**:

* High-speed caching
* Temporary scratch space
* Data processing or video transcoding

---

### 5. **Cloud SQL / Spanner / Firestore / Bigtable** (Database Storage)

These services are optimized for structured data but involve backend storage.

**Cloud SQL**:

* Managed relational database (MySQL, PostgreSQL, SQL Server)
* Used for traditional web apps and business apps

**Cloud Spanner**:

* Globally distributed SQL database
* Strong consistency and high availability

**Firestore**:

* NoSQL document database
* Used in mobile and web apps

**Bigtable**:

* NoSQL wide-column store
* Used for analytics, telemetry, and IoT

---

### 6. **Coldline and Archive Classes**

These are *storage classes* within Cloud Storage optimized for low-cost, infrequent access.

**Coldline**:

* For data accessed quarterly
* Ideal for disaster recovery

**Archive**:

* For data accessed once a year or less
* Cheapest class, ideal for legal or compliance backups

**Use Cases**:

* Archiving long-term legal data
* Rarely accessed backups
* Data retention for compliance

---

## Summary Table

| Storage Type      | Use Case                       | Persistent | Scalable | Example                                 |
| ----------------- | ------------------------------ | ---------- | -------- | --------------------------------------- |
| Cloud Storage     | Files, media, backups          | Yes        | Yes      | Uploading logs, hosting static websites |
| Persistent Disks  | OS disk, DB storage            | Yes        | No       | Attaching disk to VM for database       |
| Filestore         | Shared file systems across VMs | Yes        | No       | Mounting shared NFS on multiple VMs     |
| Local SSDs        | Temporary fast local storage   | No         | No       | Fast scratch space, temp cache          |
| Cloud SQL/Spanner | Structured app data            | Yes        | Yes      | Storing transactional data              |
| Coldline/Archive  | Archival data                  | Yes        | Yes      | Infrequently accessed backups           |

---
