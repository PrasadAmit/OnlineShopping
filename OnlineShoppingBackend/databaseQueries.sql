CREATE TABLE `spgdb`.`category` (

`id` INT  NOT NULL  AUTO_INCREMENT,
  `name` VARCHAR(45) ,
  `description` VARCHAR(255),
  `image_url` VARCHAR(45) ,
  `is_active` BOOLEAN ,
   CONSTRAINT pk_category_id  PRIMARY KEY (id)  
  );


CREATE TABLE `spgdb`.`product` (

`id` INT NOT NULL AUTO_INCREMENT,
`code` VARCHAR(20) ,
`name` VARCHAR(45) ,
`brand` VARCHAR(45) ,
`description` VARCHAR(255),
`unit_price` DECIMAL(10,2),
`quantity` INT,
`is_active` BOOLEAN,
`category_id` INT,
`supplier_id` INT,
`purchases` INT DEFAULT 0,
`views` INT DEFAULT 0,

CONSTRAINT pk_product_id  PRIMARY KEY (id),
CONSTRAINT fk_product_category_id  FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id  FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

CREATE TABLE `spgdb`.`user_detail` (

`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) ,
`last_name` VARCHAR(45) ,
`role` VARCHAR(45) ,
`enabled` BOOLEAN,
`password` VARCHAR(45) ,
`email` VARCHAR(45) ,
`contact_number` VARCHAR(45) ,
  CONSTRAINT pk_user_id  PRIMARY KEY (id)   
);


CREATE TABLE `spgdb`.`address`(
`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT,
`address_line_one` VARCHAR(100),
`address_line_two` VARCHAR(100),
`city` VARCHAR(20),
`state` VARCHAR(20),
`country` VARCHAR(20),
`postal_code` VARCHAR(10),
`is_billing` BOOLEAN,
`is_shipping` BOOLEAN,

CONSTRAINT pk_address_id PRIMARY KEY(id),
CONSTRAINT fk_address_user_id FOREIGN KEY(user_id) REFERENCES user_detail(id)
);

CREATE TABLE `spgdb`.`cart`(
`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT,
`grant_total` DECIMAL(10, 2),
`cart_lines` INT,

CONSTRAINT pk_cart_id PRIMARY KEY(id),
CONSTRAINT fk_cart_user_id FOREIGN KEY(user_id) REFERENCES user_detail(id)
);

CREATE TABLE `spgdb`.`cart_line` (

`id` INT NOT NULL AUTO_INCREMENT,
`cart_id` INT,
`total` DECIMAL(10,2),
`product_id` INT,
`product_count` INT,
`buying_price` DECIMAL(10,2),
`is_available` BOOLEAN,

CONSTRAINT pk_cartline_id PRIMARY KEY(id),
CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart(id),
CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product(id)

);

INSERT INTO spgdb.product values(1,'PROABC123DEX', 'iPhone I5','apple','This is latest iPhone',20000,5,1,1,2,0,0);
INSERT INTO spgdb.product values(2,'PROCDE123MNX', 'Galexy G5','samsung','This is latest samsung',21000,2,1,3,1,0,0);
INSERT INTO spgdb.product values(3,'PROGHE456GNY', 'Macbook M1','samsung','This is latest samsung',98000,5,1,2,1,0,0);
INSERT INTO spgdb.product values(4,'PROFGH123JAK', 'NOKIA  N5','nokia','This is latest nokia',22000,5,1,4,3,0,0);
INSERT INTO spgdb.product values(5,'PROHEX123XBH', 'MOTOROLA M1','motorola','This is motorala',23000,1,1,2,3,0,0);
INSERT INTO spgdb.product values(6,'PROKHL498ZXC', 'SONY S5','samsung','This is latest samsung',29000,2,1,4,1,0,0);
INSERT INTO spgdb.product values(7,'PROHIL123TAX', 'KARBON K2','karbon','This is latest karbon',24000,5,1,3,2,0,0);
INSERT INTO spgdb.product values(8,'PROKIL123MAX', 'UNIX  U3','unix','This is latest unix',25000,4,1,4,1,0,0);
INSERT INTO spgdb.product values(9,'PROGHE456GNY', 'DELL D9','samsung','This is latest samsung',59000,2,1,3,1,0,0);
INSERT INTO spgdb.product values(10,'PROMNO123ZEN', 'REDMI R1','redmi','This is latest redmi',26000,6,1,1,2,0,0);
INSERT INTO spgdb.product values(11,'PROPDC123XYZ', 'SONY S4','sony','This is latest sony',27000,5,1,1,3,0,0);
INSERT INTO spgdb.product values(12,'PROGHE456GNY', 'SAMSUNG BIO','samsung','This is latest samsung',45000,2,1,3,1,0,0);

INSERT INTO spgdb.user_detail values(1, 'virat', 'kohli', 'Admin', true, 'admin', 'vk@gmail.com', '7777777777');
INSERT INTO spgdb.user_detail values(2, 'mahi', 'dhoni', 'Caption', true, 'abc123', 'md@gmail.com', '8888888888');
INSERT INTO spgdb.user_detail values(3, 'rohit', 'sharma', 'supplier', true, '12345', 'rs@gmail.com','9999999999');

INSERT INTO hbnetdb.category(name, description, image_url, is_active) values('Laptop', 'This is Laptop', CAt_1.png, 1);
INSERT INTO hbnetdb.category(name, description, image_url, is_active) values('Radio', 'This is Radio', Cat_2.png, 1);
INSERT INTO hbnetdb.category(name, description, image_url, is_active) values('TV', 'This is Television', Cat_3.png, 1);
INSERT INTO hbnetdb.category(name, description, image_url, is_active) values('Mobile', 'This is Mobile', Cat_4.png, 1);
