CREATE TABLE `hbnetdb`.`category` (

`id` INT  NOT NULL  AUTO_INCREMENT,
  `name` VARCHAR(45) ,
  `description` VARCHAR(255),
  `image_url` VARCHAR(45) ,
  `is_active` BOOLEAN ,
   CONSTRAINT pk_category_id  PRIMARY KEY (id)  

  );
