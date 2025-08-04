## What Is Memorystore?

**Memorystore** is a **fully managed in-memory data store** service from Google Cloud. It supports:

* **Redis**: A fast, in-memory key-value store used for caching, sessions, queues, etc.
* **Memcached**: A simple, in-memory caching system.

It’s mostly used to **speed up applications** by storing frequently accessed data in RAM instead of querying a database every time.

---

## Use Cases of Memorystore

| Use Case                  | Description                                       |
| ------------------------- | ------------------------------------------------- |
| Caching database queries  | Store query results temporarily to reduce DB load |
| Session storage           | Save login/session data for web users             |
| Leaderboards or counters  | Track real-time counts (like votes, views)        |
| Queues or pub-sub systems | Use Redis lists or streams                        |

---

## Step-by-Step: Set Up Memorystore (Redis) via GCP Console

### Step 1: Open GCP Console

* Go to: [https://console.cloud.google.com](https://console.cloud.google.com)
* Select or create a GCP project.

### Step 2: Navigate to Memorystore

* From the left side menu, go to:
  **Navigation Menu > Memorystore > Redis**
* Click on **“Create Instance”**

### Step 3: Configure the Instance

1. **Instance ID**: Give it a name (e.g., `my-redis-cache`)
2. **Region**: Choose the region where your app/VMs are deployed.
3. **Zone**: You can choose "automatic" or pick a zone.
4. **Tier**: Choose:

    * **Basic**: Single node, cheaper (for caching, dev/testing)
    * **Standard**: Highly available with replication and failover
5. **Capacity**: Select memory size (e.g., 1 GB, 2 GB)
6. Click **Create**

It takes 2–3 minutes to set up.

---

## Step 4: Connect to Memorystore (from a VM)

You cannot directly access Memorystore from your local machine. It must be accessed from **within the same VPC network**, typically from a **Compute Engine VM**.

### Connection Rules:

* Your **GCE VM must be in the same region and VPC** as the Memorystore instance.
* Redis is accessed via its **private IP**.

### To connect:

1. Go to your Memorystore Redis instance in the console.
2. Copy the **IP address** under "Instance details".
3. SSH into your VM using:

   ```bash
   gcloud compute ssh [your-vm-name]
   ```
4. Install the Redis CLI client (if not already installed):

   ```bash
   sudo apt-get update
   sudo apt-get install redis-tools
   ```
5. Connect to Redis:

   ```bash
   redis-cli -h [MEMORYSTORE_IP]
   ```

You should now be inside the Redis command prompt.

---

## Step 5: Run Basic Redis Commands (No Programming)

Once you're inside Redis (from the VM terminal):

```bash
SET name "Alice"
GET name
DEL name
INCR counter
```

Example:

```bash
127.0.0.1:6379> SET name "Ram"
OK
127.0.0.1:6379> GET name
"Ram"
```

---

## Best Practices

| Practice                             | Tip                                        |
| ------------------------------------ | ------------------------------------------ |
| Keep VMs and Redis in same VPC       | For secure and fast access                 |
| Use **Standard Tier** for production | Provides high availability                 |
| Set TTL for cache keys               | To avoid memory overuse                    |
| Avoid storing large binary data      | Redis is optimized for small, fast lookups |

---

