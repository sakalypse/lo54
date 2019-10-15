Launch Database :
$ docker-compose upava -cp target/lo54ecole-1.0-SNAPSHOT.jar com.lo54.lo54ecole.App

Enter inside database :
$ docker exec -ti lo54_PostgreSQL_1 psql -U postgres

Build the project
$ mvn package

Run main
$ java -cp target/lo54ecole-1.0-SNAPSHOT.jar com.lo54.lo54ecole.App
