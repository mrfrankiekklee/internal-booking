CREATE TABLE IF NOT EXISTS product (
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    created varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS broker (
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    created varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS trade (
    id varchar(255) NOT NULL,
    product_id varchar(255) NULL,
    ref varchar(255) NOT NULL,
    trade_date varchar(255) NOT NULL,
    qty varchar NOT NULL,
    is_buy bit NOT NULL,
    broker_id varchar(255) NULL,
    pairs varchar(255) NOT NULL,
    price varchar(255) NOT NULL,
    expiry varchar(255) NULL,
    created varchar(255) NULL,
    PRIMARY KEY (id)
);
