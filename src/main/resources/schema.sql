-- Tabla BRAND
CREATE TABLE BRAND (
                       ID BIGINT PRIMARY KEY,
                       BRAND_NAME VARCHAR(255) NOT NULL
);

-- Tabla PRODUCT
CREATE TABLE PRODUCT (
                         ID BIGINT PRIMARY KEY,
                         PRODUCT_NAME VARCHAR(255) NOT NULL
);

-- Tabla PRICE
CREATE TABLE PRICE (
                       PRICE_ID BIGINT PRIMARY KEY,
                       BRAND_ID BIGINT,
                       PRODUCT_ID BIGINT,
                       START_DATE TIMESTAMP NOT NULL,
                       END_DATE TIMESTAMP NOT NULL,
                       PRIORITY INT NOT NULL,
                       PRICE DOUBLE NOT NULL,
                       CURR VARCHAR(3) NOT NULL,
                       FOREIGN KEY (BRAND_ID) REFERENCES BRAND(ID),
                       FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(ID)
);