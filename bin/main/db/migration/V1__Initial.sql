--------------------------------------------------------
--  DDL for Sequence SEQ_BOARD
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_BOARD"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_REPLY
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_REPLY"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCHEDULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCHEDULE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table PERSISTENT_LOGINS
--------------------------------------------------------

  CREATE TABLE "PERSISTENT_LOGINS" 
   (	"USERNAME" VARCHAR2(64 BYTE), 
	"SERIES" VARCHAR2(64 BYTE), 
	"TOKEN" VARCHAR2(64 BYTE), 
	"LAST_USED" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_BOARD
--------------------------------------------------------

  CREATE TABLE "TBL_BOARD" 
   (	"BNO" NUMBER(10,0), 
	"TITLE" VARCHAR2(200 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"WRITER" VARCHAR2(50 BYTE), 
	"REGDATE" DATE DEFAULT sysdate, 
	"UPDATEDATE" DATE DEFAULT sysdate, 
	"REPLYCNT" NUMBER DEFAULT 0
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_MEMBER
--------------------------------------------------------

  CREATE TABLE "TBL_MEMBER" 
   (	"USERID" VARCHAR2(50 BYTE), 
	"USERPW" VARCHAR2(100 BYTE), 
	"USERNAME" VARCHAR2(100 BYTE), 
	"REGDATE" DATE DEFAULT SYSDATE, 
	"UPDATEDATE" DATE DEFAULT SYSDATE, 
	"ENABLED" CHAR(1 BYTE) DEFAULT '1', 
	"EMAIL" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_MEMBER_AUTH
--------------------------------------------------------

  CREATE TABLE "TBL_MEMBER_AUTH" 
   (	"USERID" VARCHAR2(50 BYTE), 
	"AUTH" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_REPLY
--------------------------------------------------------

  CREATE TABLE "TBL_REPLY" 
   (	"RNO" NUMBER(10,0), 
	"BNO" NUMBER(10,0), 
	"REPLY" VARCHAR2(1000 BYTE), 
	"REPLYER" VARCHAR2(50 BYTE), 
	"REPLYDATE" DATE DEFAULT sysdate, 
	"UPDATEDATE" DATE DEFAULT sysdate
   ) ;
--------------------------------------------------------
--  DDL for Table TBL_SCHEDULE
--------------------------------------------------------

  CREATE TABLE "TBL_SCHEDULE" 
   (	"SNO" NUMBER(10,0), 
	"BNO" NUMBER(10,0), 
	"WRITER" VARCHAR2(50 BYTE), 
	"TITLE" VARCHAR2(100 BYTE), 
	"START_TIME" DATE, 
	"END_TIME" DATE
   ) ;
--------------------------------------------------------
--  DDL for Index IDX_REPLY
--------------------------------------------------------

  CREATE INDEX "IDX_REPLY" ON "TBL_REPLY" ("BNO" DESC, "RNO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_SCHEDULE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_SCHEDULE" ON "TBL_SCHEDULE" ("SNO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_BOARD
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_BOARD" ON "TBL_BOARD" ("BNO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_REPLY
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_REPLY" ON "TBL_REPLY" ("RNO") 
  ;
--------------------------------------------------------
--  Constraints for Table TBL_MEMBER_AUTH
--------------------------------------------------------

  ALTER TABLE "TBL_MEMBER_AUTH" MODIFY ("AUTH" NOT NULL ENABLE);
  ALTER TABLE "TBL_MEMBER_AUTH" MODIFY ("USERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PERSISTENT_LOGINS
--------------------------------------------------------

  ALTER TABLE "PERSISTENT_LOGINS" ADD PRIMARY KEY ("SERIES") ENABLE;
  ALTER TABLE "PERSISTENT_LOGINS" MODIFY ("LAST_USED" NOT NULL ENABLE);
  ALTER TABLE "PERSISTENT_LOGINS" MODIFY ("TOKEN" NOT NULL ENABLE);
  ALTER TABLE "PERSISTENT_LOGINS" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_MEMBER
--------------------------------------------------------

  ALTER TABLE "TBL_MEMBER" ADD PRIMARY KEY ("USERID") ENABLE;
  ALTER TABLE "TBL_MEMBER" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "TBL_MEMBER" MODIFY ("USERPW" NOT NULL ENABLE);
  ALTER TABLE "TBL_MEMBER" MODIFY ("USERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_REPLY
--------------------------------------------------------

  ALTER TABLE "TBL_REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY ("RNO") ENABLE;
  ALTER TABLE "TBL_REPLY" MODIFY ("REPLYER" NOT NULL ENABLE);
  ALTER TABLE "TBL_REPLY" MODIFY ("REPLY" NOT NULL ENABLE);
  ALTER TABLE "TBL_REPLY" MODIFY ("BNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "TBL_SCHEDULE" ADD CONSTRAINT "PK_SCHEDULE" PRIMARY KEY ("SNO") ENABLE;
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("END_TIME" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("START_TIME" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("WRITER" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("BNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_BOARD
--------------------------------------------------------

  ALTER TABLE "TBL_BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY ("BNO") ENABLE;
  ALTER TABLE "TBL_BOARD" MODIFY ("WRITER" NOT NULL ENABLE);
  ALTER TABLE "TBL_BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "TBL_BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table TBL_MEMBER_AUTH
--------------------------------------------------------

  ALTER TABLE "TBL_MEMBER_AUTH" ADD CONSTRAINT "FK_MEMBER_AUTH" FOREIGN KEY ("USERID")
	  REFERENCES "TBL_MEMBER" ("USERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TBL_REPLY
--------------------------------------------------------

  ALTER TABLE "TBL_REPLY" ADD CONSTRAINT "FK_REPLY_BOARD" FOREIGN KEY ("BNO")
	  REFERENCES "TBL_BOARD" ("BNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TBL_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "TBL_SCHEDULE" ADD CONSTRAINT "FK_SCHEDULE_BOARD" FOREIGN KEY ("BNO")
	  REFERENCES "TBL_BOARD" ("BNO") ENABLE;
