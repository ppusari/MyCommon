  CREATE TABLE "BOARD" 
  (	
  	"MID" NUMBER(4,0), 
	"MWRITER" VARCHAR2(100 BYTE), 
	"MCONTENT" VARCHAR2(300 BYTE) 
  );
  
  commit;
  
  create sequence board_seq;