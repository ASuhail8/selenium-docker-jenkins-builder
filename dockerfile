FROM openjdk:8u191-jre-alpine3.9

RUN apk add curl jq

WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# in case of any other dependency like .csv / .json / .xls
# please ADD any files required here

ADD search-module.xml search-module.xml

ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh