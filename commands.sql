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




