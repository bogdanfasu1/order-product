# Order Products Management

The `ProductApplication` its an Product Order SpringBoot application.
We have an API for create a new product, one for getAll, one for getById, deleteById and updateById.
For local env we are using in memory db, and for production we are using a Postgres DB, so for that we need to run the postgres image, there is a `docker-compose.yml` file for that.


## Build

```bash
mvn package
```

## Run

```bash
java -jar -Dspring.profiles.active=prod,db-prod target/product-0.0.1-SNAPSHOT.jar
```

## Run Tests

```bash
mvn test
```

