# Playing-with-Quarkus

Bootstraping Quarkus applications and discovering its extensions

## quarkus-getting-started

Additional extensions:
- JSON-B serialization support for RESTEasy
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-resteasy-jsonb"**
- Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-validator"**
- Call REST Services
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client"**

Start Playing with Quarkus by running:
```
./mvnw compile quarkus:dev
```

Run tests using:
```
./mvnw test
```

Before building the container image run:
```
./mvnw package -Pnative
```

Then, build the image with:
```
docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-getting-started .
```

Then run the container using:
```
docker run -i --rm -p 8080:8080 quarkus/quarkus-getting-started
```

## quarkus-data

Additional extensions:
- JSON-B serialization support for RESTEasy
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-resteasy-jsonb"**
- Define your persistent model with Hibernate ORM and JPA
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm"**
- Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm-panache"**
- Connect to the MariaDB database via JDBC
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-mariadb"**


Use a docker image for the MariaDB instance:

```
docker run -ti --rm -e MYSQL_ROOT_PASSWORD=developer -e MYSQL_USER=developer -e MYSQL_PASSWORD=developer -e MYSQL_DATABASE=developer -p 3306:3306 mariadb:10.4.4
```