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

## quarkus-reactive

Additional extensions:
- Produce and consume messages and implement event driven and data streaming applications
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-reactive-messaging"**
- Connect to Kafka with Reactive Messaging
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-reactive-messaging-kafka"**
- Connect to AMQP with Reactive Messaging
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-reactive-messaging-amqp"**
- JSON-B serialization support for RESTEasy
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-resteasy-jsonb"** 
- Call REST Services
  - **./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client"**

Starting Kafka creating a *docker-compose-kafka.yaml* and running *docker-compose -f docker-compose-kafka.yaml up*:
```
version: '2'

services:

  zookeeper:
    image: strimzi/kafka:0.19.0-kafka-2.5.0
    command: [
        "sh", "-c",
        "bin/zookeeper-server-start.sh config/zookeeper.properties"
    ]
    ports:
      - "2181:2181"
    environment:
      LOG_DIR: /tmp/logs

  kafka:
    image: strimzi/kafka:0.19.0-kafka-2.5.0
    command: [
        "sh", "-c",
        "bin/kafka-server-start.sh config/server.properties --override listeners=$${KAFKA_LISTENERS} --override advertised.listeners=$${KAFKA_ADVERTISED_LISTENERS} --override zookeeper.connect=$${KAFKA_ZOOKEEPER_CONNECT}"
    ]
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      LOG_DIR: "/tmp/logs"
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181

```

Starting an AMQP broker Kafka creating a *docker-compose-amqp.yaml* and running *docker-compose -f docker-compose-amqp.yaml up*:
```
version: '2'

services:

  artemis:
    image: vromero/activemq-artemis:2.8.0-alpine
    ports:
      - "8161:8161"
      - "61616:61616"
      - "5672:5672"
    environment:
      ARTEMIS_USERNAME: quarkus
      ARTEMIS_PASSWORD: quarkus
```