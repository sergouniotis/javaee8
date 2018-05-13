create sequence items_pk_seq increment by 50 minvalue 1;

create table items(
	id integer not null,
	title text not null
);

alter table items add constraint items_pk primary key(id);


insert into items values( nextval('items_pk_seq'), 'lorem ipsum');
