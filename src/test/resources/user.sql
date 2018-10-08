CREATE DATABASE test;

CREATE TABLE `user` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) DEFAULT NULL,
  `password` VARCHAR(30) DEFAULT NULL,
  `salt` VARCHAR(30) DEFAULT NULL,
  `name` VARCHAR(10) DEFAULT NULL,
  `create_time` VARCHAR(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

SET @uuid=UUID();
INSERT INTO `user` (username,`password`,salt,`name`,create_time) VALUE ('0001@qq.com',MD5(CONCAT('51329751',@uuid)),@uuid,'Abigail','2018-10-08 21:34:26');
SET @uuid=UUID();
INSERT INTO `user` (username,`password`,salt,`name`,create_time) VALUE ('0002@qq.com',MD5(CONCAT('74254752',@uuid)),@uuid,'Beatrice','2018-10-09 19:34:26');
SET @uuid=UUID();
INSERT INTO `user` (username,`password`,salt,`name`,create_time) VALUE ('0003@qq.com',MD5(CONCAT('37582378',@uuid)),@uuid,'Carmelita','2018-10-10 16:34:26');
SET @uuid=UUID();
INSERT INTO `user` (username,`password`,salt,`name`,create_time) VALUE ('0004@qq.com',MD5(CONCAT('72585783',@uuid)),@uuid,'Deanna','2018-10-11 14:34:26');
SET @uuid=UUID();
INSERT INTO `user` (username,`password`,salt,`name`,create_time) VALUE ('0005@qq.com',MD5(CONCAT('27893783',@uuid)),@uuid,'Elena','2018-10-12 09:34:26');