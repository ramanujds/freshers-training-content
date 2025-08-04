
# GCE VM Setup for Jenkins + Docker + Kubernetes (Minikube/GKE)

## 1. Setup a VM on GCE

Create a new Virtual Machine instance on Google Compute Engine (GCE) with Ubuntu OS.

---

## 2. Install Required Packages

### Update Packages

```bash
sudo apt update -y
```

### Install Git, Java, Maven

```bash
sudo apt install git -y
sudo apt install default-jdk -y
sudo apt install maven -y
```

---

## 3. Install Jenkins

### Add Jenkins Repository and Key

```bash
sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/" | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
```

### Install Jenkins

```bash
sudo apt-get update
sudo apt-get install jenkins -y
```

### Start Jenkins

```bash
sudo systemctl start jenkins
```

### Enable Jenkins to Start on Boot

```bash
sudo systemctl enable jenkins
```

### Retrieve Admin Password

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

> Example output: `a06a10b4c80a4ca08c70baf638407096`

---

## 4. Access Jenkins

* Add a firewall rule to allow traffic on **port 8080**.
* Open your browser and visit:
  `http://<your-vm-external-ip>:8080`
* Complete the setup by installing the suggested plugins.

---

## 5. Install Docker

Refer to official Docker documentation:
[Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/)

### Post-install: Add Permissions

```bash
sudo usermod -aG docker $USER && newgrp docker
```

### Allow Jenkins to Access Docker

```bash
sudo usermod -a -G docker jenkins
```

---

## 6. Install `kubectl`

### Install via Snap

```bash
sudo snap install kubectl --classic
```

---

## 7. Install GCP Auth Plugin for GKE

```bash
sudo apt-get install apt-transport-https ca-certificates gnupg curl

curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo gpg --dearmor -o /usr/share/keyrings/cloud.google.gpg

echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list

sudo apt-get update

sudo apt-get install google-cloud-sdk-gke-gcloud-auth-plugin -y
```



## 8. Jenkins Access to GKE

### Step 1: Create GCP Service Account

In GCP Console:

* Navigate to **IAM & Admin → Service Accounts**
* Click **"Create Service Account"**

### Step 2: Assign Roles

* **Kubernetes Engine Admin**
* **Service Account User**
* **Viewer**

### Optionally Using the Gcloud CLI:

```bash

gcloud projects add-iam-policy-binding <project-name> \
    --member="serviceAccount:<service-account-email>" \
    --role="roles/container.admin"

gcloud projects add-iam-policy-binding <project-name> \
    --member="serviceAccount:<service-account-email>" \
    --role="roles/iam.serviceAccountUser"

gcloud projects add-iam-policy-binding <project-name> \
    --member="serviceAccount:<service-account-email>" \
    --role="roles/viewer"


```

### Step 3: Create and Download JSON Key

* Go to the **Keys** tab.
* Click **"Add Key" → "Create new key" → Select JSON**
* Download and save the `.json` key file.

### Step 4: Add the Key to Jenkins

* Go to **Jenkins Dashboard → Manage Jenkins → Credentials**
* Add the `.json` file as a **Secret File Credential**
* Use this in your pipeline to authenticate with GCP.

