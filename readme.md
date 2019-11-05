Launch Database :
$ docker-compose up

Enter inside database :
$ docker exec -ti lo54_PostgreSQL_1 psql -U postgres

Acceding database from local
$ psql -h localhost -p 5432 -U postgres


Build the project
$ mvn clean install package

Run main
$ java -cp target/lo54ecole-1.0-SNAPSHOT.jar:libs/* com.lo54.lo54ecole.App
