Launch Database :
$ docker-compose up

Enter inside database :
$ docker exec -ti lo54_PostgreSQL_1 psql -U postgres

Build the project
$ mvn package

Run main
$ java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
