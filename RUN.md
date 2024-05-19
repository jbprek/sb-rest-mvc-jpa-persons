# RUN The application

## 1. Run Oracle docker instance
Under docker directory, run the following command:
```shell
docker-compose up -d
```

## 2. Initialize schema PERSONS
Run in terminal the following commands:

### Create schema
```shell
mvn flyway:migrate
```
### Create test schema
```shell
mvn flyway:migrate -PTestSchema
```
##  3. Build Project
Run in terminal the following commands:
```shell
mvn clean  package
```



