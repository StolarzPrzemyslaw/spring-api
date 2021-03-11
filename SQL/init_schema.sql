-- fill category
INSERT INTO category (name) VALUES ('food');  -- id: 1
INSERT INTO category (name) VALUES ('AGD');  -- id: 2
INSERT INTO category (name) VALUES ('electronics');  -- id: 3
INSERT INTO category (name) VALUES ('clothes');  -- id: 4
INSERT INTO category (name) VALUES ('furniture');  -- id: 5

-- fill product
INSERT INTO product (name, price, category_id) VALUES ('apple', 1, 1);  -- id: 1
INSERT INTO product (name, price, category_id) VALUES ('pear', 1.5, 1);  -- id: 2
INSERT INTO product (name, price, category_id) VALUES ('tomato', 2, 1);  -- id: 3
INSERT INTO product (name, price, category_id) VALUES ('oven', 1000, 2);  -- id: 4
INSERT INTO product (name, price, category_id) VALUES ('fridge', 1300, 2);  -- id: 5
INSERT INTO product (name, price, category_id) VALUES ('tv', 2000, 3);  -- id: 6
INSERT INTO product (name, price, category_id) VALUES ('smartphone', 700, 3);  -- id: 7
INSERT INTO product (name, price, category_id) VALUES ('router', 200, 3);  -- id: 8
INSERT INTO product (name, price, category_id) VALUES ('play station', 900, 3);  -- id: 9
INSERT INTO product (name, price, category_id) VALUES ('trousers', 140, 4);  -- id: 10
INSERT INTO product (name, price, category_id) VALUES ('socks', 10, 4);  -- id: 11
INSERT INTO product (name, price, category_id) VALUES ('blouse', 80, 4);  -- id: 12
INSERT INTO product (name, price, category_id) VALUES ('t-shirt', 40, 4);  -- id: 13
INSERT INTO product (name, price, category_id) VALUES ('chair', 50, 5);  -- id: 14
INSERT INTO product (name, price, category_id) VALUES ('table', 500, 5);  -- id: 15
INSERT INTO product (name, price, category_id) VALUES ('wardrobe', 3000, 5);  -- id: 16
INSERT INTO product (name, price, category_id) VALUES ('bed', 1700, 5);  -- id: 17

-- fill orders
INSERT INTO orders (order_date) VALUES ('2020-10-12');  -- id: 1
INSERT INTO orders (order_date) VALUES ('2020-11-12');  -- id: 2
INSERT INTO orders (order_date) VALUES ('2020-12-12');  -- id: 3
INSERT INTO orders (order_date) VALUES ('2021-01-12');  -- id: 4
INSERT INTO orders (order_date) VALUES ('2021-02-12');  -- id: 5

-- fill product_basket
INSERT INTO product_basket (product_id, amount, order_id) VALUES (1, 10, 1);  -- id: 1
INSERT INTO product_basket (product_id, amount, order_id) VALUES (6, 1, 1);  -- id: 2
INSERT INTO product_basket (product_id, amount, order_id) VALUES (7, 1, 2);  -- id: 3
INSERT INTO product_basket (product_id, amount, order_id) VALUES (4, 1, 3);  -- id: 4
INSERT INTO product_basket (product_id, amount, order_id) VALUES (9, 1, 3);  -- id: 5
INSERT INTO product_basket (product_id, amount, order_id) VALUES (6, 1, 3);  -- id: 6
INSERT INTO product_basket (product_id, amount, order_id) VALUES (14, 5, 4);  -- id: 7
INSERT INTO product_basket (product_id, amount, order_id) VALUES (15, 1, 4);  -- id: 8
INSERT INTO product_basket (product_id, amount, order_id) VALUES (16, 1, 4);  -- id: 9
INSERT INTO product_basket (product_id, amount, order_id) VALUES (17, 1, 5);  -- id: 10
INSERT INTO product_basket (product_id, amount, order_id) VALUES (10, 2, 5);  -- id: 11
INSERT INTO product_basket (product_id, amount, order_id) VALUES (12, 1, 5);  -- id: 12
INSERT INTO product_basket (product_id, amount, order_id) VALUES (11, 3, 5);  -- id: 13

-- fill tags
INSERT INTO tags (name) VALUES ('cheap');
INSERT INTO tags (name) VALUES ('boy');
INSERT INTO tags (name) VALUES ('present');
INSERT INTO tags (name) VALUES ('girl');

-- fill product_tags
INSERT INTO product_tags (product_id, tag_id) VALUES (1, 4);
INSERT INTO product_tags (product_id, tag_id) VALUES (1, 2);
INSERT INTO product_tags (product_id, tag_id) VALUES (2, 1);
INSERT INTO product_tags (product_id, tag_id) VALUES (2, 3);
