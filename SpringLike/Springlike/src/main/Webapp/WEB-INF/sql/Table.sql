create table ?(
    admin_id varchar2(50) primary key,
    admin_pwd varchar2(50) not null,
    admin_board varchar2(50) not null
);
COMMIT;