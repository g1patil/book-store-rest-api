DROP TABLE IF EXISTS `book`;

CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `author_name`  varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
);

insert into book values (1,'test book 1','jivan patil 1');
insert into book values (2,'test book 2','jivan patil 2');
insert into book values (3,'test book 3','jivan patil 3');


CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `invoice_id` bigint(19) unsigned NOT NULL,
  `amount` decimal(19,2) unsigned NOT NULL,
  `user_id` bigint(19) unsigned NOT NULL,
  `item_count` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `book_inventory` (
  `book_id` bigint(19) unsigned NOT NULL ,
  `stock_count` int(10) unsigned
);

insert into book_inventory values (1,10);
insert into book_inventory values (2,11);
insert into book_inventory values (3,12);