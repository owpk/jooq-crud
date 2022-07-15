 docker run --name jooq-test -p 5432:5432 -e POSTGRES_PASSWORD=postgres --rm -d postgres
 sleep 6
 ./gradlew flywayMigrate
 ./gradlew generateJooq