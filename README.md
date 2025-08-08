# oss-radar

A Sample project to demo newest features in spring boot and maven plugins


## JIB Plugin 

Use this plugin to automatically build and upload docker images of your application even if you dont have local docker. All you need to do is 

* comment execution with ID "build-image-local" if you have docker locally installed and want to see it working as a container. 
* comment execution with ID "build-and-push" if you do not have docker install and want to build the imaged and upload it to registry.


## Git plugin ( git-commit-id-maven-plugin ) 

This plugin allows you to get git metadata as variables in pom.xml . E.g. In line 239 <tag>${git.branch}</tag> is used to tag the image

