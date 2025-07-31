https://medium.com/@ramanujds9/fixing-a-bug-on-production-with-cherry-picking-0e874ab920ff


## Docker command to run MySql

### Pull Mysql Image

```bash

docker pull mysql

```

### Run Mysql

```bash


docker run -p 3306:3306 -d --name=mysql -e MYSQL_ROOT_PASSWORD=password mysql

```