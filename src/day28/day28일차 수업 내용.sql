/* [day28]
/* 여러 줄 주석
# 한줄 주석
-- 한줄 주석
*/
# [명령어 실행]
# [1] Ctrl + 엔터 = 실행할 명령어에 커서를 두고 단위 실행( 번개 모양 )
# [2] Ctrl + Arlt + 엔터 = .sql 파일의 존재하는 모든 명령어 실행(번개 모양)

#[ SQL ]
/*
	1. show databases; : db server 내 모든 데이터베이스를 확인
    2. show variaveles like 'datadir; 		: db server local path 확인
	3. create database 새로운베이스명 			: db.server 내 db 생성 
    4. drp database 삭제할 데이터 비이스 명		: db werver내 dbㄴ삭제
		drop database if exisis 삭제할 데이터 베이스명 : 만일 존하면 삭제alter5
	5. /user  사용할 데이터베이스 		         :(db server 내 여러 db중에 사용 가능)
    6. create table 데이블명( 속성명 타입, 속성명 타입, 속성명 타입); : 활성화된 db에서 테이블 / 표 생성한다.
    7. drp table 테이블명		: 활성화된 db에서 테이블 삭제
			-drop table if exists 테이블명 : 만일 테이블이 존재하면 삭제
    8. show tables		: 활성화된 db내 모든 테이블 활용 가능
    
    [ 데이터 타입 ] : 테이블 생성시 필드/속성의 테이터 타입
		[정수]	TINYINT, SMALLINT, MEDIUMINT, INT, BIGSIN
        [실수]	FLOAT, DOUBLE, DECIMAL
        [문자]   CHAR(), VARCHAR()
        [날짜/시간] DATETIME, TIME, DATE
        [논리] BOOL
        
*/

#-------------------------------------------------------------------------------------------------------
#[제약 조건]
	#1. not null : 해당 필드에 null 값을 포함하지 않는다.
    #2. default : 해당 필드에 레코드(값) 삽입시 비어 있는경우 기본값을 지정한다.
    #3. unique : 해당 필드에 중복된 값을 허용하지 않는다. [ 중복제거ㅏ ] 레코드 삽입시 데이터가 중복이면 오류발생
    #4. auto_increment : 해당 필드에 레코드 삽입시 자동으로, 순서대로 번호가 자동 삽입된다.(Oracle 에는 없음)
    #5. primary key : 테이블의 식별필드 , (기본키-PK), 식별 가능한 고유 값 가진 키, 참조 당하는 키, 참조 하는 키
		#primary key(pk필드명)
    #6. foreign key : 테이블의 참조필드, (참조키-FK), 다른 테이블내 기본키를 참조 하는 키, 참조 당하는 키 
		#foreign key(fk필드명) reference 참조테이블명(참조테이블의 pk필드명)
    # 관례적으로 모든 테이블은 1개 이상의 pk필드를 갖는다.

#회원제 게시판 ( 회원테이블, 게시판 테이블 = 종속관계 파악, [o]회원(상위PK)이 게시물(하위FK) 작성 VS [x]게시물이 회원을 작성)
create table 회원테이블(
	회원번호 int unsigned not null auto_increment,		-- 회원번호는 일반적으로 가입순서대로 1~ 저장하기 위해서 int 사용했다.
		-- unsigned : [부호가 없다는 뜻] 음수를 사용하지 않고 음수를 사용할 데이터 만큼 양수 사용. #int(+-21억) int unsigned(42억)
    아이디 varchar(30) unique,	-- 아이디는 최대 30글자만 입력받을 예정이라서 varchar(30)을 사용함.
    비밀번호 varchar(30), -- 비밀번호는 최대 20글자만 입력받을 예정이라서 varchar(30)을 사용함.
    연락처 char(13),	-- 010-0000-0000 형식으로 받을 예정 이라서 char(13)
    광고전송여부 boolean default 0, -- true or false 형식을 사용할 거라서 boolean 사용.
    가입일 datetime,-- 가입일은 날짜와 시간을 같이(2024-11-21 20:05:11) 사용할거라 datetime 타입을 사용함.
    primary key(회원번호) -- 지정한 필드를 PK(기본키)로 사용 하겠다. 아이디 대신에 회원번호를 사용한 이유 .1용량이 작다 2.중복배제
);#임의 테이블 생성, create table 테이블명(필으명 타입, 필드명 타입);

create table 게시물테이블(
	게시물번호  int unsigned not null auto_increment , -- 게시물 번호는 일반적으로 작성순서대로 1~ 저장하기 때문에 int  unsigned 했다.
    게시물제목 varchar(100), --  게시물제목은 적당하게 최대100글자로 하기 위해서 varchar(100) 했다.
    게시물내용 longtext, -- 게시물내용은 많은 데이터를 저장하기 위해서 큰 용량인(4GB) longtext를 사용했다.
    게시물작성자 int not null,  -- 게시물작성자가 아이디가 아니고 회원번호인 이유는 :회원번호를 통해 아이디 를 참조 할 수 있다.
			-- 예] 동사무소에 가면 주민등록번호(식별키) 만 말해도 신상정보를 직원이 볼수 있기때문
	foreign key(게시물작성자회원번호)references 회원테이블 (회원번호),
	primary key(게시물번호)
);