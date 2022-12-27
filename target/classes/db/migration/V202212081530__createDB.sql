CREATE TABLE IF NOT EXISTS product (
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    type char(3) NOT NULL,
    sub_type varchar(255) NOT NULL,
    created datetime NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS broker (
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    created datetime NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS broker_product (
    id varchar(255) NOT NULL,
    broker_id varchar(255) NOT NULL,
    product_id varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS trade (
    id varchar(255) NOT NULL,
    product_id varchar(255) NULL,
    ref varchar(255) NOT NULL,
    trade_date varchar(255) NOT NULL,
    qty INT NOT NULL,
    is_buy bit NOT NULL,
    broker_id varchar(255) NULL,
    price varchar(255) NOT NULL,
    created datetime NULL,
    PRIMARY KEY (id)
);
