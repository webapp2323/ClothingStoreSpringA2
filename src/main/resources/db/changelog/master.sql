--liquibase clearCheckSums

--liquibase formatted sql




--changeset Owl:create_table_jacket
--include file="db/changelog/sql/20241009-create-table-jacket.sql"

--changeset Owl:create_table_pants
--include file="db/changelog/sql/20241009-create-table-pants.sql"



--changeset Owl:create_table_shirt.sql
--include file="db/changelog/sql/20241009-create-table-shirt.sql"