FROM openjdk:8u191-jre-alpine3.9

WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# in case of any other dependency like .csv / .json / .xls
# please ADD any files required here

ADD search-module.xml search-module.xml

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE