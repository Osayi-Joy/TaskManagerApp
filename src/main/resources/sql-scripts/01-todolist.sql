CREATE SCHEMA IF NOT EXISTS `todolist`;
USE `todolist`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(64) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES
	(1,'john.williams@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'John', 'Williams'),
	(2,'james.smith@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'James', 'Smith'),
	(3,'jacob.brown@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'Jacob', 'Brown');

UNLOCK TABLES;

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `due_date` DATE NOT NULL,
  `priority` VARCHAR(20) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  
  ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `items` WRITE;

INSERT INTO `items` VALUES
	(1, 'SQL script for User', '2022-05-07', 'MEDIUM', 'DONE', 1),
	(2, 'User entity', '2022-05-08', 'HIGH', 'DONE', 1),
	(3, 'Security logic', '2022-05-09', 'CRITICAL', 'DONE', 1),
	(4, 'User Controller', '2022-05-10', 'HIGH', 'DONE', 1),
	(5, 'Registration', '2022-05-11', 'HIGH', 'DONE', 1),
	(6, 'Login', '2022-05-11', 'HIGH', 'DONE', 1),
	(7, 'Item entity', '2022-05-11', 'CRITICAL', 'DOING', 1),
    (8, 'SQL script for Item', '2022-05-13', 'MEDIUM', 'DOING', 1),
    (9, 'Item Controller', '2022-05-13', 'CRITICAL', 'DOING', 1),
    (10, 'List HTML file', '2022-05-15', 'HIGH', 'TODO', 1),
    (11, 'CRUD operations', '2022-05-16', 'CRITICAL', 'TODO', 1),
    (12, 'Drag and Drop', '2022-05-16', 'MEDIUM', 'TODO', 1),
    (13, 'Archive', '2022-05-16', 'MEDIUM', 'TODO', 1),
    (14, 'Unique E-mails', '2022-05-17', 'MINOR', 'TODO', 1),
    (15, 'Testing', '2022-05-18', 'CRITICAL', 'TODO', 1);

UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 0;