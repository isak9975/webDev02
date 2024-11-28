drop database if  exists mydb1202; 
create database mydb1202;
use mydb1202;

#[1]
create table table1(mno_pk int, 
					primary key(mno_pk));

drop table table2;
create table table2(bno_pk int, 
					mno_fk int, 
					primary key(bno_pk),
                    foreign key(mno_fk) references table1(mno_pk));
                    
# [2] 카테고리별 제품의 재고 테이블 DB 구축, + 제약 조건 옵션
create table pcategory( #  카테고리 테이블
	카테고리번호_pk int unsigned auto_increment , 
    # 속성(필드) 임의, int (식별키숫자), unsigned (부호없음)
    카테고리명 varchar(10), # 속성(필드) 임의, varchar(10) : 카테고리명 최대 10글자 이내로 작성하기 위해서
    primary key( 카테고리번호_pk) #pk필드 선언하기, primary key(pk필드명)
);

#제품 테이블
create table product(
	제품번호_pk int unsigned auto_increment,
    제품명 varchar(100), # 제품명을 최대 100 글자 이내로 작성하기 위해서
    제품가격 int unsigned not null, # 40억 이하로 가격을 작성하기 위해서 + 음수 없음 ,not null : 공백이 아닌 필드    
    카테고리번호_fk int unsigned,
    primary key (제품번호_pk), # pk  필드 선언하기 # pk 필드는 자동으로 not null 과 unique(중복방지) 제약조건이 설정된다.
    foreign key (카테고리번호_fk) references pcategory(카테고리번호_pk)
);

 #입고 테이블
 create table stop(
	재고번호_pk int unsigned,
	재고수량 int, #음수 처리가 가능한 숫자 타입 사용
    재고등록날짜 date default now(), # date(날짜타입), default : 레코드삽입시 초기값을 선언하기 now() : 현재 시스템 날짜 반환
    제품번호_fk int unsigned,
    primary key(재고번호_pk), # 모든 테이블은 pk필드를 1개 이상 갖는다.
	foreign key(제품번호_fk) references product(제품번호_pk) # fk 필드 설정하기
 );