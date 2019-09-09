INSERT INTO `database`.store (id, store_name)
VALUES (1, 'ClothesStore');
INSERT INTO `database`.store (id, store_name)
VALUES (2, 'ElectroStore');

INSERT INTO `database`.category (id, category_title, store_id)
VALUES (1, 'dresses', 1);
INSERT INTO `database`.category (id, category_title, store_id)
VALUES (2, 'footwear', 1);
INSERT INTO `database`.category (id, category_title, store_id)
VALUES (3, 'video products', 2);
INSERT INTO `database`.category (id, category_title, store_id)
VALUES (4, 'music products', 2);

INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (100, 'Dress Red', 100, 'available', 1);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (200, 'Dress Yellow', 800, 'available', 1);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (300, 'Dress Black', 1000, 'available', 1);

INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (400, 'Adidas', 1000, 'available', 2);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (500, 'Nike', 800, 'available', 2);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (600, 'Puma', 700, 'available', 2);

INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (700, 'MacBook Pro 13', 10000, 'available', 3);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (800, 'Sony', 7000, 'available', 3);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (900, 'Huawei', 2000, 'available', 3);

INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (111, 'Music Player', 200, 'available', 4);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (112, 'Headphones', 100, 'available', 4);
INSERT INTO `database`.product (id, products_title, price, status, category_id)
VALUES (113, 'Music Disk', 70, 'available', 4);

