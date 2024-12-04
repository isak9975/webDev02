#=====================================================================================================
#https://docs.google.com/spreadsheets/d/1EFeasgQd7l6JQgpN_U2y4pDYNO9OKaHLpOOz8PPP6U0/edit?usp=sharing
#1. 미니 프로젝트 ~16일까지
#2. 다음주 HTML/CSS/JS 순서대로 수업 진행
#======================================================================================================

create database mydb1204;
use mydb1204;

# 회원 테이블
create table member (
    u_number int unsigned auto_increment, # 회원 번호
    u_id varchar(20) not null, # 회원 id
    u_pw varchar(10) not null, # 회원 비번
    u_name varchar(10) not null, # 회원 이름
    u_add varchar(100), # 회원 주소 
    u_email varchar(50), # 회원 이메일 
    u_phone int not null, # 회원 전화번호 
    u_birth date not null, # 회원 생일 
    primary key( u_number ) # 기본 키 설정
);


# 영화 테이블
create table movie(
   mv_id int unsigned auto_increment, #영화번호 
   mv_name varchar(50) not null, #영화제목
   mv_director varchar(50) not null, #감독
   mv_genre varchar(50) not null, #장르 
   mv_class int not null, #등급 (숫자 표시가 메모리 덜 잡아먹을 것 같아서)
   mv_time time not null, #러닝타임
   mv_detal text, #영화 설명 (설명이 길어질 경우 고려)
   mv_date date, #개봉날짜
   mv_actor text, #출연진 (다수 출연 경우 고려)
   mv_startdate date, #등록일
   primary key(mv_id) # 기본 키 설정
);

 # 리뷰 테이블
create table review (
    rv_id int unsigned auto_increment, # 리뷰 ID (기본 키)
    rv_mvid int unsigned not NULL, # 영화 번호
    rv_date date not null, # 리뷰 날짜
    rv_star int not null check (rv_star between 1 and 5), # 평점 (1~5점)
    rv_content varchar(200) not null, # 리뷰 내용 (길이 제한 제거)
    rv_member int unsigned not null, # 회원 번호 (외래 키)
    rv_suggestion boolean, # 추천 여부 (참/거짓)
    primary key (rv_id), # 기본 키 설정
    foreign key (rv_mvid) references movie(mv_id), # 영화 번호 참조
    foreign key (rv_member) references member(u_number) # 회원 테이블 참조
);

show tables;