# Customer Preference App

Preference creator application is used to create and manage customer preference detail.
There are two microservices that facilitate the same app, Customer Preference Creator and Customer Preference Retriever respectively.

Spring boot framework is used to create the microservices using H2 in-memory database with  Spring data JPA, Swagger is used for api documentation.

Following principles are kept in mind while crafting this app.

1.	Object oriented design.
2.	TDD (Test Driven Development)
3.	Coding best practices, conventions and solid principles

## How to run

1) Checkout project using git. (https://github.com/subinkoovery/TG-Coding-Test.git)
2) Open terminal and go to project parent folder and go to 'preference-creator` folder.
3) Run gradle build using below command, which will generate jar.


```bash
gradle build
```

5) Create docker network bridge.

```bash
docker network create preference-communication-network
```

6) Run docker build to create docker-image using below command

```bash
docker build -t preference-creator .
```

7) Run docker image preference-creator using as below

```bash
docker container run --network preference-communication-network --name preference-creator -p 7000:7000 preference-creator
```
8)  Similarly lets run the second microservice preference-retriever. Go to project parent folder and go to 'preference-retriever' and run

```bash
gradle build
```


9)  Run docker build to create docker-image using below command

```bash
docker build -t preference-retriever .
```

10) Run docker image preference-retriever using as below

```bash
docker container run --network preference-communication-network --name preference-retriever -p 7001:7001 preference-retriever
```

## API documentation
1) [Preference Creator](http://localhost:7000/swagger-ui/)

1) [Preference Retriever](http://localhost:7001/swagger-ui/)



## License
[MIT](https://choosealicense.com/licenses/mit/)