/* 여러줄 주석 */
# 한줄 주석
-- 한줄 주석
/*
	[SQL 작성 또는 실행 하는 방법]
    1. SQL 문법을 작성한다. show databases				show databases
    2. SQL 문장이 끝나면 ;(세미콜론)으로 마친다.			show databases;
    3. 실행할 명령어 줄에 (마우스)커서 두고 Ctral + enter 
    4. 실행 결과는 하단에 [Result Grid]창에서 확인 가능
*/
/*
	목표 : 자바에서 데이터 베이스와 연동하여 영구적으로 저장.
*/


#[1]  db server 내 모든 테이블 확인#데이터베이스란? 표/테이블, 기본 테이블 4개의 테이블명이 출력된다
show databases; 
#[2] db server local path 확인
show variables like 'datadir';
#[3] db server 데이터베이스 생성
create database mydDBtest1;
#[4] db server 데이터베이스 삭제
drop database mydDBtest1;
drop database employees;
#[4-2] 만약에 데이터베이스가 존재 하면 삭제
drop database if exists mydDBtest1;
#[5] db server 에는 여러개 데이터베이스가 존재하므로 사용/활성화 할 데이터베이스 선택
use mydDBtest1;

#[실습1] - 아래와 같이 순서대로 SQL문을 작성하여 실행하시오
# [실습1] - 아래와 같이 순서대로 SQL문을 작성하여 실행하시오.
drop database if exists test1;		-- 1. 'test1' 이름의 데이터베이스가 존재하면 삭제하기 SQL 작성
create database test1;    			-- 2. 'test1' 이름의 데이터베이스 생성하기 SQL 작성
show databases;    					-- 3. 데이터베이스 목록 확인 SQL 작성
show variables like 'datadir'; 		-- 4. 로컬PC에 데이터베이스가 만들어졌는지 경로 확인 SQL 작성
use test1;							-- 5. 'test1' 이름의 데이터베이스 사용 활성화 하기 SQL 작성

#테이블 생성 과 타입 관련
#[1] DB 생성
create database mydb1120;
#[2] DB 활성화(사용)
use mydb1120;
#[3] 활성화된 DB내 테이블 생성
create table member(아이디 text, 패스워드 text, 이름  text);
#[4] 활성화된 DB 내 테이블 목록 보기
show tables;
#[5] 테이블 삭제
drop table member;
drop table if exists member; -- 사용 권장

/*
	[용어, 관점 차이에 따른 용어]
    파일시스템관점	모델링관점		관계형관점
    파일			엔티티		테이블,릴레이션
    레코드		튜플			행
    필드			속성			열
    1.테이블(table) : 표, 릴레이션 (Relation), 엔티티(Entity)
    2.레코드(Recode) : 튜플(tuple), 행(row), 가로 1줄 단위
    3. 필드(Field) : 속성(Attribute), 열(column), 세로 1줄 단위
    
    [테이블 생성시 필드(데이터 타입) = JAVA의 데이터 타입 역활이 같다 oravle vs mysql]
	[정수]
		TINYINT		1바이트	-128~127
        SMALLINT	2바이트	+-3만정도
        MEDIUMINT	3바이트	+-800만정도	
        INT			4바이트	+-21억정도
        BIGINT		8바이트	+-억 이상
        
	[실수 = 부동소수점 , 오차존재]
		FOLAT
        DBOULE
	[문자타입으로 저장되는 숫자, 오차없는 실수 표현]
		DECIMAL
    [날짜]
		DATE		 날짜표현,(1000년~999년), 0000-00-00
        DATETIME	 날짜 외 시간 표현, 0000-00-00 00:00:00	
        TIME		 시간 표현, 00:00:00
	[문자열]
		1. CHAR(문자길이) 	: 고정길이, 최대 1~255글자
        2. VARCHAR(문자길이)  : 가변길이, 최대 1~255글자
        3. TEXT				: 최대길이 6만개 글자 표현
        4. LONGTEXT 		: 푀대길이 42억개 글자 표현(4GB)
	[논리]
		1. BOOL : true 혹은 false 표현, 실제로는 0또는 1로 표현한다.
    
*/
#테이블 예제1
use mydb1120;
# 게시물 테이블
#1. 게시물의 내용물은 많은 양의 데이터를 저장할 예정이라서 longtext 타입 선택하고 속성명은 ctontent
#2. 게시물의 작성자는 아이디 이므로 적당한 길이 최대 30글자로 받을 예정 이라서 carchar(30) 가변길이의 타입속성을 선택하고, 속성명은 wrtier
#3. 게시물의 비밀번호는 숫자로 받을 예정이라서 적당한 정수 타입의 int 타입 속석 선택하고 속성명은 pwd
create table board(content longtext , writer varchar(300), pwd int);
show tables;
#테이블의 내용물/레코드 확인
select*from board; #테ㅣ블은 존재하지만 아직 데이터가 없다.
drop table if exists board;

#테이블 예제2
drop database if exists mydb1120; #1. 데이터베이스가 존재하면 삭제
create database mydb1120; 		  #2. 데이터베이스 생성
show databases;					  #3. 데이터베이스 목록
use mydb1120;	  				  #4. 데이터베이스 활성화/사용
drop table if exists member;
#6. 데이터 생성 : 테이블명(속성명 속성타입,속성명 속성타입, 속성명, 속성타입)
create table member(
	정수필드1 tinyint,
    정수필드2 smallint,
    정수필드3 mediumint,
    정수필드4 int,
    정수필드5 bigint,
    실수필드1 float, 
    실수필드2 double,
    실수필드3 decimal,
    날짜필드1 date,
    날짜필드2 datetime,
    시간필드 time,
    문자열필드1 char(100),
    문자열필드2 varchar(100),
    문자열필드3 text, 
    문자열필드4 longtext,
    논리필드 bool); #마지막에는 쉼표 넣지 않는다
    show tables;#7. 테이블 목록 보기
    select*from member; #8. 지정한 테이블의 레코드 없기 때문 현재 레코드가 없고 테이블만 생성된 상태