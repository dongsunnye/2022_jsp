--�Խ���DB
--ȸ�� ������̺�
CREATE TABLE GRADE(
    GRADE_NO NUMBER(1) PRIMARY KEY,
    GRADE_NAME VARCHAR2(20 BYTE)
);
--ȸ�� ���̺�
--���̵�, ��ȣ, �̸�, �г���, ȸ�����
CREATE TABLE BOARD_MEMBER(
    ID VARCHAR2(30 BYTE) PRIMARY KEY,
    PASSWD VARCHAR2(50 BYTE),
    NAME VARCHAR2(30 BYTE),
    NICK VARCHAR2(30 BYTE),
    GRADE_NO NUMBER(1)
);
ALTER TABLE BOARD_MEMBER ADD CONSTRAINT FK_GRADE_NO FOREIGN KEY(GRADE_NO)
REFERENCES GRADE(GRADE_NO) ON DELETE SET NULL;

--�Խ��� ���̺�
--�۹�ȣ, ����, �ۼ���, �ۼ���, ��ȸ��, ����
CREATE TABLE BOARD(
    BNO NUMBER PRIMARY KEY,
    TITLE VARCHAR2(60 BYTE),
    WRITER VARCHAR2(30 BYTE),
    BDATE DATE DEFAULT SYSDATE,
    BCOUNT NUMBER,
    CONTENT VARCHAR2(1000 BYTE),
    CONSTRAINT FK_WRITER FOREIGN KEY(WRITER) REFERENCES BOARD_MEMBER(ID)
);

--�۹�ȣ ������
CREATE SEQUENCE BOARD_BNO START WITH 1 NOMAXVALUE;

--���ƿ� ���̺�
--�Խñ� ��ȣ, ȸ�����̵�
CREATE TABLE BOARD_LIKE(
    BNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_LIKE_PK PRIMARY KEY(BNO, ID),
    CONSTRAINT BOARD_LIKE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_LIKE_BNO_FK FOREIGN KEY(BNO) REFERENCES BOARD(BNO)
);
--�Ⱦ�� ���̺�
--�Խñ� ��ȣ, ȸ�����̵�
CREATE TABLE BOARD_HATE(
    BNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_HATE_PK PRIMARY KEY(BNO, ID),
    CONSTRAINT BOARD_HATE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_HATE_BNO_FK FOREIGN KEY(BNO) REFERENCES BOARD(BNO)
);
--��� ���̺�
--��۹�ȣ, �ۼ���, ����, �ۼ��ð�, �Խñ۹�ȣ
CREATE TABLE BOARD_COMMENT(
    CNO NUMBER PRIMARY KEY,
    CONTETNT VARCHAR2(500 BYTE),
    CDATE DATE DEFAULT SYSDATE,
    BNO NUMBER,
    WRITER VARCHAR2(30 BYTE)
);
--��� ���ƿ� ���̺�
--��� ��ȣ, ȸ�����̵�
CREATE TABLE BOARD_COMMENT_LIKE(
    CNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_COMMENT_LIKE_PK PRIMARY KEY(CNO, ID),
    CONSTRAINT BOARD_COMMENT_LIKE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_COMMENT_LIKE_CNO_FK FOREIGN KEY(CNO) REFERENCES BOARD_COMMENT(CNO)
);
--��� �Ⱦ�� ���̺�
--��� ��ȣ, ȸ�����̵�
CREATE TABLE BOARD_COMMENT_HATE(
    CNO NUMBER,
    ID VARCHAR2(30 BYTE),
    CONSTRAINT BOARD_COMMENT_HATE_PK PRIMARY KEY(CNO, ID),
    CONSTRAINT BOARD_COMMENT_HATE_ID_FK FOREIGN KEY(ID) REFERENCES BOARD_MEMBER(ID),
    CONSTRAINT BOARD_COMMENT_HATE_CNO_FK FOREIGN KEY(CNO) REFERENCES BOARD_COMMENT(CNO)
);






