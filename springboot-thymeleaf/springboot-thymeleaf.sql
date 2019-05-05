drop database if exists `test`;
create database `test`;
use `test`;

drop table if exists `product`;
create table `product` (
  `id` int(10),
  `name` varchar(200),
  `price` float(20),
  primary key(`id`)
);

insert into product values(1, "product1", 100);
insert into product values(2, "product2", 200);
insert into product values(3, "product3", 300);
insert into product values(4, "product4", 400);
insert into product values(5, "product5", 500);