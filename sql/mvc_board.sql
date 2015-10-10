  CREATE TABLE "MVC_BOARD" 
   (	
    "BID" NUMBER(4) primary key, 
	"BNAME" VARCHAR2(20), 
	"BTITLE" VARCHAR2(100), 
	"BCONTENT" VARCHAR2(300), 
	"BDATE" DATE DEFAULT sysdate, 
	"BHIT" NUMBER(4) DEFAULT 0, 
	"BGROUP" NUMBER(4), 
	"BSTEP" NUMBER(4), 
	"BINDENT" NUMBER(4) 
   );
   
   commit;
   
   create sequence mvc_board_seq;
   