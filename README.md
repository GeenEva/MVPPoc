# MVPPoc
POC for Optiecon MVP: Spring Boot 

add applciation.properties to /resources, with:

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/mvppoc
spring.datasource.username= #yourusernamehere
spring.datasource.password= #yourpasswordhere
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.sql.init.mode=always
spring.datasource.initialize=true

DON'T FORGET TO ADD applciation.properties TO YOUR GITIGNORE!
src/main/resources/application.properties


