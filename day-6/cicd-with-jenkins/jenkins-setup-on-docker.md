
### `docker-compose.yml`

```yaml
version: '3.8'

services:
  jenkins:
    image: jenkins/jenkins:lts
    container_name: jenkins-docker
    ports:
      - "9090:8080"
      - "50000:50000"
    security_opt:
      - seccomp:unconfined
    volumes:
      - jenkins_data:/var/jenkins_home

volumes:
  jenkins_data:
```

---

### How to Use

1. **Create a directory** for Jenkins:

   ```bash
   mkdir jenkins-docker && cd jenkins-docker
   ```

2. **Save the above YAML** in a file named `docker-compose.yml`.

3. **Run Jenkins**:

   ```bash
   docker-compose up -d
   ```

4. **Get the initial admin password**:

   ```bash
   docker exec jenkins-docker cat /var/jenkins_home/secrets/initialAdminPassword
   ```

5. Open your browser at:

   ```
   http://localhost:9000
   ```

---

### Optional: Enable Docker inside Jenkins jobs

To allow Jenkins to run Docker commands (e.g., for building images):

```yaml
    volumes:
      - jenkins_data:/var/jenkins_home
      - /var/run/docker.sock:/var/run/docker.sock
```


## Install Docker inside the Jenkins container

```bash

docker exec -it -u 0 jenkins-docker bash
```

Then inside the container, run:


```bash
apt-get update && apt-get install -y docker.io
usermod -aG docker jenkins
exit
```

### Restart the container

```bash
docker restart jenkins-docker
```



