
1. you need to set you database information in Dao.BaseDao firstly;

And then use following sql sentences build database;


create database 2048Game;
use 2048Game;

CREATE TABLE `2048Game`.`scores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `score` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


CREATE TABLE `2048Game`.`games` (
  `zero_zero` INT NULL,
  `zero_one` INT NULL,
  `zero_two` INT NULL,
  `zero_three` INT NULL,
  `one_zero` INT NULL,
  `one_one` INT NULL,
  `one_two` INT NULL,
  `one_three` INT NULL,
  `two_zero` INT NULL,
  `two_one` INT NULL,
  `two_two` INT NULL,
  `two_three` INT NULL,
  `three_zero` INT NULL,
  `three_one` INT NULL,
  `three_two` INT NULL,
  `three_three` INT NULL);



2. After finishing above steps,
you can run project from Start.java




