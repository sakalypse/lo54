Projet J2EE de gestion d'inscription à des cours.
Intégration de metrics au projet avec https://metrics.dropwizard.io/

## Running the app

```bash
# Launch Database and graphite :
$ docker-compose up

# Enter inside database :
$ docker exec -ti lo54_PostgreSQL_1 psql -U postgres

# Build core project, inside directory : "lo54ecole"
$ mvn clean install package

# Run core main :
$ java -cp target/lo54ecole-1.0-SNAPSHOT.jar:lib/* com.lo54.lo54ecole.App

# See Graphite graphs
Visit : localhost:80

# Run tomcat server, inside directory "lo54webapp" :
$ mvn tomcat7:run
```
