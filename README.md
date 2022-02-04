# Craftsmanship Mod

3PillarGlobal Java Community repository for the Minecraft Craftsmanship Mod.

# Docker

## Docker image

You can run base server with included our mode easily by running docker container with prepared image.

### Build

You need to build docker image first.

* assemble project with gradle
* you need to build and store image to local docker repository
```
 docker image build -t 3pillarglobal.com/mine-craftsmanship-server .
```
* you can start new container with name 'mc' and with prepared mode.
```
docker run -e EULA=TRUE -d -p 25565:25565 --name mc 3pillarglobal.com/mine-craftsmanship-server
```

## Docker compose
You can use docker compose to run server locally as well. You need to have built image along previous section and instead of running 'docker run...' you can use in the project root 
```
docker-compose up
```