In order to run the application, first, we need to do a maven build. Since we are using postgres database in docker container
we need to do maven build with skip tests flag. Otherwise, build will fail and will not create .jar file.
to build the .jar file do:
mvn clean install -DskipTests=true

Result of the command will be .jar file of our web application located inside /target directory.
To be able to run application, execute docker composer:
docker-compose up

Docker composer file have three services, our spring boot web app, postgres database and pgadmin - GUI for postgres.

In order to be able to connect to postgres with pgAdmin, open browser and go to:
http://localhost:5050

Create server with arbitrary name, and on the connection tab, for address, use docker container name (postgres),
mybd for database name and user and password from the application.properties file.

What is going on inside the app? When the application is started, application will look inside changelog-master.xml
and will execute all files from master file. First one will create book table inside postgres with 3 columns (id, title and author). Second script will populate this table with test data which is located resources/data/books.csv file.

Every other migration which will change the database should be added to changelog-master.xml file. Files from the list will be executed sequentially. Every change to the existing database should be made this way.

In order to test application, open the browser and go to http://localhost:8081/books.

In order to perform remote debugging, we need to change two things:

1. change Dockerfile by adding new line which will allow remote debugger to attach to the process:
   ENTRYPOINT java -Xdebug -Xrunjdwp:transport=dt_socket,address=8081,server=y,suspend=y -jar /app/demo-0.0.1-SNAPSHOT.jar
2. Add new launch configuration by clicking on the Debug icon (or pressing CTRL + SHIFT + D) and then click on Open launch.json from upper left part of IDE and clicking on gear icon. This will open launch.json file in the editor. Clicking on the 'Add Configuration...' button will open drop down. Select 'Java: Attach to Remote Program'
   option which will add new entry to the json file. Change the host name to the 'localhost' and port to the exposed port (in this case 8081). Save the changes.

Launch containers by typing 'docker-compose up --build' in order to pick the changes from the Dockerfile. Containers will start and the spring app container will stop, expecting the user interaction before continuing. On the bottom part of the ide click on the 'Select and start debug configuration'. Select newly added debug configuration from the drop down. Containers will continue to boot up and after few seconds app will be ready. Place the break point on the controller and try to hit end-point from the
browser or Postman app. It should stop on given break point.
