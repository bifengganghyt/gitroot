-- day17 --
CREATE DATABASE day17;

USE day17;

-- 学生表
CREATE TABLE student(
	id INT PRIMARY KEY,
	NAME VARCHAR(20),
	age INT,
	gender VARCHAR(2)
)


INSERT INTO student VALUES(1,'张三',20,'男');

SELECT * FROM student;

SELECT COUNT(*) FROM student;

DELETE FROM student;

-- 新闻表
CREATE TABLE news(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100),
	content LONGTEXT  -- 使用longtext存储新闻内容 
)

SELECT * FROM news;
-- 给新闻表添加附件字段
ALTER TABLE news ADD attachments BLOB;
-- 修改字段类型
ALTER TABLE news MODIFY attachments  MEDIUMBLOB;



--    attachments:
	id 编号
	NAME 附件名称 VARCHAR
	FILE 附件文件  BLOB类型
	ADDTIME 添加时间
	author 附件作者

CREATE TABLE attachments(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50),
	FILE MEDIUMBLOB,
	ADDTIME DATETIME,
	author VARCHAR(50)
)

SELECT * FROM attachments;

-- 部门表
CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
)

-- 员工表
CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	deptId INT,
	CONSTRAINT employee_dept_fk FOREIGN KEY(deptId) REFERENCES dept(id) 
)

-- 插入数据
INSERT INTO dept(NAME) VALUES('软件开发部');
-- 同时再插入员工
INSERT INTO employee(NAME,deptId) VALUES('张三',1);
-- 如果是java程序插入部门和员工的时候
-- 先插入部门的时候，如何自增长的值？？？？
-- 再插入员工的时候，需要自增长产生的部门id

SELECT * FROM dept;
SELECT * FROM employee;


-- 账户表
CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	balance INT
)

INSERT INTO account(NAME,balance) VALUES('eric',5000);
INSERT INTO account(NAME,balance) VALUES('jacky',5000);

SELECT * FROM account;

UPDATE account SET balance=5000;

SELECT COUNT(*) FROM account;



-- 创建通讯录数据库
CREATE DATABASE contactSys;

-- 联系人表
CREATE TABLE contact_list(
	id VARCHAR(50) PRIMARY KEY,
	NAME VARCHAR(20),
	gender VARCHAR(2),
	phone VARCHAR(11),
	email VARCHAR(20),
	address VARCHAR(50)
)

SELECT * FROM contact_list;
