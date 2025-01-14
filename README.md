# RabbitMQ integrated Project

## Description
In this project I Have impleted RabbitMQ with the help of springboot

# Example
The project demonstrates how RabbitMQ can be implemented with springboot for asynchronous messaging.
Where One service is a producer which is produing the messages and sending it to RabbitMQ 
Another Service is a consumer which is consuimg the messages from the RabbitMQ and processing it 

## Prerequisites
List of tools and technologies required to run the project
- RabbitMQ installed
- Java 17 ( or relevent programming language/Technology)
- Maven for dependency Management
- Spring tool Suite ( or any relevent editor)
- Docker ( to Intall RabbitMQ, You can directly install RabbitMQ As well)

  ## Installation and Setup
  ### 1. Clone the project
    git clone
  ### 2. Open project
    Extract the project and open in any text editor
  ### 3. Run the service
    Run the service, change the port number if needed
  ### 4. Intall Docker
    Install Docker desktop to install RabbitMQ
  **Note** - **You can directly install RabbitMQ as well**
  ### 5. Install RabbitMQ
    Go go docker hub (https://hub.docker.com/) and search for Rabbit MQ
  In the Supported tags and respective Dockerfile links section copy the name and run the followning command in terminal
    Docker pull 4.1.0-beta.3-management ( name of the image)
  ### 6. Run Rabbit MQ
    Once installed, Run the rabbit MQ using the following command
  docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:4.0.5-management
### 7. Run Springboot project
  Then run the following Spring boot projects, and Hits the APIs mentioned in the controller to see the implementation of RabbitMQ
