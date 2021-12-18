# How to connect to a Dockerized MongodDB container via Spring Boot Application?

**Run the MongoDB Container**
> docker run -p 27017:27017 --name mongo -e MONGO_INITDB_ROOT_PASSWORD=root -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_DATABASE=testdatabase -d mongo:latest

**To Open MongoDB Shell**
> docker exec -it mongo mongo --authenticationDatabase admin -u root -p