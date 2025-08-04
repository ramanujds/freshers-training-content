## What is CIDR?

**CIDR** is a way of **representing IP address ranges**.

Instead of writing all IP addresses one by one, CIDR lets you **group them using a notation** like:

```
192.168.1.0/24
```

This means:

* **`192.168.1.0`** is the **network address**
* **`/24`** means the **number of bits reserved for the network**

---

## How CIDR Works

An IPv4 address is 32 bits long (e.g., `192.168.1.1`).

The `/` number (CIDR suffix) tells how many of those bits are **fixed for the network**, and the rest are for **host addresses** (devices, VMs, etc.).

### Example: `192.168.1.0/24`

* First 24 bits: **Network**
* Last 8 bits: **Host addresses**
* This gives: `2⁸ = 256` IP addresses
* Usable IPs: `254` (first is network, last is broadcast)

| CIDR  | Hosts  | IP Range Example            |
| ----- | ------ | --------------------------- |
| `/32` | 1      | 192.168.1.1 (single IP)     |
| `/30` | 4      | 192.168.1.0–3               |
| `/24` | 256    | 192.168.1.0–255             |
| `/16` | 65,536 | 192.168.0.0–192.168.255.255 |

---

## CIDR in GCP (and other clouds)

When creating a VPC or subnet in GCP, you’ll specify a **CIDR block**. This defines the **range of IPs** available for resources like VMs in that subnet.

### Example:

You create a subnet:

```
Name: frontend-subnet
Region: us-central1
IP Range: 10.0.1.0/24
```

→ This subnet can assign up to 254 usable IP addresses to VMs in that region.

---

## Best Practices

* Use **larger CIDR blocks** if you expect to scale.
* Avoid **overlapping CIDR blocks** in different subnets or networks.
* Use **private IP ranges** as per \[RFC 1918]:

    * `10.0.0.0/8`
    * `172.16.0.0/12`
    * `192.168.0.0/16`

---

## Use Case Example in GCP

| Subnet Name     | CIDR Block    | Region      |
| --------------- | ------------- | ----------- |
| frontend-subnet | `10.0.1.0/24` | us-central1 |
| backend-subnet  | `10.0.2.0/24` | us-central1 |
| db-subnet       | `10.0.3.0/24` | asia-south1 |

Each subnet has a separate, non-overlapping IP range. VMs launched in these subnets get IPs from the respective CIDR block.

