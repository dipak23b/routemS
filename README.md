# routemS

Loads the list of routes from city.txt (/opt/etc/config/) during server startup and cached.

Resource : /connected

	Checks if route exists between 2 cities. List of routes are fetched from city.txt placed in 	/opt/etc/config.	Uses Recursion to find out the connection between 2 cities when there is no 	direct connection.

Returns :

		HTTP CODE		Response	use case
		
		400				No			Bad Request for invalid input to resource
		500				No			Internal Server error/Unknown application exception
		200				Yes			Connection found between origin and destination
		200				No			no connection between origin and destination


### Prerequisites

mavan (3.3.x), java 8, git

### Installing

1. git clone https://github.com/dipak23b/routemS.git
2. cd routemS
2. mvn package
3. cd target
4. java -jar routemS-0.0.1-SNAPSHOT.jar

### Verify installation

http://localhost:8080/connected?origin=Boston&destination=Newark
http://localhost:8080/connected?origin=Boston&destination=Philadelphia
http://localhost:8080/connected?origin=Philadelphia&destination=Albany


## Deployment

spring configuration (application.properties) , logging configruation (logback.xml) and city.txt are loaded from /opt/etc/config/ folder.

## Versioning

NA. master branch code does not include versioning for connection endpoint.

## Authors
Dipak Patil

## License
NA

## Acknowledgments
NA
