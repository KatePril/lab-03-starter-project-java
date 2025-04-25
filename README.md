Clone the project
```
git clone https://github.com/KatePril/lab-03-starter-project-java.git
```
Navigate to the project directory:
```sh
cd lab-03-starter-project-java
```

Fill in database name, username and password fields in [.env](https://github.com/KatePril/lab-03-starter-project-java/blob/main/.env) 
```
POSTGRES_USER=<your-user-name>
POSTGRES_PASSWORD=<your-password>
POSTGRES_DB=<your-db-name>
```
and [application.properties](https://github.com/KatePril/lab-03-starter-project-java/blob/main/src/main/resources/application.properties)
```
spring.datasource.username=username
spring.datasource.password=password
```

Run the project:
```sh
docker-compose up --build
```
