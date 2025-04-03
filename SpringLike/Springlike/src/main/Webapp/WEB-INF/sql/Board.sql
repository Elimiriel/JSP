-- Board table: ease DB sharing
create table ?(
    board_no number(7) primary key, --docno
    board_writter varchar2(50) not null, --writter
    board_title varchar2(200) not null, --title
    board_cont varchar2(2000), --inner content
    board_pwd varchar2(50) not null, --edit/del pwd
    board_hit number(5) default 0, --views
    board_wdate datetime, --write date
    board_edit datetime, --edit
    board_admin varchar2(50) foreign key references ?(admin_board) --admin
);
COMMIT;