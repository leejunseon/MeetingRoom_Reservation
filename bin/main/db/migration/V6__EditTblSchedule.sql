--------------------------------------------------------
--  DDL for Table TBL_SCHEDULE
--------------------------------------------------------
ALTER TABLE TBL_SCHEDULE MODIFY (START_TIME NUMBER(10,0));
ALTER TABLE TBL_SCHEDULE MODIFY (END_TIME NUMBER(10,0));
ALTER TABLE TBL_SCHEDULE ADD(S_DATE VARCHAR2(100 BYTE));