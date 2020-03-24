# Software Development Engineer Tester

### Java Language
------------
#### Start date: December 19, 2019

##### video tutorial : 13hrs
------------
#### Purpose:
* Leaving self notation and reference material how the code works.
    * note: perfect example why set/get is better than how I currently think.
* Test Framework: TestNG

------------
#### Changed Workstations: December 22, 2019
* Laptop did not have enough memory to run Docker.
* Continuing project on Desktop.
------------
## Maven

Adding Packages/Dependencies to a Project:
pom.xml:

```html
	<build>
	 <plugins>
	...
    </plugins>
  </build>
  <dependencies>
     	<dependency>
           Dependency reference
     	</dependency>
  </dependencies>
```

------

## Docker 

#### Selenium Stand Alone
* Pull Docker container:
    * docker pull selenium/standalone-chrome:latest
	
* Run Docker container: 
    * docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest

## Selenium Grid
* Basic Grid setup
    * Make a _docker-compose.yaml_ file for configuration. 
       * There is a default hub configuration on [SeleniumHQ Github](https://github.com/SeleniumHQ/docker-selenium) to use as a start.
	
* Start Up Grid
     * docker-compose -f _docker-compose.yaml_ up

* Shutdown Grid
    * docker-compose -f _docker-compose.yaml_ down 

* Add more Nodes to hub.
    * docker-compose scale chrome=5 
      * usage: _browserName_= No. of instances.
------------

## Jenkins
* Getting Java Jenkins
    * file: Jenkins.war
* Run
	* java -jar jenkin.war
		* defaults port 8080, to change port: use --httpPort= _port number_
* Access GUI 
	* Browser: localhost:8080/

## Jenkins Pipline:
* Pipline runs this list in a batch job: small deployment testing
	* __Build__
		* maven install
	* __Deploy__
		 * shell-
	* __Testing__
		* maven test
	* __Release__
		* task

* Pipeline on large typical deployment testing jobs.
  * Some of this list can be combined Testing
    * Build
	* Unit Testing Coverage
	* Deploy into Development
	* Smoke Testing
	* Intergration Testing
	* Unit Testing
	* Deploy to QA
	* UI / End to End Testing
	* API Testing
	* Quality Check
	* Release into Production

* Create a .jenkinsfile script with Stages and Steps in running the full project being tested in root folder for automation. 
   * Execute Pipeline from Jenkin pointing to a GitHub or a Git repository.

