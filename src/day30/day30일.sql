# 데이터베이스 생성
create database mydb1125; #데이터 베이스 생성
show databases; #데이터베이스 목록 보기

#[ TABLE ]
use mydb1125;
drop table ir exists board;			#만일 지정한 테이블이 존재하면 테이블 삭제
create table board(
num int unsigned auto_increment, 	#게시물의 번호, int 이용한 정수를 저장할 수 있다., unsigned(부호없음)
									#auto_increment : 레코드 추가/ 상ㅂ입 할경우 필드의 자동 번호를 부여 한다.
content longtext, 					#게시물의 내용, longtext 이용한 최대 4G 까지 저장할 수 있다.
writer varchar(100) not null,  		#게시물의 작성자, varchar(100) 이용한 최대 100글자 까지 저장할 수 있다. not null(빈칸없음)
pwd int, 							#게시물의 비밀번호, int 이용한 정수를 저장할수 있다.
primary key(num) 					#게시물의 번호를 식별자(PK) 선정
);
show tables;						#모든 테이블 목록 보기

#[게시물 등록 샘플 SQL]
 #insert : insert into 테이블명(필드명1,필드명2,필드명3) values(값1, 값2, 값3)
 #insert into board(content, writer, pwd) values('안녕하세요','유재석',1234); #SQL 작성
 #insert into board(content,writer,pwd) values(?,?,?); #JDBC 에서 SQL작성
 
 select*from board;					#테이블의 내용 보기
 delete from board where num >0 ; 	#내용 전부 지우기 #ALL clear