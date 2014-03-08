CREATE DATABASE db_danwoo CHARACTER SET utf8;

GRANT ALL PRIVILEGES ON db_danwoo.* TO 'danwoo'@'localhost' IDENTIFIED BY 'danwoo';

INSERT INTO User (username, password, role, enabled, createdTime) VALUES ('admin', '1234', 'SUPERVISOR', true, now());
INSERT INTO User (username, password, role, enabled, createdTime) VALUES ('izeye', '1234', 'USER', true, now());
