# Craftsmanship Mod

3PillarGlobal Java Community repository for the Minecraft Craftsmanship Mod.

# Build

To build current version of mod run cmd in the project root:
```
gradle build
```

Compiled mod jar file will be saved to <root>/build/libs/craftsmanship-X.Y-SNAPSHOT.jar You will need to copy this file to local minecraft location. You can find the description in section below.
# Install process

## Client

To use our custom mode version of Minecraft, you have to use fabric client.
* Select your platform installer: https://fabricmc.net/use/installer/
* Run downloaded installer and select actual used versions in project (you can find them in gradle.properties)
* Download Fabric API - https://www.curseforge.com/minecraft/mc-mods/fabric-api/ and put it to:
  * OSX: /Users/{user.name}/Library/Application Support/minecraft/mods
  * Windows: %appData%/Roaming/.minecraft/mods
  * This is the folder where you need to put also our jar mode!!!

At this point you should have client ready. Let's go to Server part.

## Server

There is multiple ways, how to run minecraft server locally:

### 1. Manually

Use CoP session from 04th February 2022 as reference.

Useful links:
* https://www.minecraft.net/en-us/download/server
* https://fabricmc.net/use/server/
* https://minecraft.fandom.com/wiki/Server.properties
* https://fabricmc.net/wiki/tutorial:migratemappings
* https://fabricmc.net/versions.html
* https://www.curseforge.com/minecraft/mc-mods/fabric-api/files

### 2. Docker image

You can run base server with included our mode easily by running docker container with prepared image. Gradle build step is required before this step.

#### Build

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

### 3. Docker compose
You can use docker compose to run server locally as well. You need to have built image along previous section and instead of running 'docker run...' you can use in the project root 
```
docker-compose up
```