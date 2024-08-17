-- Inserting data into BRAND table
INSERT INTO BRAND (ID, BRAND_NAME) VALUES (1, 'ZARA');

-- Inserting data into PRODUCT table
INSERT INTO PRODUCT (ID, PRODUCT_NAME) VALUES (35455, 'SHIRT SIDE BUTTONS');

-- Inserting data into PRICE table
INSERT INTO PRICE (PRICE_ID, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES
(1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35455, 0, 35.50, 'EUR'),
(2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 35455, 1, 25.45, 'EUR'),
(3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 35455, 1, 30.50, 'EUR'),
(4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 35455, 1, 38.95, 'EUR');

