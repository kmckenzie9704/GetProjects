# fetch basic image
FROM maven:3.3.9-jdk-8

# application placed into /opt/app
#RUN mkdir -p /opt/app
#WORKDIR /opt/app

# selectively add the POM file and
# install dependencies
#COPY pom.xml /opt/app/
#RUN mvn install

# rest of the project
#COPY src /opt/app/src
#RUN mvn package

FROM jetty
COPY /var/lib/jenkins/workspace/GetProjects/target/TimeManagement-1.0.0.war /var/lib/jetty/webapps/TimeManagement-1.0.0.war

# local application port
EXPOSE 8080