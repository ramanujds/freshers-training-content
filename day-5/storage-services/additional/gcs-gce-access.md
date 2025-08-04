
## **Prerequisites**

1. You have a GCS bucket with the file uploaded (e.g., `gs://my-bucket/myfile.txt`)
2. Your VM has **internet access** or **private access to GCS**
3. You have installed or will install the `gcloud` and `gsutil` tools on the VM
4. The VM's **service account** has the required permissions (like `Storage Object Viewer`)

---

## **Step-by-Step Guide**

### **Option 1: Use `gsutil` to download the file**

### Step 1: Connect to your VM

```bash
gcloud compute ssh my-vm --zone=us-central1-a
```

### Step 2: Ensure `gsutil` is available

It comes preinstalled in most default Debian/Ubuntu images on GCE. Check with:

```bash
gsutil --version
```

If it's not installed:

```bash
sudo apt-get update
sudo apt-get install google-cloud-sdk
```

### Step 3: Download the file from GCS

```bash
gsutil cp gs://my-bucket/myfile.txt .
```

You can also copy directories:

```bash
gsutil cp -r gs://my-bucket/my-folder/ .
```

---

### **Option 2: Mount GCS bucket as a file system (Optional Advanced Use)**

You can mount a GCS bucket using `gcsfuse`:

```bash
sudo apt-get install gcsfuse
mkdir ~/my-bucket
gcsfuse my-bucket ~/my-bucket
ls ~/my-bucket
```

> This allows you to access GCS like a local file system.

---

## **Make Sure the VM Has Access**

### Option A: Use Default Service Account with Permissions

Ensure the VM's service account has the role:

* `roles/storage.objectViewer` for **read-only**
* `roles/storage.objectAdmin` for **read/write**

To check and grant it:

```bash
gcloud projects add-iam-policy-binding [PROJECT_ID] \
  --member="serviceAccount:[VM_SERVICE_ACCOUNT]" \
  --role="roles/storage.objectViewer"
```

### Option B: Use Signed URLs (for limited access without authentication)

If you don’t want to configure IAM, generate a signed URL:

```bash
gsutil signurl -d 10m [PRIVATE_KEY_FILE.json] gs://my-bucket/myfile.txt
```

Then use `curl` or `wget` on the VM to download it:

```bash
curl "https://storage.googleapis.com/..."
```

---

## Example

Let's say:

* File: `my-bucket/app/config.json`
* VM name: `app-vm`

### Connect and copy:

```bash
gcloud compute ssh app-vm --zone=us-central1-a
gsutil cp gs://my-bucket/app/config.json /home/myuser/config.json
```

---

## Best Practices

* **Use lifecycle rules** in the bucket to clean up temporary files
* **Restrict bucket access** using IAM and Bucket-level permissions
* If multiple VMs need to access the same file regularly, consider **gcsfuse**
* Automate `gsutil cp` in a **startup script** if needed on instance boot

