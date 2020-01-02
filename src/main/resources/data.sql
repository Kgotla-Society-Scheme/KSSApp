
insert into app_user(id,name,username,password) values (1,'Mohapi','admin','admin');

insert into app_user(id,name,username,password) values (2,'Lwandile','user','user');



insert into app_user_roles(app_user_id,roles) values (1,'ADMIN');

insert into app_user_roles(app_user_id,roles) values (1,'USER');

insert into app_user_roles(app_user_id,roles) values (2,'USER');



/*

DROP TABLE IF EXISTS payments;*/



insert into payments(id,name,surname,payment_date,proof_ofpayment) values (1,'Mohapi','Mokoena',DATE '2019-12-17',FILE_READ('C:\Users\Lwandile\Documents\Copy of Kgotla_account_summary_06_August_2019(1).xlsx'));

insert into payments(id,name,surname,payment_date,proof_ofpayment) values (2,'Lwandile','Jacob',DATE '2019-12-17',FILE_READ('C:\Users\Lwandile\Documents\Copy of Kgotla_account_summary_06_August_2019(1).xlsx'));
