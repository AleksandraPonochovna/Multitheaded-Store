CREATE DATABASE IF NOT EXISTS `database`;

CREATE TABLE store
(
    id         INT NOT NULL,
    store_name VARCHAR(50),
    PRIMARY KEY (id)
) ENGINE = InnoDB,
  DEFAULT CHARACTER SET = utf8,
  COLLATE = utf8_general_ci;

CREATE TABLE category
(
    id             INT NOT NULL,
    category_title VARCHAR(50),
    store_id       INT,
    PRIMARY KEY (id),
    UNIQUE (category_title, store_id)
) ENGINE = InnoDB,
  DEFAULT CHARACTER SET = utf8,
  COLLATE = utf8_general_ci;

CREATE TABLE product
(
    id             INT NOT NULL,
    products_title VARCHAR(50),
    price          REAL,
    status         VARCHAR(50),
    category_id    INT,
    PRIMARY KEY (id)
) ENGINE = InnoDB,
  DEFAULT CHARACTER SET = utf8,
  COLLATE = utf8_general_ci;

ALTER TABLE product
    ADD CONSTRAINT category_id
        FOREIGN KEY (category_id)
            REFERENCES category (id);

ALTER TABLE category
    ADD CONSTRAINT store_id
        FOREIGN KEY (store_id)
            REFERENCES store (id);