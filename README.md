# oss-radar

A Web based Tech Radar project to demo newest features in spring boot and maven plugins based on [AgileGuru Tech Radar](https://tech.agileguru.org/radar).  Please fork the repo and 


### 1.  JIB Plugin 

Use this plugin to automatically build and upload docker images of your application even if you dont have local docker. All you need to do is 

* comment execution with ID "build-and-push" if you have docker locally installed and want to see it working as a container. 
* comment execution with ID "build-image-local" if you do not have docker install and want to build the imaged and upload it to registry.


### 2. Git plugin ( git-commit-id-maven-plugin ) 

This plugin allows you to get git metadata as variables in pom.xml . E.g. In line 239 <tag>${git.branch}</tag> is used to tag the image


### 3. Flyaway DB ( db migration ) 

Automatic execution of db script when deploying the application. Uses Spring datasource as connection properties. 

### 4. Multiple profiles ( config )

Possible customization using spring profiles and environment variables. 

<hr/><br/>


## Build the application 

This is a standard maven project with maven wrapper. All you need is java 21 and docker on the machine. To build the app 


1. Change the <app.base.image>openjdk:21-jdk</app.base.image> to set the base image which has java 21 installed. 
1. Change the <docker.base.name>us-central1-docker.pkg.dev/devops-353009/devops-docker</docker.base.name> to right destination for docker image. 
1. Execute the command ```./mvnw clean install``` to build
1. Execute the command ```./mvnw clean spring-boot:run``` to run the app locally. 

## Run the application.

1. The base path of the application is http://0.0.0.0:2222/radar . You can change the context path and the port it to what you want in application.yml
