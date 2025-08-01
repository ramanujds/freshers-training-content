create database mydb;

use mydb;

-- notes : id, title, content, creation_time, username



create table notes(id int primary key auto_increment, title varchar(100) not null,
			content varchar(300), creation_time datetime not null);
            
desc notes;  


insert into notes(title,content,creation_time) values('React Notes','React is a JS Library',sysdate());          

select * from notes;

alter table notes add username varchar(50);

update notes set username='rahul' where id=1;
update notes set username='harsh' where id=2;

drop table notes;

set autocommit=0;

savepoint p1;

delete from notes where id=1;

truncate table notes;

select * from notes;

rollback to p1;

commit;




insert into notes(title,content,creation_time,username) values('React Notes','React is a JS Library','2023-11-15 10:23:45','harsh');
insert into notes(title,content,creation_time,username) values('Angular Notes','Angular is a JS Framework','2024-01-08 14:12:30','harsh');
insert into notes(title,content,creation_time,username) values('Vue Notes','Vue is a JS Framework','2023-09-27 09:45:10','rahul');
insert into notes(title,content,creation_time,username) values('Svelte Notes','Svelte is a JS Framework','2024-03-19 16:05:22','karan');
insert into notes(title,content,creation_time,username) values('Ember Notes','Ember is a JS Framework','2023-12-02 18:30:00','rahul');
insert into notes(title,content,creation_time,username) values('Backbone Notes','Backbone is a JS Framework','2024-02-14 11:11:11','mohit');
insert into notes(title,content,creation_time,username) values('Lit Notes','Lit is a JS Library','2023-10-21 07:55:33','rahul');
insert into notes(title,content,creation_time,username) values('Preact Notes','Preact is a JS Library','2024-04-05 20:20:20','javed');
insert into notes(title,content,creation_time,username) values('Alpine Notes','Alpine is a JS Framework','2023-08-30 13:13:13','javed');
insert into notes(title,content,creation_time,username) values('Mithril Notes','Mithril is a JS Framework','2024-05-01 22:22:22','rahul');

-- create a table user with id, username, location

create table user(id int primary key auto_increment, username varchar(50) not null, location varchar(100));

insert into user(username, location) values('rahul', 'India');
insert into user(username, location) values('harsh', 'USA');
insert into user(username, location) values('karan', 'UK');
insert into user(username, location) values('mohit', 'Canada');
insert into user(username, location) values('javed', 'Australia');

-- drop the coulmn username from notes
alter table notes drop column username;

-- add coulmn user_id to notes with foreign key reference to user table

alter table notes add user_id int;
alter table notes add constraint fk_user foreign key (user_id) references user(id);



commit;

set autocommit=1;

drop table notes;
create table notes
(
    id            int auto_increment
        primary key,
    title         varchar(100) not null,
    content       varchar(300) null,
    creation_time datetime     not null,
    username      varchar(50)  null
);


-- find all the notes for rahul

-- show all the users

select distinct username from notes;

-- count the notes for each users

select username, count(id) as 'total notes' from notes group by username;

-- sort the notes based on user ascending and date descending

select * from notes order by username asc, creation_time desc;

-- find the user with max no of notes

select username, count(id) as 'total notes' from notes group by username order by 2 desc limit 2;

-- show the user who added the first note

select min(creation_time) from notes;

select username, creation_time from notes order by 2 asc limit 1;
 
select * from notes where creation_time=(select min(creation_time) from notes);

-- select latest note for each user



-- find all the notes added in 2024

select * from notes where extract(year from creation_time) in (2024,2025);

select * from notes where creation_time like '2024%';

-- find all the notes added in novenber or december

select * from notes where month(creation_time) in (11,12);















