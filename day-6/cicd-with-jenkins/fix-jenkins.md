1. **Uninstall Jenkins**
2. **Set Java 21 as default**
3. **Reinstall Jenkins (latest version)**

---

### Step 1: Uninstall Jenkins

```bash
sudo systemctl stop jenkins
sudo apt purge --autoremove jenkins -y
sudo rm -rf /var/lib/jenkins /etc/jenkins /var/log/jenkins
```

---

### Step 2: Set Java 21 as the Default

#### **1. Check Installed Java Versions**

```bash
update-alternatives --list java
```

#### **2. Set Java 21 as Default**

```bash
sudo update-alternatives --config java
```

Choose the path that corresponds to Java 21 (e.g., `/usr/lib/jvm/java-21-openjdk-amd64/bin/java`).

#### **3. Set JAVA\_HOME**

Edit your profile:

```bash
sudo nano /etc/environment
```

Add or update:

```bash
JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
```

Apply the change:

```bash
source /etc/environment
echo $JAVA_HOME
```

---

### Step 3: Reinstall Jenkins (Latest Version)

#### **1. Add Jenkins Repo**

```bash
wget -q -O - https://pkg.jenkins.io/debian/jenkins.io-2023.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null

echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt update
```

#### **2. Install Jenkins**

```bash
sudo apt install jenkins -y
```

#### **3. Start and Enable Jenkins**

```bash
sudo systemctl start jenkins
sudo systemctl enable jenkins
```

---

### Step 4: Confirm Everything Works

* Check status:

```bash
sudo systemctl status jenkins
```
* Get initial admin password:

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```
* Open Jenkins: [http://localhost:8080](http://localhost:8080)