# Problem Description
Consume a Kafka stream of events and collect certain information in memory to be able to deliver it to a caller via RESTful API. The event should contain at least one field containing a mail address. The application should consume the event stream and count the unique number of overall mail addresses and domains which occurred within the event stream. Bring in own ideas when something seems not be fully specified.

#Kafka Commands
```
zookeeper-server-start.bat config\zookeeper.properties

kafka-server-start.bat config\server.properties

kafka-topics.bat --bootstrap-server localhost:9092 --topic emails --create --partitions 3 --replication-factor 1

kafka-console-producer --topic emails --bootstrap-server localhost:9092 < test-single.json
```

#Message Example
```{"email":"someEmail1@test3.com"}```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-kafka)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

