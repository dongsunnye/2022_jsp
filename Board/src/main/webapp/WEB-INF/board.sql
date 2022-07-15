--게시판DB
--회원 등급테이블
CREATE TABLE GRADE(
    GRADE_NO NUMBER(1) PRIMARY KEY,
    GRADE_NAME VARCHAR2(20 BYTE)
);
--회원 테이블
--아이디, 암호, 이름, 닉네임, 회원등급
CREATE TABLE BOARD_MEMBER(
    ID VARCHAR2(30 BYTE) PRIMARY KEY,
    PASSWD VARCHAR2(50 BYTE),
    NAME VARCHAR2(30 BYTE),
    NICK VARCHAR2(30 BYTE),
    GRADE_NO NUMBER(1)
);
ALTER TABLE BOARD_MEMBER ADD CONSTRAINT FK_GRADE_NO FOREIGN KEY(GRADE_NO)
REFERENCES GRADE(GRADE_NO) ON DELETE SET NULL;

--게시판 테이블
--글번호, 제목, 작성자, 작성일, 조회수, 내용
CREATE TABLE BOARD(
    BNO NUMBER PRIMARY KEY,
    TITLE VARCHAR2(60 BYTE),
    WRITER VARCHAR2(30 BYTE),
    BDATE DATE DEFAULT SYSDATE,
    BCOUNT NUMBER,
    CONTENT VARCHAR2(1000 BYTE),
    CONSTRAINT FK_WRITER FOREIGN KEY(WRITER) REFERENCES BOARD_MEMBER(ID)
);
alter table BOARD drop constraint FK_WRITER;
alter table BOARD add constraint FK_WRITER 
FOREIGN KEY(WRITER) REFERENCES BOARD_MEMBER(ID) on delete cascade;

--글번호 시퀸스
CREATE SEQUENCE BOARD_BNO START WITH 1 NOMAXVALUE;

--좋아요 테이블
--게시글 번호, 회원아이디
CREATE TABLE BOARD_LIKE(
    BNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_LIKE_PK PRIMARY KEY(BNO, ID),
    CONSTRAINT BOARD_LIKE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_LIKE_BNO_FK FOREIGN KEY(BNO) REFERENCES BOARD(BNO)
);
alter table BOARD_LIKE drop constraint BOARD_LIKE_ID_FK;
alter table BOARD_LIKE drop constraint BOARD_LIKE_BNO_FK;
alter table BOARD_LIKE add CONSTRAINT BOARD_LIKE_ID_FK FOREIGN KEY(ID)
REFERENCES BOARD_MEMBER(ID) on delete cascade;
alter table BOARD_LIKE add CONSTRAINT BOARD_LIKE_BNO_FK FOREIGN KEY(BNO)
REFERENCES BOARD(BNO) on delete cascade;
--싫어요 테이블
--게시글 번호, 회원아이디
CREATE TABLE BOARD_HATE(
    BNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_HATE_PK PRIMARY KEY(BNO, ID),
    CONSTRAINT BOARD_HATE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_HATE_BNO_FK FOREIGN KEY(BNO) REFERENCES BOARD(BNO)
); 
--제약조건 수정
alter table BOARD_HATE drop constraint BOARD_HATE_ID_FK;
alter table BOARD_HATE drop constraint BOARD_HATE_BNO_FK;
alter table BOARD_HATE add CONSTRAINT BOARD_HATE_ID_FK FOREIGN KEY(ID)
REFERENCES BOARD_MEMBER(ID) on delete cascade;
alter table BOARD_HATE add CONSTRAINT BOARD_HATE_BNO_FK FOREIGN KEY(BNO)
REFERENCES BOARD(BNO) on delete cascade;
--댓글 테이블
--댓글번호, 작성자, 내용, 작성시간, 게시글번호
CREATE TABLE BOARD_COMMENT(
    CNO NUMBER PRIMARY KEY,
    CONTETNT VARCHAR2(500 BYTE),
    CDATE DATE DEFAULT SYSDATE,
    BNO NUMBER,
    WRITER VARCHAR2(30 BYTE)
);
--외래키
alter table board_comment add constraint board_comment_fk 
foreign key(writer) references board_member(id);

--댓글 번호 시퀸스
create sequence board_comment_cno start with 1 nomaxvalue;

insert into board_comment(cno,contetnt,bno,writer) values(board_comment_cno.nextval,'댓글내용',
83,'A0001');


--댓글 좋아요 테이블
--댓글 번호, 회원아이디
CREATE TABLE BOARD_COMMENT_LIKE(
    CNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_COMMENT_LIKE_PK PRIMARY KEY(CNO, ID),
    CONSTRAINT BOARD_COMMENT_LIKE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_COMMENT_LIKE_CNO_FK FOREIGN KEY(CNO) REFERENCES BOARD_COMMENT(CNO)
);
--댓글 싫어요 테이블
--댓글 번호, 회원아이디
CREATE TABLE BOARD_COMMENT_HATE(
    CNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_COMMENT_HATE_PK PRIMARY KEY(CNO, ID),
    CONSTRAINT BOARD_COMMENT_HATE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_COMMENT_HATE_CNO_FK FOREIGN KEY(CNO) REFERENCES BOARD_COMMENT(CNO)
);


--로그인
select * from board_member, grade where  grade.grade_no = board_member.grade_no ;

--게시글 목록 조회
--글번호, 제목, 작성자, 닉네임, 조회수, 작성일, 좋아요, 싫어요
select b.bno, b.title, b.writer, bm.nick, b.bcount, b.bdate,
(select count(*) from board_like bl where bl.bno = b.bno) as blike,
(select count(*) from board_hate bh where bh.bno = b.bno) as bhate
from board b, board_member bm
where b.writer = bm.id order by bno desc;

create or replace view board_view
as 
select b.bno, b.title, b.writer, bm.nick, b.bcount, b.bdate,
(select count(*) from board_like bl where bl.bno = b.bno) as blike,
(select count(*) from board_hate bh where bh.bno = b.bno) as bhate,
content
from board b, board_member bm
where b.writer = bm.id order by bno desc;

select * from (select ceil(rownum / 15) as pageNo, b.* from board_view b)
where pageNo = 1;

select * from board_view where bno = 23;

--전체 게시글 개수
select count(*) from board_view;
--게시글 등록
insert into board(bno, title, writer, content, bcount) 
values(board_bno.nextval,'제목','A0001','내용',0);

insert into board(bno, title, writer, content, bcount) values(board_bno.nextval,?,?,?,0);

select b.bno, b.title, b.writer, bm.nick, b.bcount, b.bdate,
(select count(*) from board_like bl where bl.bno = b.bno) as blike,
(select count(*) from board_hate bh where bh.bno = b.bno) as bhate,
content
from board b, board_member bm
where b.writer = bm.id and b.bno = 23 order by bno desc;

update board set bcount = bcount + 1 where bno = 81;








