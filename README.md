# Sample REST API Application
## This is a maven project built on spring boot and ready for deployment in cloud.

### Run as a jar file
This is an Uber jar. Hence, can be readily imaged for Docker. Execute it through command line: java -jar {name of the jar file with extension}
### Complete integration of the Swagger ui.
which can be accessed at: http://localhost:9090/rest-demo/api
### H2 Console
http://localhost:9090/rest-demo/api/h2-console

### H2 JDBC url
Refer to the property `spring.datasource.url`


## Docker commands
#### Local
```sh
    Build image:
    docker build -t <application_name> .
    Run the image in the container:
    docker run -p <docker_port>:<application_port> -t <application_name>
    Remove the image:
    docker image rm -f <application_name>
```
#### Docker hub
```sh
    Build image:
    docker image build -t <docker_id>/<tag_name>:<application_name> .
    Note: tag_name is either any existing in your docker hub account or a new name simply.
    Push the image to docker hub:
    docker image push <docker_id>/<tag_name>:<application_name>
    Run the image downloading from the docker hub:
    (Make sure removing the image from local machine)
    docker container run -d --name <any_name_for_service> -p <docker_port>:<application_port> <docker_id>/<tag_name>:<application_name>
```
#### Docker Swarm:
```sh
    Go to: https://labs.play-with-docker.com
    Login with your docker id and pwd
    This will default create a session with 3 hours.
    Click on the spanner icon, which will bring up an overlay. Select any template.
    Create a service:
    docker service create --name <any_name_for_service> -p <docker_port>:<application_port> --replicas <no_of_replicas> <docker_id>/<tag_name>:<application_name>
    Check the service:
    docker service ps <service_name>
    Access your service by clicking on the port number on docker play UI. This will open your service in anther browser/tab.

```


