create table gameboard(
gamenum number constraint gameboard_gamenum_pk primary key
, hno number constraint gameboard_hno_fk references huser
, title varchar2(100) not null
, content varchar2(2000) not null
, hits number default 0
);

create sequence gameboard_seq;


create table adminreply(
replynum number constraint adminreply_replynum_pk primary key
, gamenum number constraint adminreply_gamenum_fk REFERENCES gameboard on delete cascade
, content varchar2(1000) not null
);



create sequence adminreply_seq;