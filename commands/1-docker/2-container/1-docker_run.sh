docker run hello-world

docker run --name docker-app -e MONGODB_HOST=mongo -e MONGODB_PORT=27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=Mongo123 -e MONGO_INITDB_DATABASE=app-docker -e MONGO_INITDB_USERNAME=app-docker -e MONGO_INITDB_PASSWORD=Mongo123 -e MONGO_REPLICA_SET_NAME=rs0 -p "8080:8080" --network docker-app_local-network docker-app:1.0.0