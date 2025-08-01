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





