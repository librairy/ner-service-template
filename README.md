# Project template to create librAIry NER services

## Prerequisites

Maven is a Java tool, so you must have [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed in order to proceed.

Then, [download Maven](https://maven.apache.org/download.cgi) and follow the installation instructions. After that, type the following in a terminal or in a command prompt:

```sh
mvn --version
```

It should print out your installed version of Maven (3.x is required).

## Clone this project

You will need somewhere for your project to reside, create a directory somewhere and start a shell in that directory. On your command line, execute the following Maven goal:

```sh
git clone git@github.com:librairy/ner-service-template.git
```

*If you have just installed Maven, it may take a while on the first run. This is because Maven is downloading the most recent artifacts (plugin jars and other files) into your local repository.*
  
Change into that folder.

```sh
cd nlp-service-template
```

Under this directory you will notice the following project structure.

```xml
my-service
|-- pom.xml
[-- src
    |-- main
         |-- java
               [-- org
                    [-- librairy
                           [-- service
                                 [-- ner
                                      |-- controllers
                                            |-- AvroController.java
                                            |-- RestAnnotateController.java
                                            [-- RestProcessController.java
                                      |-- service
                                            [-- MyService.java
                                      [-- Application.java
         |-- resources
                |-- application.properties
                |-- banner.txt
                [-- logback.xml
         |-- bin
              |-- info.md
         [-- docker
              |-- Dockerfile
    [-- test
          |-- java
                [-- org
                     [-- librairy
                             [-- service
                                    [-- nlp
                                         |-- controllers
                                                |-- AvroTest.java
                                                |-- RestTest.java
                                         [-- MyServiceTest.java
          |-- resources
                 [-- logback.xml
          [-- docker
                 [-- run.sh
```

The `src/main/java` directory contains the project source code, the `src/test/java` directory contains the test source, and the `pom.xml` file is the project's Project Object Model, or POM.

You only have to take `src/main/java/org/librairy/service/ner/service/MyService` into account, which contains the service operations.  
 
## Test

JUnit from Spring has been used to facilitate the executions of tests. So, it will be enough to enrich the existing test classes with new tests and run it in your favourite IDE.
 
## Distribution

A `docker-maven-plugin` has also been configured to create a docker image automatically from the project code. Launch the following code when compiling and a Docker image will be created:  

```sh
mvn clean package docker:build 
```

If you have a [DockerHub](https://hub.docker.com) account, the docker image can be automatically uploaded by running:
```sh
mvn docker:push
```