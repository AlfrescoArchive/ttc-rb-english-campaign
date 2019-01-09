# BluePrint - Trending Topic Campaigns: Activiti Marketing Campaign Runtime Bundle
This project implements a Domain Specific extension of the Activti Cloud Runtime Bundle concept.
This project is designed to implement the specification of what a Marketing campaign is, and how it should interact
with other services in the platform to process, track, monitor and reward users engaged with this campaign. 

The campaign itself is not bounded to a particular social media feed and it is prepared to recieve multiple feeds
in an async way.  

This project implements the Write/Command Executor part of the CQRS pattern. Because of this interacting from a client application
to this service is usually not recommended, for consuming data it is recommended to use the Query Service.


# Run

In order to run this project locally, you need to clone the source code and then run inside the root directory

> mvn -Dserver.port=808x spring-boot:run

**Note**: replace "x" for your desired port number

You can use the following docker-compose file in order to start Rabbit MQ so the service can connect and send messages.



# Endpoints
- GET http://localhost:808x/ -> welcome message
- GET http://localhost:808x/topic -> get the current topic for this campaign
- GET http://localhost:808x/v1/process-definitions/ -> get all the inmutable list of process definitions available for this campaign
- GET http://localhost:808x/v1/process-instances/ -> get all the in-flight process instances 
- GET http://localhost:808x/v1/tasks/ -> get all the active (not completed tasks) - Endpoint not yet used in this example


# Configuration

You can configure some basic paramenters for the campaign by setting the following properties inside the application.properties file:

```
campaign.name= activiti 
campaign.lang= en
```

This service by default is configured to store data into an in memory DB H2. This can be changed to PostgreSQL:
1) Uncommenting the PostgreSQL JDBC driver into the pom.xml file and setting H2 to scope test
2) Uncommenting the lines inside the application.properties under the comment # PostgreSQL   
3) Provide a running instance of PostgreSQL - look at the docker-compose file for the environment

# Notes

Notice inside the charts/tt-rb-english-campaign/templates/service.yaml file which has been modified to include the following labels inside its metadata:

```
type: campaign
campaign.name: activiti
campaign.lang: en
```

This enable other services to leverage service discovery capabilities to find all the registered campaigns. One example of this can be found inside the 
[ttt-infra-gateway](http://github.com/activiti/ttc-infra-gateway) project. 
