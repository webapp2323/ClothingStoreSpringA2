--liquibase formatted sql

--changeset Owl:create_promotion_clothing_item_table
--preconditions onFail:MARK_RAN

--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_name = 'promotion_clothing_items';

CREATE TABLE IF NOT EXISTS promotion_clothing_items (
                                                       promotion_id BIGINT NOT NULL,
                                                       clothing_item_id BIGINT NOT NULL,
                                                       PRIMARY KEY (promotion_id, clothing_item_id),
    FOREIGN KEY (promotion_id) REFERENCES promotion(id),
    FOREIGN KEY (clothing_item_id) REFERENCES clothing_items(id)
    );

--changeset Owl:insert_promotion_clothing_items_values
INSERT INTO promotion_clothing_items (promotion_id, clothing_item_id) VALUES
                                                                         (1, 1),
                                                                         (1, 2),
                                                                         (2, 3),
                                                                         (3, 4),
                                                                         (4, 5);
