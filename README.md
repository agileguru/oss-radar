# oss-radar

A Sample project to demo newest features in spring boot and maven plugins in the shape of a tech radar. 


## JIB Plugin 

Use this plugin to automatically build and upload docker images of your application even if you dont have local docker. All you need to do is 

* comment execution with ID "build-image-local" if you have docker locally installed and want to see it working as a container. 
* comment execution with ID "build-and-push" if you do not have docker install and want to build the imaged and upload it to registry.


## Git plugin ( git-commit-id-maven-plugin ) 

This plugin allows you to get git metadata as variables in pom.xml . E.g. In line 239 <tag>${git.branch}</tag> is used to tag the image


## Build

This is a standard maven project with maven wrapper. All you need is java 21 and docker on the machine. Change the following 


1. <app.base.image>openjdk:21-jdk</app.base.image> to set the base image which has java 21 installed. 
1. <docker.base.name>us-central1-docker.pkg.dev/devops-353009/devops-docker</docker.base.name> to right destination for docker image. 


## Run


1. The base path of the application is http://host:2222/radar . You can change the context path and the port it to what you want in application.yml