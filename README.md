https://medium.com/@ramanujds9/fixing-a-bug-on-production-with-cherry-picking-0e874ab920ff

## How to Run MongoDB on Docker

https://medium.com/@ramanujds9/stop-installing-mongodb-locally-use-docker-instead-ab35f2375b18

## MongoDB Practice

https://medium.com/@ramanujds9/mongodb-for-beginners-learn-by-doing-2f7f6968eb01


## Docker command to run MySql

### Pull Mysql Image

```bash

docker pull mysql

```

### Run Mysql

```bash


docker run -p 3306:3306 -d --name=mysql -e MYSQL_ROOT_PASSWORD=password mysql

```

### Access Mysql Client

```bash

docker exec -it mysql bash

```

### Enter MySQL Command

```bash

mysql -u root -p

```
