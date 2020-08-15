# BPDTS Technical Assessment

[Click Here](https://bpdts-assessment.herokuapp.com/swagger-ui.html#/) to be taken the deployed application which is hosted on heroku.

 ## Prerequisites
 - Java JDK 13
 - Gradle
 
 ## System architecture outline
The application uses port 8080, and uses Spring Boot, SpingFox Swagger, Junit 5, Lombok and  OpenFeign for communication with bpdts-test-app-v4.herokuapp.com api. 

## Endpoints
- ```http://localhost:8080/``` or ```https://bpdts-assessment.herokuapp.com/``` Swagger Endpoint 
- ```http://localhost:8080/api/users``` or ```https://bpdts-assessment.herokuapp.com/api/users``` gets all the users
- ```http://localhost:8080/api/user/{id}``` or ```https://bpdts-assessment.herokuapp.com/api/user/{id}``` get user by id (replace {id} with user Id, for example:```http://localhost:8080/api/user/1``` )
- ```http://localhost:8080/api/london/users``` or ```https://bpdts-assessment.herokuapp.com/api/london/users``` get all users that live in london
- ```http://localhost:8080/api/london/users/distance/{distance}``` or ```https://bpdts-assessment.herokuapp.com/api/london/users/distance/{distance}``` get the Users that are in specified distance from centre of London (replace {distance} with the  distance value is in miles, for example: ```http://localhost:8080/api/london/users/distance/60``` )


## How to run the application locally
### To run this application without an IDE.
1. Open Terminal or Command Line/ PowerShell.
2. Navigate to the location where the project has been download or cloned.
3. Run `./gradlew clean bootrun` which would run the project.
4. Go to your web browser and type in localhost:8080 or [click here](http://localhost:8080) you would be introduced to a swagger documentation outlining the endpoint and the request and response body to use the API.

## Protect the system
To protect this system I would introduce a circuit breaker to the system to protect from  downstream service like the  bpdts-test-app-v4.herokuapp.com API, as the downstream service could go down. It would detect failures and encapsulates the logic of preventing a failure from constantly recurring and temporary external system failure or unexpected system difficulties.

I would convert this service into a API Gateway or add API Gateway, to protect the bpdts-test-app-v4.herokuapp.com  from overuse and abuse, so you use an authentication service and rate limiting. A single request could call to dozens of distinct applications, within microservices architecture. The other benefit is that you can add some new API services and retire others, but your clients will still find all your services in the same place.

But this service behind Cloudflare as it offers plenty of security features like WAF, rate limiting, DDoS protection which will be essential in securing your API from online threats.

Add HTTPS/SSL to protect from any man-in-the-middle attack or packet sniffing tool.

Enforce IP address filtering. Add an extra layer of security that restricts IP address that can access the API. 

Add monitoring and alerting.

## Scaling the system
I would also add a Caching lay to the service to reduce the calls to bpdts-test-app-v4.herokuapp.com which would optimise the service and make it faster, this could be done in few ways, such as:
- Spring Cache
- Amazon ElastiCache (works well with Spring Cloud AWS )
- Use Amazon DynamoDB as Cache ( a home brew method )

Move the system to kubernetes allows you to deploy cloud-native applications anywhere and manage them exactly as you like and it's easy to quickly ramp application instances to match spikes in demand. This is done by Vertical scaling which is raising the resources (like CPU or memory) of each node in the cluster (or in a pool) or  Horizontal scaling which is by  adding new nodes to a cluster/pool. Horizontal and Vertical scaling can be done automatically.
To set how many pods required for horizontal or vertical scaling I would need to perform a Performance test using gattling or other tools, so there is a baseline for a single pod that can handle.

Move the service to AWS, you can add load balance and spin up other AWS services on the fly.

## Other improvements
- Add a React Frontend
- Move to AWS
- Add monitoring, alerting and Tracing
- Add Contract testing
- Add Circuit breaker
- Dockerfile
- migrate to kubernetes
- add Structured Logging