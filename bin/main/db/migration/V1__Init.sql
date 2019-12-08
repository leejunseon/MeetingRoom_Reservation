--------------------------------------------------------
--  DDL for Sequence SEQ_ROOM
--------------------------------------------------------
   CREATE SEQUENCE  "SEQ_ROOM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;

--------------------------------------------------------
--  DDL for Sequence SEQ_SCHEDULE
--------------------------------------------------------
   CREATE SEQUENCE  "SEQ_SCHEDULE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;

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
--  DDL for Table TBL_ROOM
--------------------------------------------------------
  CREATE TABLE "TBL_ROOM" 
   (	"RNO" NUMBER(10,0), 
	"NAME" VARCHAR2(200 BYTE), 
	"MIN_TIME" DATE, 
	"MAX_TIME" DATE, 
	"WEEKEND" NUMBER(1,0)
   ) ;
   
--------------------------------------------------------
--  DDL for Table TBL_MEMBER
--------------------------------------------------------
  CREATE TABLE "TBL_MEMBER" 
   (	"USERID" VARCHAR2(50 BYTE), 
	"USERPW" VARCHAR2(100 BYTE), 
	"USERNAME" VARCHAR2(100 BYTE),
	"EMAIL" VARCHAR2(100 BYTE),
	"REGDATE" DATE DEFAULT SYSDATE, 
	"UPDATEDATE" DATE DEFAULT SYSDATE
   ) ;
   
--------------------------------------------------------
--  DDL for Table TBL_MEMBER_AUTH
--------------------------------------------------------
  CREATE TABLE "TBL_MEMBER_AUTH" 
   (	"USERID" VARCHAR2(50 BYTE), 
	"AUTH" VARCHAR2(50 BYTE)
   ) ;

--------------------------------------------------------
--  DDL for Table TBL_SCHEDULE
--------------------------------------------------------
  CREATE TABLE "TBL_SCHEDULE" 
   (	"SNO" NUMBER(10,0), 
	"RNO" NUMBER(10,0), 
	"BOOKER" VARCHAR2(50 BYTE), 
	"TITLE" VARCHAR2(100 BYTE), 
	"START_TIME" DATE, 
	"END_TIME" DATE,
	"APPROVED" NUMBER(10,0) DEFAULT 0
   ) ;
   
--------------------------------------------------------
--  DDL for Table TBL_ATTENDEE
--------------------------------------------------------
  CREATE TABLE "TBL_ATTENDEE" 
   (	"SNO" NUMBER(10,0), 
	 "USERID" VARCHAR2(50 BYTE)
   ) ;
   
   
   
--------------------------------------------------------
--  DDL for Index PK_SCHEDULE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_SCHEDULE" ON "TBL_SCHEDULE" ("SNO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ROOM
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ROOM" ON "TBL_ROOM" ("RNO") 
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
  ALTER TABLE "TBL_MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table TBL_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "TBL_SCHEDULE" ADD CONSTRAINT "PK_SCHEDULE" PRIMARY KEY ("SNO") ENABLE;
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("SNO" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("RNO" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("BOOKER" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("START_TIME" NOT NULL ENABLE);
  ALTER TABLE "TBL_SCHEDULE" MODIFY ("END_TIME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TBL_ROOM
--------------------------------------------------------

  ALTER TABLE "TBL_ROOM" ADD CONSTRAINT "PK_ROOM" PRIMARY KEY ("RNO") ENABLE;
  ALTER TABLE "TBL_ROOM" MODIFY ("RNO" NOT NULL ENABLE);
  ALTER TABLE "TBL_ROOM" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "TBL_ROOM" MODIFY ("MIN_TIME" NOT NULL ENABLE);
  ALTER TABLE "TBL_ROOM" MODIFY ("MAX_TIME" NOT NULL ENABLE);
  ALTER TABLE "TBL_ROOM" MODIFY ("WEEKEND" NOT NULL ENABLE);
  
--------------------------------------------------------
--  Constraints for Table TBL_ATTENDEE
--------------------------------------------------------

  ALTER TABLE "TBL_ATTENDEE" MODIFY ("SNO" NOT NULL ENABLE);
  ALTER TABLE "TBL_ATTENDEE" MODIFY ("USERID" NOT NULL ENABLE);  
  
  
  
--------------------------------------------------------
--  Ref Constraints for Table TBL_MEMBER_AUTH
--------------------------------------------------------

  ALTER TABLE "TBL_MEMBER_AUTH" ADD CONSTRAINT "FK_MEMBER_AUTH_MEMBER" FOREIGN KEY ("USERID")
	  REFERENCES "TBL_MEMBER" ("USERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TBL_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "TBL_SCHEDULE" ADD CONSTRAINT "FK_SCHEDULE_BOARD" FOREIGN KEY ("RNO")
	  REFERENCES "TBL_ROOM" ("RNO") ENABLE;
	  
--------------------------------------------------------
--  Ref Constraints for Table TBL_ATTENDEE
--------------------------------------------------------

  ALTER TABLE "TBL_ATTENDEE" ADD CONSTRAINT "FK_ATTENDEE_SCHEDULE" FOREIGN KEY ("SNO")
	  REFERENCES "TBL_SCHEDULE" ("SNO") ENABLE;
	  
--------------------------------------------------------
--  Ref Constraints for Table TBL_ATTENDEE
--------------------------------------------------------

  ALTER TABLE "TBL_ATTENDEE" ADD CONSTRAINT "FK_ATTENDEE_MEMBER" FOREIGN KEY ("USERID")
	  REFERENCES "TBL_MEMBER" ("USERID") ENABLE;