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

insert into notes(title,content,creation_time,username) values('React Notes','React is a JS Library',sysdate(),'harsh');
insert into notes(title,content,creation_time,username) values('Angular Notes','Angular is a JS Framework',sysdate(),'harsh');
insert into notes(title,content,creation_time,username) values('Vue Notes','Vue is a JS Framework',sysdate(),'rahul');
insert into notes(title,content,creation_time,username) values('Svelte Notes','Svelte is a JS Framework',sysdate(),'karan');
insert into notes(title,content,creation_time,username) values('Ember Notes','Ember is a JS Framework',sysdate(),'rahul');
insert into notes(title,content,creation_time,username) values('Backbone Notes','Backbone is a JS Framework',sysdate(),'mohit');
insert into notes(title,content,creation_time,username) values('Lit Notes','Lit is a JS Library',sysdate(),'rahul');
insert into notes(title,content,creation_time,username) values('Preact Notes','Preact is a JS Library',sysdate(),'javed');
insert into notes(title,content,creation_time,username) values('Alpine Notes','Alpine is a JS Framework',sysdate(),'javed');
insert into notes(title,content,creation_time,username) values('Mithril Notes','Mithril is a JS Framework',sysdate(),'rahul');

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




