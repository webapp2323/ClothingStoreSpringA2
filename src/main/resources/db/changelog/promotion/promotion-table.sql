--liquibase formatted sql

--changeset Owl:create_promotion_table
--preconditions onFail:MARK_RAN

--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_name = 'promotion';

CREATE TABLE IF NOT EXISTS promotion (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
    description TEXT,
    type VARCHAR(50) NOT NULL,
    discount DECIMAL(5, 2) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL
    );

--changeset Owl:insert_promotion_values
INSERT INTO promotion (name, description, type, discount, start_date, end_date) VALUES
                                                                                    ('Summer Sale', 'Discounts on summer clothing', 'PERCENTAGE_DISCOUNT', 20.00, '2025-06-01 00:00:00', '2025-06-30 23:59:59'),
                                                                                    ('Winter Clearance', 'End of season clearance sale', 'FIXED_DISCOUNT', 50.00, '2025-12-01 00:00:00', '2025-12-31 23:59:59'),
                                                                                    ('Black Friday', 'Special discounts for Black Friday', 'PERCENTAGE_DISCOUNT', 30.00, '2025-11-27 00:00:00', '2025-11-27 23:59:59'),
                                                                                    ('Holiday Special', 'Holiday season special offers', 'FIXED_DISCOUNT', 10.00, '2025-12-15 00:00:00', '2025-12-31 23:59:59'),
                                                                                    ('Flash Sale', 'Limited time flash sale', 'PERCENTAGE_DISCOUNT', 25.00, '2025-10-01 00:00:00', '2025-10-02 23:59:59');
