Using this Skeleton:
===============================

1. Create a new public project in gitlab with the project name (i.e. `service-something-here`).
1. Clone this new project into local workspace
  1. `cd ~/workspace`
  1. `git clone git@gitlab.global.dish.com:service-layer/service-something-here.git`
1. Copy service-skeleton project files into the new workspace directory
  1. `cd ~/workspace/service-something-here`
  1. `rsync -a --exclude='common-utils' ../service-skeleton/* .`
  1. `cp ../service-skeleton/.gitignore .`
  1. `cp ../service-skeleton/.pairs .`
  1. `git submodule add https://gitlab.global.dish.com/service-layer/common-utils.git`

## GENERAL SETUP

IN THIS FILE:
-------------
1.  Replace all __CodeChallenge062717__ with your git project name (i.e. `service-something-here`)
1.  Replace all __CodeChallenge062717__ with your title-case project name (i.e. `Service Something Here`)
1.  Replace all __codeChallenge062717__ with your project name in Pascal-case (i.e. `ServiceSomethingHere`)
1.  Replace all __com.dish.ofm.service.jwaCodeChallenge__ with your Java com.dish.ofm.service.jwaCodeChallenge (i.e. `somethinghere`)
1.  Go to the command line and run the following commands:

```
cd src/main/java/com/dish/ofm/service/PACKAGE_NAME/config
mv APPLICATION_NAMEConfig.java __codeChallenge062717__Config.java
cd ../controller
mv APPLICATION_NAMEController.java __codeChallenge062717__Controller.java
cd ../..
mv PACKAGE_NAME __com.dish.ofm.service.jwaCodeChallenge__
mv APPLICATION_NAMEApplication.java __codeChallenge062717__Application.java

cd ../../../../../../test/java/acceptance/
mv APPLICATION_NAMETest.java __codeChallenge062717__Test.java
```

IN ENTIRE PROJECT:
------------------

1. Replace all CodeChallenge062717 with __CodeChallenge062717__
  1.  Replace all CodeChallenge062717 with __CodeChallenge062717__
1.  Replace all 8888 with your port number
  1. Determine the 8888 by from [here](https://www.pivotaltracker.com/projects/1434608/stories/115506469)
  1. Add service name and port to the tracker documentation story above
1.  Replace all REST_ENDPOINT with your REST endpoint suffix (i.e. lookup-commitment)
  1.  Replace all REST_ENDPOINT_CAMEL_CASE with your camel-case REST endpoint (i.e. lookupCommitment)
  1.  Replace all REST_ENDPOINT_SUCCESS_MESSAGE with your REST endpoint success description (i.e. Lookup of customer commitments Successful)
1.  Replace all APPLICATION_NAME with the Pascal-case application name (i.e. `CommitmentService`)
1.  Replace all PACKAGE_NAME with __com.dish.ofm.service.jwaCodeChallenge__
1.  If Zipkin needs to be enabled as part of acceptance criteria, make sleuth enabled flags to true (i.e `enabled: true`) in application.yml file
1.  Run `gradle clean build`
1. Update Project settings in IntelliJ
    1. Open File --> Project Structure (command + ;)
    1. Update Sdk and language level
    1. Update project name to __CodeChallenge062717__
    1. Go to Modules and Update module name to __CodeChallenge062717__
1. Run `gradle clean build` to make sure everything is still intact
1. Re-import project in IntelliJ (using Existing sources) and delete 'GIT_PROJECT_NAME.iml' file if found

SAMPLE README below:
===============================

# CodeChallenge062717 API
The CodeChallenge062717 API is a RESTful service for interacting with <SERVICE INFO HERE>.

## Project Requirements
- JDK 1.8.0-31 or higher
- Gradle 2.1 or higher

## Getting Started
1. Follow the instructions on the [wiki](https://it-wiki.global.dish.com/index.php/Dish_Root_Cert) to add the artifactory
cert to your local machine.
  1. Navigate to the your `[JAVA INSTALLATION DIR]/jre/lib/security`. On OSX, this can be achieved by running `cd "$(/usr/libexec/java_home)/jre/lib/security"`.
  1. Create file called `dish.cer` with the contents of the certificate on the [wiki](https://it-wiki.global.dish.com/index.php/Dish_Root_Cert).
  1. Run `sudo ../../bin/keytool --importcert -v -trustcacerts -file dish.cer -keystore cacerts`
  1. When prompted for a password, enter "changeit"
1. clone `https://gitlab.global.dish.com/service-layer/CodeChallenge062717.git`
1. if git alias is setup on your terminal then run `gupdate`, otherwise run `git pull -r & git submodule update --init --recursive --remote`
1. run `gradle clean build`

## Starting the App
`gradle bootRun`

## Running Unit Tests
`gradle clean test`

## Running Integration Tests
[TODO]

## To add an external project as sub-module for the first time
1. Open terminal and go to ~/workspace/<project-dir>
1. execute `git submodule add https://gitlab.global.dish.com/service-layer/common-utils.git`
    1. This command will add git project as sub-module. This command generates .gitmodules file which further needs to be committed into git repository as well. 
1. Add following common-utils as a compile time dependency to build.gradle
    project(':common-utils')
1. Add following to settings.gradle to include the new sub-module as part of main project
    include 'common-utils'

## Start the App in Debug mode

To run the app in debug mode :

1. `cd ~/workspace/CodeChallenge062717`
1. `gradle clean assemble && SERVER_PORT=8888 java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -jar build/libs/CodeChallenge062717.jar` 

The app listens on port 5005
Create a new Remote Configuration in IntelliJ:

1. Run -> Edit Configurations. 
1. Hit the '+' button and select 'Remote'. 
1. Set the port as 5005.
1. Run -> Debug
1. Select the remote configuration

## Api Docs
Once the application is up and running you can see the [Swagger API Docs](http://localhost:8888/swagger-ui.html) in your browser.

#### 1. CodeChallenge062717
##### Sample Request

```
GET http://host:8888/REST_ENDPOINT

i.e GET http://localhost:8888/REST_ENDPOINT
  
```

##### Sample Response

```
Http Status code
```