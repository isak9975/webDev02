drop database if exists megacoffee;
create database megacoffee;
use megacoffee;
create table MENU(
	카테고리명 varchar(100), 제품명 varchar(100), 가격 int);
create table ODER(
	주문날짜 datetime, 주문수량 tinyint, 대기번호 int);
show tables;
select*from menu;
select*from oder;