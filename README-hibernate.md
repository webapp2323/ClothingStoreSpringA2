spring.application.name=ClothingStoreSpring

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.show-sql=true

spring.datasource.url=jdbc:postgresql://localhost:5432/store
spring.datasource.username=postgres
spring.datasource.password=postgres

#spring.datasource.url=${SPRING_DATASOURCE_URL}
#spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
#spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

spring.liquibase.change-log=classpath:db/changelog/master.yaml
spring.liquibase.enabled=false
spring.liquibase.default-schema=public


logging.level.root=INFO
logging.level.org.example.clothingstorespring.controller=DEBUG
logging.file.name=logs/application.log
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
-------------------
for CONSOLE:

ALTER TABLE jacket
DROP CONSTRAINT jacket_color_check;
ALTER TABLE jacket
DROP CONSTRAINT jacket_size_check;

INSERT INTO jacket (name, brand, size, material, color, has_hood) VALUES
('Classic Jacket', 'BrandA', 'MEDIUM', 'COTTON', 'BLUE', TRUE),
('Padded Jacket', 'BrandB', 'LARGE', 'POLYESTER', 'RED', FALSE),
('Rain Jacket', 'BrandC', 'SMALL', 'NYLON', 'GREEN', TRUE);

------------
АLTER TABLE pants
DROP CONSTRAINT pants_color_check;

ALTER TABLE pants
DROP CONSTRAINT pants_size_check;

INSERT INTO pants (name, brand, size, material, price) VALUES
('Casual Pants', 'BrandD', 'MEDIUM', 'COTTON', 49.99),
('Formal Pants', 'BrandE', 'LARGE', 'WOOL', 79.99),
('Sport Pants', 'BrandF', 'SMALL', 'POLYESTER', 39.99);
-----
ALTER TABLE shirt
DROP CONSTRAINT shirt_sleeve_type_check;

ALTER TABLE shirt
DROP CONSTRAINT shirt_size_check;

INSERT INTO shirt (name, brand, sleeve_type, size, material, price) VALUES
('Casual Shirt', 'BrandG', 'SHORT', 'MEDIUM', 'COTTON', 29.99),
('Formal Shirt', 'BrandH', 'LONG', 'LARGE', 'POLYESTER', 49.99),
('Sport Shirt', 'BrandI', 'SHORT', 'SMALL', 'NYLON', 39.99);
----------
INSERT INTO store (name, location, contact_email, established_date) VALUES
('Fashion Hub', 'Київ, вул. Хрещатик, 1', 'contact@fashionhub.ua', '2010-05-15'),('Style Point', 'Львів, пр. Свободи, 25', 'info@stylepoint.ua', '2015-08-22'),('Urban Wear', 'Одеса, вул. Дерибасівська, 10', 'sales@urbanwear.ua', '2018-11-30');
---------------
INSERT INTO "user" (username, password, email) VALUES
('ivan123', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'ivan@ua.example.com'),                                               ('maria456', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'maria@ua.example.com'),                                                   ('alex789', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'alex@ua.example.com');
---------------
INSERT INTO user_role (user_id, role_id) VALUES
(1, 1),
(2, 1),
(3, 2);
-----------------
INSERT INTO "order" (user_id, store_id, total, order_date) VALUES
(1, 1, 279.98, '2024-10-21'),
(2, 2, 149.99, '2024-10-22'),
(3, 3, 89.99, '2024-10-23');
--------------
ALTER TABLE deliveries
DROP CONSTRAINT deliveries_status_check;

INSERT INTO deliveries (order_id, delivery_address, delivery_date, delivery_type, status) VALUES
(1, '101 First St, NewCity', '2024-10-30', 'EXPRESS', 'SCHEDULED'),
(2, '202 Second St, OldTown', '2024-10-31', 'STANDARD', 'PENDING'),
(3, '303 Third St, FutureVille', '2024-11-01', 'OVERNIGHT', 'IN_TRANSIT');
------------------

