# RUN The application

## 1. Run Oracle docker instance
Under docker directory, run the following command:
```shell
docker-compose up -d
```

## 2. Initialize schema PERSONS
Run in terminal the following commands:
```shell
mvn flyway:migrate

mvn flyway:migrate -PTestSchema
```



