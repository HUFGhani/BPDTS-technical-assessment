# BPDTS Technical Assessment

[Click Here](https://bpdts-assessment.herokuapp.com/swagger-ui.html#/) to be taken the deployed application which is hosted on heroku.

 ## Prerequisites
 - Java JDK 13
 - Gradle
 
 ## System Architecture outline
The application use port is 8080, and use Spring Boot, SpingFox Swagger, Junit 5, lombok and  OpenFeign for communication with bpdts-test-app-v4.herokuapp.com api. 

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
4. Go to your web browser and type in localhost:8080 or [click here](http://localhost:8080) you would be introduced to a swagger documentation outlining the endpoint and the request and response body to be used by the api.

## Protect the system
To protect this system I would introduce a circuit breaker to the system to protect from  downstream service like the  bpdts-test-app-v4.herokuapp.com api, as the downstream service could down. It would detect failures and encapsulates the logic of preventing a failure from constantly recurring and temporary external system failure or unexpected system difficulties.

I would convert this service into a API Gateway or add Api Gateway, to protect the bpdts-test-app-v4.herokuapp.com  from overuse and abuse, so you use an authentication service and rate limiting. A single request could calls to dozens of distinct applications, within microservices architecture. The other benefit is that you can add some new API services and retire others, but your clients will still find all your services in the same place.

But this service behind Cloudflare as it offer plenty of security features like WAF, rate limiting, DDoS protection which will be essential in securing your API from online threats.

Add HTTPS/SSL to protect from any man-in-the-middle attack or packet sniffer tool.

Enforce IP address filtering. Your APIs are used by businesses from set locations, considering adding an extra layer of security that restricts IP address that can access the API. New client's and location can be add. 

Add monitring and alerting.

## Scaling the system
I would also add a Caching lay to the service to reduce the calls to bpdts-test-app-v4.herokuapp.com which would optimise the service and make it faster, this could be done in few way, which are the following:
- Spring Cache
- Amazon ElastiCache (works well with Spring Cloud AWS )
- Use Amazon DynamoDB as Cache ( a home brew meathod )

Move the system to kubernetes allows you to deploy cloud-native applications anywhere and manage them exactly as you like everywhere and it's easy to quickly ramp application instances to match spikes in demand. This is done by  Vertical scaling which is raising the resources (like CPU or memory) of each node in the cluster (or in a pool) or  Horizontal scaling which is by  adding new nodes to a cluster/pool. Horizontal and Vertical scaling can be done automatice.
To set how many pod need when request a high i would perform a Performance test using gattling or tool, so there is a baseline what a singal pod can handle.

Move the service to AWS, you can add load balance and spin up other AWS service on the fly plus use it monitring and alerting.

## Other improvements
- Add a React Frontend
- Move to AWS
- Add monitring, alerting and Tracing
- Add Contract testing
- Add Circuit breaker
- Dockerfile
- migrate to kubernetes