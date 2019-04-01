select * from user;

insert into user(name, password, is_admin, is_user)
 values ('user1', '123456', false, true);

insert into user(name, password, is_admin, is_user)
values ('only-admin', '123456', true, false);

drop table if exists user;