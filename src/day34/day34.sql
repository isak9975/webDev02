#1. 실습 하기 위한 db생성
create database mydb1203;
#2. 실습 db 사용
use mydb1203;

#1. A테이블
create table table1(num int, 	#PK필드, int형 자료를 저장하는 필드
					primary key(num));
#2. B테이블
drop table table2;

create table table2(no int, 	#PK필드, int형 자료를 저장하는 필드
					num int,  	#FK필드, int형 자료를 저장하는 필드
					primary key(no), 
					foreign key(num) references table1(num));
                    
#3. 레코드(샘플), insert into 테이블명 values (값1), (값2), (값3)
insert into table1 values (1), (2), (3), (4), (5);
insert into table2 values(1,1) ,(2,2) ,(3,1),(4,1),(5,2);

#4. 확인
select*from table1;
select*from table2;

#PK 필드 : 식별키, 식별필드, 중복없음, NOT NULL, 고유한 성질을 가진 필드, 상하관계에 있어서 상PK), 예] 카테고리(카테테고리PK)
#FK 필드 : 참조키, 참조필드, 중복가능, NULL	   , 식벽필드를 참조하는 필드, 상하관계에 있어서 하(FK), 예] 제품(카테고리FK)
	#--> 필요한 이유 : 서로 다른 테이블간의 관계를 연결(PK-FK) 하는 구조, 관계형 데이터 베이스
    #--> PK와 FK는 참조 당하고 참조를 하는 입장이므로, 교집합이 존재할수 있다.
    
#교집합 : JOIN : 서로 다른 테이블간의 교집합(동일한필드값) 찾기

#1. 하나의 테이블을 조회
select * from table1; #5행

#2. 두개 이상의 테이블 조회, select *from 테이블명A,테이블명B
select*from table1, table2; #25행

#3.두개 이상의 테이블을 조회시 두 테이블간 동일한 데이터가 일치했을때 조회
# 교집합 찾을때 주로 pk필드와 fk필드를 조건으로 설정하면 된다.
# 교집합 필요한 이유 : pk필드값을 이용한 fk필드 조회, fk필드값을 이용한 pk필드 조회
#[1]where 조건절 이용한 교집합 하기 - 잘이용안함
select*from table1, table2 where table1.num = table2.num; # 5행

#<INNER JOIN>
#[2]테이블명A inner join 테이블명B on 테이블명A.Pk필드명 = 테이블명B.fk필드명 장점 : 여러 절 과 같이 사용시 가독성 좋다.
select*from table1 inner join table2 on table1.num = table2.num; #5행

#<JOIN>
#[3]테이블명A join 테이블명B on 테이블명A.Pk필드명 = 테이블명B.fk필드명
select*from table1 join table2 on table1.num = table2.num; #5행
#<NATRUAL JOIN>
#[4]테이블명A natrual join 테이블명B; 교집합조건 없이이 자동으로 교집합조건을 표현하는 구문,
#전제 조건 : pk필드명과 fk필드명이 동일할 경우에만 가능 / 교집합할 필드명이 같아야 한다 
select*from table1 natural join table2; #5행

#Inner join과 join은 동일한 동작을 함.

#<USTING>
#[5] 테이블명A join 테이블명B using(조인필드명), 교집합 조건을 using(). 대입해서 자동 교집합
#전제 조건 : pk필드명과 fk필드명이 동일할 경우에만 가능 / 교집합할 필드명이 같아야 한다 
select*from table1  join table2 using(num); #5행

#<LEFT / RIGHT JOIN>
#[6] 테이블명A left outer join 테이블명B on 집합조건, 
#왼쪽테이블(table1) 에 있는 모든 레코드를 포함하고 오른쪽 테이블(table2)에 교집합되는 레코드를 조회
select * from table1 left outer join table2 on table1.num = table2.num;
#[7] 테이블명A right outer join 테이블명B on 집합조건, 
#오른쪽테이블(table1) 에 있는 모든 레코드를 포함하고 왼쪽 테이블(table2)에 교집합되는 레코드를 조회
select * from table1 right outer join table2 on table1.num = table2.num;

#<UNION> 합집합
#[8] left join 과 right join 두 결과의 중복된 행을 제거하고 결합(union) ,mysql 에서는  full outer join 지원하지 않는다.
select * from table1 left join table2 on table1.num=table2.num 
union
select * from table1 right join table2 on table1.num=table2.num; 
#[9] 일반적으로 left join 과 left outer join은 동일한 조인 구문, outer 를 생략해서 사용하기도 한다.
select * from table1 left join table2 on table1.num = table2.num;

