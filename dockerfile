FROM itzg/minecraft-server:latest

RUN mkdir -p /data/mods

COPY build/libs/craftsmanship-*-SNAPSHOT.jar /data/mods/craftsmanship.jar

RUN cd /data/mods && { curl -o fabric-api.jar https://www.curseforge.com/minecraft/mc-mods/fabric-api/download/3634318/file ; cd /; }