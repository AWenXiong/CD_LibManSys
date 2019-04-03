CREATE DATABASE library;

USE library;

CREATE TABLE user(
user_id char(20) NOT NULL,
user_name char(20) NOT NULL,
user_password char(100) NOT NULL,
user_type int NOT NULL DEFAULT 0,
PRIMARY KEY (user_id)
);

CREATE TABLE book(
book_id char(20) NOT NULL,
book_name char(20) NOT NULL,
book_writer char(20) NOT NULL,
book_press char(20) NOT NULL,
book_type char(20) NOT NULL,
book_total int NOT NULL,
book_stock int NOT NULL,
PRIMARY KEY (book_id)
);

CREATE TABLE  borrowBook(
reader_id char(20) NOT NULL,
book_id char(20) NOT NULL,
begin_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
end_time timestamp NOT NULL,
state int NOT NULL DEFAULT 0,
PRIMARY KEY (reader_id,book_id,begin_time),
FOREIGN KEY (reader_id) REFERENCES user(user_id) ON DELETE CASCADE,
FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE
);

CREATE TABLE reserveBook(
reader_id char(20) NOT NULL,
book_id char(20) NOT NULL,
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
state int NOT NULL DEFAULT 0,
PRIMARY KEY (reader_id,book_id,create_time),
FOREIGN KEY (reader_id) REFERENCES user(user_id) ON DELETE CASCADE,
FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE
);

CREATE TABLE dropBook(
reader_id char(20) NOT NULL,
book_id char(20) NOT NULL,
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
state int NOT NULL DEFAULT 0,
PRIMARY KEY (reader_id,book_id,create_time),
FOREIGN KEY (reader_id) REFERENCES user(user_id) ON DELETE CASCADE,
FOREIGN KEY (book_id)  REFERENCES book(book_id) ON DELETE CASCADE
);


--插入用户：
--在每个密码前加“abc”！！
insert into user (user_id,user_name,user_password,user_type) values ("10000","zmy","d11a19d2c912d0aaf64f6bc8316c6ebf",0);
--密码：1020301230

insert into user (user_id,user_name,user_password,user_type) values
("10001","sh","cfd69d33845c649b5191cc0ee378aaff",1);
--密码：112233

--插入书：

insert into book(book_id,book_name,book_writer,book_press,book_type,book_total,book_stock) values
("10000","计算机网络(第7版)","谢希仁","电子工业出版社","计算机",10,10),
("10001","计算机组成原理","贺莲","机械工业出版社","计算机",5,5),
("10002","c++程序设计","王刚","机械工业出版社","编程语言",5,5),
("10003","计算机网络","陈鸣","机械工业出版社","计算机",10,10),
("10004","C++ Primer","Stanley Lippman","电子工业出版社","编程语言",5,5),
("10005","Primer Plus","Stephen Prata","人民邮电出版社","编程语言",7,7),
("10006","六级词汇","俞敏洪","浙江教育出版社","英语",20,20),
("10007","Java面向对象编程","孙卫琴","电子工业出版社","编程语言",2,2),
("10008","追风筝的人","卡勒德 胡塞尼","上海人民出版社","小说",10,10),
("10009","群山回唱","卡勒德 胡塞尼","上海人民出版社","小说",10,10);