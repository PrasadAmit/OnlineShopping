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
