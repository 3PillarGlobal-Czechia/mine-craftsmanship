FROM itzg/minecraft-server:latest

RUN mkdir -p /data/mods

COPY build/libs/craftsmanship-*-SNAPSHOT.jar /data/mods/craftsmanship.jar