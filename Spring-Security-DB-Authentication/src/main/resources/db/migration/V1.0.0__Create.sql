create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table role (id bigint not null, role  varchar(255), primary key (id));
create table user (id bigint not null, account_non_expired boolean default true not null, account_non_locked boolean default true not null, credentials_non_expired boolean default true not null, enabled boolean default true not null, first_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), version integer not null, primary key (id));
create table user_roles (user_id bigint not null, roles_id bigint not null, primary key (user_id, roles_id));
alter table user_roles add constraint UK_amwlmdeik2qdnksxgd566knop unique (roles_id);
alter table user_roles add constraint FKj9553ass9uctjrmh0gkqsmv0d foreign key (roles_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);