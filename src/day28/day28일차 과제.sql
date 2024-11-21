drop database if exists shoppingmall;
create database shoppingmall;
use shoppingmall;
create table 카테고리(
	카테고리번호 int unsigned not null, #카테고리 번호는 음수가 없는 그리 크지 않는 정수를 사용하기에 int unsigned를 사용
    카테고리명 varchar(50), #카테고리명은 넉넉한 이름으로 varchar을 사용 
    primary key(카테고리번호)); #카테고리명을 PK로 사용
    
create table 제품(
	라면번호 int unsigned not null, #제품번호는 음수가 없고 비울수 없는 unsigned not null 사용
    라면이름 varchar(30) unique, #제품명은 적당히 길고 중복이 없는 varchar(30) unique사용
    가격 int unsigned , #가격은 음수가 없는 정수인 int unsigned 사용
    카테고리번호 int unsigned not null, #카테고리 번호는 카테고리table에 있는 것을 그대로 사용(FK)
    primary key(라면번호), #제품번호를 PK로 사용
    foreign key(카테고리번호)references 카테고리(카테고리번호));

create table 회원(
	회원번호 int unsigned not null auto_increment, #회원번호는 음수가 없는 정수에 자동으로 생성되게 제한 
    아이디 varchar(30) unique, #제품명은 적당히 길고 중복이 없는 varchar(30) unique 사용
    비밀번호 varchar(30), #비밀번호는 적당히 긴 varchar(30)을 사용
    주소 varchar(100), #주소는 생각보다 길 수 있으니까 여지를 많이 줬음
    primary key(회원번호) #회원번호를 PK로 사용
    );
    
create table 장바구니(
	주문번호 int unsigned,
    첫번째제품번호 int unsigned not null,
    첫번째주문수량 int unsigned,
    두번째제품번호 int unsigned not null,
    두번째주문수량 int unsigned,
    primary key(주문번호),
    foreign key(첫번째제품번호)references 제품(라면번호),
    foreign key(두번째제품번호)references 제품(라면번호)
    );
    
create table 주문(
주문상세번호 int unsigned,
주문번호 int unsigned,
-- 회원번호 int unsigned auto_increment,
-- 첫번째제품번호 int unsigned,
-- 첫번째제품수량 int unsigned,
-- 두번째제품번호 int unsigned,
-- 두번째제품수량 int unsigned,
-- 주소 varchar(100),
primary key(주문상세번호),
foreign key(주문번호)references 장바구니(주문번호)
-- foreign key(회원번호)references 회원(회원번호),
-- foreign key(첫번째제품번호)references 제품(라면번호),
-- foreign key(첫번째제품수량)references 장바구니(첫번째주문수량),
-- foreign key(두번째제품번호)references 제품(라면번호),
-- foreign key(두번째제품수량)references 장바구니(첫번째주문수량)
);