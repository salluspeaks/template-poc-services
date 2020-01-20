# Microservice Accelerator

This document is a guide for new developers, acting as an on-boarding document.

### Overview:

* [Application](#application)
* [Branching Strategy](#branching-strategy)
* [Build Pipeline](#build-pipeline)
* [Testing Approach](#testing-approach)
* [Deployment](#deployment)
* [Running Application Locally](#running-application-locally)
* [CURL Request Sample](#curl-request-sample)

## Application

## Branching Strategy

As part of every feature story, a feature branch need to be cut from the develop branch.


## Build Pipeline

Take a cut out of the develop branch locally to start working on the story.
It uses gradle as the build tool
Few of the important command to start would be:

```shell script
./gradlew init
./gradlew build
./gradlew ms-accelerator-servic:bootRun
```

## Testing Approach

* **Unit Test**:

    The unit test is implemented by using JUnit library and will run as JUnit Test.

        ./gradlew ms-accelerator-service:test --info

* **Component Test**:

    The component test is implement by using Junit as well as spring test libraries.
		As a practice pipeline would expect for a docker file with the name Dockerfile-component to run all the component tests.

	    ./gradlew ms-accelerator-service-component-test:test --info

* **PACT Test**:

    As part of the consumer module , pact consumer tests can be implemented to generate PACT file and as part of component-test module they can be verified.
		As a practice pipeline would expect for a docker file with the name Dockerfile-Pact to run all the PACT tests and to publish the PACT file.

        ./gradlew clean ms-accelerator-service-consumer-pact:test ms-accelerator-service-consumer-pact:pactPublish ms-accelerator-provider-pact:test ms-accelerator-provider-pact:pactVerify --info


## Deployment

The App will be deployed in docker containers. To deploy we would be relying on config files such as
 .yml file, Dockerfile, Component & Integration

 ## Running Application Locally

 ### Setup with Intellij IDE & Docker for desktop

 * Step 1: Install Lombok plugin

     A plugin that adds first-class support for Project Lombok. Project Lombok is a java library that automatically plugs into your editor and build tools and auto generates the getters,setters,equals, hashcode and toString methods with the annotations.

     * Important: Lombok Requires Annotation Processing. For the plugin to function correctly, please enable it under

         "Settings > Build > Compiler > Annotation Processors"

     * To install the Lombok plugin

         Go to Preferences > Plugins

         Search for Lombok Plugin

         Click on Install plugin

         Go to Preferences -> Build, Execution and Deployment -> Annotation Processors -> Tick the checkbox against 'Enable Annotation Processing'

         Restart IntelliJ IDEA

 * Step 2: To spin up Postgres DB. Use docker-compose file present in the source to start a postgres service if required

         docker-compose -f docker-compose.yml up

     * Pre-requisite: Install docker for desktop

 * Step 3: Start spring boot application :

     Use spring.profiles.active=local in application.properties or add additional vm parameter `-Dspring.profiles.active=local` to your run configuration.

         ./gradlew clean build ms-accelerator-service:bootRun -Dspring.profiles.active=local
