## Chautari
This is a rental platform back-end application.

#### Chautari Service API:
![chautari-api](chautari-api.png)

### Database:
Chautari uses MySQL database to store service entities.

#### DB connection:

Add following connection properties in `application.properties` file

```properties
spring.datasource.url=jdbc:mysql://<host-url>:3306/<db-name>
spring.datasource.username=<user>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
```

#### ER diagram:

![chautari-er-diagram](chautari-er-diagram.png)
 
 