#많이 씀#교집합 = inner join
select*from table1 inner join table2 on table1.num = table2.num; #5행
#많이 씀#차집합 = left join, where, is null
select table1.* from table1 left join table2 on table1.num = table2.num where table2.num is null; #
#많이 씀#합집합 = left / right join, union
select * from table1 left join table2 on table1.num=table2.num 
union
select * from table1 right join table2 on table1.num=table2.num; 


#[10] [차집합]
#A테이블에서 B테이블의 레코드를 제외한 : 테이블명A left outer 테이블명B on 집합조건 where 테이블명B.FK필드명 is null;
#B테이블에서 A테이블의 레코드를 제외한 : 테이블명A right outer 테이블명B on 집합조건 where 테이블명a.PK필드명 is null;
select * from table1 left join table2 on table1.num = table2.num; # 왼쪽 테이블의 전체와 오른쪽 테이블과 교집합
select * from table1 left join table2 on table1.num = table2.num where table2.num is null; #
select table1.* from table1 left join table2 on table1.num = table2.num where table2.num is null; #
 
 # 카테고리 테이블 
create table pcategory(
        카테고리번호_pk int unsigned auto_increment , 
    # 속성(필드) 임의 , int(식별키숫자) , unsigned(부호없다.) , auto_increment(레코드삽입시 자동번호부여)
    카테고리명 varchar(10) not null , #속성(필드) 임의 , varchar(10) : 카테고리명이 최대 10글자로 이내로 작성하기 위해서
    primary key( 카테고리번호_pk) # pk필드 선언하기 , primary key( pk필드명 ) 
);
# 제품 테이블 
create table product( 
        제품번호_pk int unsigned auto_increment , 
    제품명 varchar(100) not null, # 제품명을 최대 100 글자 이내로 작성하기 위해서 
    제품가격 int unsigned not null , # 40억 이하로 가격을 작성하고 -(음수) 없음 , not null : 공백이 아닌 필드 설정 ( 공백삽입시 오류발생 )
    카테고리번호_fk int unsigned , # 카테고리 테이블의 pk필드 를 참조할 fk필드 
    primary key( 제품번호_pk ) , # pk 필드 선언하기 # pk필드는 자동으로 not null(null방지) 과 unique(중복방지) 제약조건이 설정된다.
    foreign key( 카테고리번호_fk ) references pcategory( 카테고리번호_pk ) # fk 필드 설정하기 
    # foreign key( fk필드명 ) references pk테이블명( pk필드명 )
);
# 재고 테이블 
create table stock( 
        재고번호_pk int unsigned auto_increment , 
    재고수량 int ,
    재고등록날짜 datetime default now() ,  # date(날짜타입) , default : 레코드삽입시 초기값를 선언하기 , now() : 현재 시스템 날짜/시간 반환 함수 
        제품번호_fk int unsigned ,                 # 제품 테이블의 pk필드를 참조할 fk필드 
    primary key( 재고번호_pk ) ,                 # 모든 테이블은 pk필드를 1개 이상 갖는다.(권장) 
    foreign key( 제품번호_fk ) references product( 제품번호_pk ) # fk 필드 설정하기 
);

#생각해보기1 : 테이블에 레코드가 존재한다는 가정하에 생각해보기
 #day34의 (카테고리, 제품, 재고) 테이블
 #1. 모든 제품 레코드 조회시 카테고리번호 대신에 카테고리명을 조회하는 sql

select p.제품번호_pk, p.제품명, p.제품가격, c.카테고리명 from product p inner join pcategory c on p.카테고리번호_fk = c.카테고리번호_pk ;
select * from product inner join pcategory on product.카테고리번호_fk = pcategory.카테고리번호_pk ;
select *from product left join pcategory on product.카테고리번호_fk = pcategory.카테고리번호_pk ;


#생각해보기2 : 
select * from stock where 제품번호_fk =1; #1번 제품의 재고 레코드만 조회
select sum(재고수량) from stock where 제품번호_fk =1; #1번 제품의 재고수량 총 합계
select * from product p inner join stock s on p.제품번호_pk = s.제품번호_fk where 제품번호_pk =1; # 1번 제품의 레코드만 조회
select p.제품명, sum(s.제고수량) from product p inner join stock s on p.제품번호_pk = s.제품번호_fk where 제품번호_pk =1; # 1번 제품의 레코드만 조회

#생각해보기3:
	#(현재 로그인된 회원)내가 받은 쪽지만 조회하는 sql 작성하시오. / 내가 쓴글 또는 내가 받은 글
    
    select m.메시지번호_pk, m.보낸날짜, m.보낸사람, m.받은사람, m.메세지내용, m.회원번호_FK from 회원정테이블 p inner join 메세지테이블 m where p.회원 번호_PK=m.회원 번호_FK;

 






