-- ----------------------------
-- Table structure for `tbl_users`
-- ----------------------------
DROP TABLE IF EXISTS tbl_users;

CREATE TABLE tbl_users (
  id bigserial NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(20) NOT NULL,
  enabled boolean NOT NULL,
  CONSTRAINT tbl_users_pkey PRIMARY KEY (id)
);

 

-- ----------------------------
-- Table structure for `tbl_user_role`
-- ----------------------------
DROP TABLE IF EXISTS tbl_user_role;

CREATE TABLE tbl_user_role (
  role_id bigserial NOT NULL,	
  userid integer NOT NULL,
  rolename varchar(100) NOT NULL,
  CONSTRAINT tbl_user_role_pkey PRIMARY KEY (role_id)
);

-- 테스트값 입력
INSERT INTO tbl_users(id, username, password, enabled) VALUES (1, 'test1', '123', true);
INSERT INTO tbl_users(id, username, password, enabled) VALUES (2, 'test2', '123', true);
INSERT INTO tbl_users(id, username, password, enabled) VALUES (3, 'test2', '123', true);
INSERT INTO tbl_user_role(role_id, userid, rolename) VALUES (1, 1, 'ROLE_USER');
INSERT INTO tbl_user_role(role_id, userid, rolename) VALUES (2, 2, 'ROLE_ADMIN');

-- 쿼리 테스트
SELECT USERNAME, PASSWORD, ENABLED FROM TBL_USERS WHERE USERNAME='test';
SELECT USERNAME, PASSWORD, CASE ENABLED WHEN 't' THEN 'true' ELSE 'false' END ENABLED FROM TBL_USERS WHERE USERNAME='test';

SELECT u.USERNAME, r.ROLENAME
FROM TBL_USERS u, TBL_USER_ROLE r
WHERE u.ID = r.USERID
AND u.USERNAME='test';