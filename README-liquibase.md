

spring.application.name=ClothingStoreSpring

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.show-sql=true

spring.datasource.url=jdbc:postgresql://localhost:5432/store
spring.datasource.username=postgres
spring.datasource.password=postgres

#spring.datasource.url=${SPRING_DATASOURCE_URL}
#spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
#spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

spring.liquibase.change-log=classpath:db/changelog/master.yaml
spring.liquibase.enabled=true
spring.liquibase.default-schema=public


logging.level.root=INFO
logging.level.org.example.clothingstorespring.controller=DEBUG
logging.file.name=logs/application.log
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} - %msg%n



- include:
    - file: db/changelog/sql/init-script-db.sql

- include:
    - file: db/changelog/sql/jac-create-table.sql

- include:
    - file: db/changelog/sql/jac-size-fix.sql

- include:
    - file: db/changelog/sql/jac-color-fix.sql
-   - include:
  - file: db/changelog/sql/datainitialaizer.sql