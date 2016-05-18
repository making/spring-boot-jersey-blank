# Spring Boot Jersey Blank

Maven archetype to create a pre-configured maven project for Spring Boot Jersey Application

Supports

* log4jdbc-log4j2
* Lombok
* REST Assured (for E2E test)

[![Build Status](https://travis-ci.org/making/spring-boot-jersey-blank.svg)](https://travis-ci.org/making/spring-boot-jersey-blank)

## How to use

with Bash

    mvn archetype:generate\
     -DarchetypeGroupId=am.ik.archetype\
     -DarchetypeArtifactId=spring-boot-jersey-blank-archetype\
     -DarchetypeVersion=1.0.2

with CommandPrompt (Windows)

    mvn archetype:generate^
     -DarchetypeGroupId=am.ik.archetype^
     -DarchetypeArtifactId=spring-boot-jersey-blank-archetype^
     -DarchetypeVersion=1.0.2
	 
If using Eclipse IDE (or other IDE), install Lombok:
First, download dependencies into local Mavan repo to get Lombok jar:
	
	mvn dependency:resolve
	
Now run the Lombok installer from jar (one-off procedure):
	
    java -jar ~/.m2/repository/org/projectlombok/lombok/1.16.8/lombok-1.16.8.jar

### Example

#### Create a project

```
$ mvn archetype:generate -B\
  -DarchetypeGroupId=am.ik.archetype\
  -DarchetypeArtifactId=spring-boot-jersey-blank-archetype\
  -DarchetypeVersion=1.0.2\
  -DgroupId=com.example\
  -DartifactId=hajiboot\
  -Dversion=1.0.0-SNAPSHOT
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom <<<
[INFO]
[INFO] --- maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[WARNING] Archetype not found in any catalog. Falling back to central repository (http://repo1.maven.org/maven2).
[WARNING] Use -DarchetypeRepository=<your repository> if archetype's repository is elsewhere.
Downloading: http://repo1.maven.org/maven2/am/ik/archetype/spring-boot-jersey-blank-archetype/1.0.2/spring-boot-jersey-blank-archetype-1.0.2.jar
Downloaded: http://repo1.maven.org/maven2/am/ik/archetype/spring-boot-jersey-blank-archetype/1.0.2/spring-boot-jersey-blank-archetype-1.0.2.jar (6 KB at 7.5 KB/sec)
Downloading: http://repo1.maven.org/maven2/am/ik/archetype/spring-boot-jersey-blank-archetype/1.0.2/spring-boot-jersey-blank-archetype-1.0.2.pom
Downloaded: http://repo1.maven.org/maven2/am/ik/archetype/spring-boot-jersey-blank-archetype/1.0.2/spring-boot-jersey-blank-archetype-1.0.2.pom (3 KB at 3.8 KB/sec)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: spring-boot-jersey-blank-archetype:1.0.2
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: hajiboot
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: packageInPathFormat, Value: com/example
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: hajiboot
[INFO] project created from Archetype in dir: /Users/maki/tmp/hajiboot
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8.407s
[INFO] Finished at: Wed Oct 08 09:20:27 JST 2014
[INFO] Final Memory: 15M/109M
[INFO] ------------------------------------------------------------------------

$ find . | sort | sed '1d;s,[^/]*/,|    ,g;s/..//;s/[^ ]*$/|-- &/'
   |-- hajiboot
   |    |-- pom.xml
   |    |-- src
   |    |    |-- main
   |    |    |    |-- java
   |    |    |    |    |-- com
   |    |    |    |    |    |-- example
   |    |    |    |    |    |    |-- App.java
   |    |    |    |    |    |    |-- AppConfig.java
   |    |    |    |    |    |    |-- HelloEndpoint.java
   |    |    |    |-- resources
   |    |    |    |    |-- application.yml
   |    |    |    |    |-- log4jdbc.log4j2.properties
   |    |    |    |    |-- logback.xml
   |    |    |-- test
   |    |    |    |-- java
   |    |    |    |    |-- com
   |    |    |    |    |    |-- example
   |    |    |    |    |    |    |-- HelloEndpointTest.java
   |    |    |    |-- resources
   |    |    |    |    |-- .gitkeep



$ cd hajiboot
```

#### Run prepared E2E tests

``` bash
$ mvn test
```

#### Run the app quickly

``` bash
$ mvn spring-boot:run
```

Access http://localhost:8080/calc?left=100&right=200

#### Build executable jar

``` bash
$ mvn package
$ java -jar target/*.jar
```

## License

Licensed under the Apache License, Version 2.0.
