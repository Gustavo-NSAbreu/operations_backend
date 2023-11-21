# Operations Backend

## Description
This is the repository of a simple application that does the CRUD operations

## Run on Docker
Running this application on Docker can be done in to ways

### Using Docker Compose
Copy the content of docker-compose.yaml.example and paste in a file with the same name (without .example) on a folder that contains this project. It should be:

root_folder<br>
|<br>
| — operations_backend<br>
|<br>
| — operations_frontend<br>
|<br>
| — docker-compose.yaml

Just run the application with the command 

`docker-compose up`

Open a browser and type

`http://localhost:3000`

### Runnig containers manually

#### Runnig Databases
First thing is to run the databases the backend depend on.
Pull the MariaDB and MongoDB images and create the volumes for each of them.
Then run their containers with this configuration

```bash
# 1. MariaDB
docker run -d --name mariadb -v mariadb-databases --network phpmyadmin-network -e "MYSQL_ROOT_PASSWORD=suasenha" mariadb

# 2. MongoDB


```

First build the .jar file with the command

`mvn clean package`

Then, on the root directory, build the aplication image with the command

`docker build <name_of_the_image> .`

After the image is built run the container with the command

`docker run -p 8888 <name_of_the_image>`
