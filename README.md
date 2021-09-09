# Customer Preference App

Preference creator application is used to create and manage customer preference detail.
There are two microservices that facilitate the same app, Customer Preference Creator and Customer Preference Retriever respectively.

Spring boot framework is used to create the microservices using H2 in-memory database with  Spring data JPA, Swagger is used for api documentation.

Following principles are kept in mind while crafting this app.

1.  Simple
2.	Object oriented design.
3.	RESTfullness 
4.	Coding best practices, conventions and solid principles

## Running unit test cases 
Run unit test cases using below command for both preference-retriever and  preference-creator
```bash
gradle test
```

## Compile and Run

1) Checkout project using git. [url here](https://github.com/subinkoovery/TG-Coding-Test.git)
2) Open terminal and go to project parent folder and go to 'preference-creator` folder.
3) Run gradle build using below command, which will generate jar.


```bash
gradle build
```

5) Create docker network bridge.

```bash
docker network create preference-communication-network
```

6) Run docker build to create docker-image.

```bash
docker build -t preference-creator .
```

7) Run docker image preference-creator.
```bash
docker container run --network preference-communication-network --name preference-creator -p 7000:7000 preference-creator
```
8)  Similarly lets run the second microservice preference-retriever. Go to project parent folder and go to 'preference-retriever' and run

```bash
gradle build
```


9)  Run docker build to create docker-image.

```bash
docker build -t preference-retriever .
```

10) Run docker image preference-retriever.

```bash
docker container run --network preference-communication-network --name preference-retriever -p 7001:7001 preference-retriever
```

11) Now the 2 microservices are up , can try out the api through swagger mentioned in 'API documentation' section.

## API documentation
1) [Preference Creator](http://localhost:7000/swagger-ui/)

1) [Preference Retriever](http://localhost:7001/swagger-ui/)

## API notes
Note : As soon as the application starts there will be a customer created with ID 1.


1. Create a customer.


```bash
POST http://localhost:7000/api/v1/customer
{
  "createdOrUpdatedBy": 1,
  "name": "John Mathew",
  "userName": "jomathew"
}
```
2. Create customer preference.


```bash
POST http://localhost:7000/api/v1/preference
{
  "createdOrUpdatedBy": 1,
  "customerId": 2,
  "preferenceType": "EMAIL"
}
```
3. Call Customer Preference Retriever to retrieve customer preference.


```bash
 GET http://localhost:7001/api/v1/preference?customerId=2
```


