create table if not exists user (
  id bigint(20) not null auto_increment,
  username varchar(255) not null,
  password varchar(255) not null,
  first_name varchar(255) ,
  sur_name varchar(255),
  account_non_expired boolean,
  account_non_locked boolean,
  credentials_non_expired boolean,
  enabled boolean,
  primary key (id)
);

create table if not exists city_capital
(
    id bigint primary key auto_increment,
    title varchar(255),
    population bigint,
    lat float,
    lng float,
    founding_date timestamp,
    message_date timestamp
);

create table if not exists filter
(
    id bigint primary key auto_increment,
    filter_name varchar(255)
);

create table if not exists filter_condition
(
    id bigint primary key auto_increment,
    field_name varchar(255),
    condition_operator varchar(50),
    property_value varchar(255),
    filter_id bigint references filter (id)
);


create table if not exists acl_sid (
  id bigint(20) not null auto_increment,
  principal tinyint(1) not null,
  sid varchar(100) not null,
  primary key (id),
  unique key unique_uk_1 (sid,principal)
);

create table if not exists acl_class (
  id bigint(20) not null auto_increment,
  class varchar(255) not null,
  primary key (id),
  unique key unique_uk_2 (class)
);

create table if not exists acl_entry (
  id bigint(20) not null auto_increment,
  acl_object_identity bigint(20) not null,
  ace_order int(11) not null,
  sid bigint(20) not null,
  mask int(11) not null,
  granting tinyint(1) not null,
  audit_success tinyint(1) not null,
  audit_failure tinyint(1) not null,
  primary key (id),
  unique key unique_uk_4 (acl_object_identity,ace_order)
);

create table if not exists acl_object_identity (
  id bigint(20) not null auto_increment,
  object_id_class bigint(20) not null,
  object_id_identity bigint(20) not null,
  parent_object bigint(20) default null,
  owner_sid bigint(20) default null,
  entries_inheriting tinyint(1) not null,
  primary key (id),
  unique key unique_uk_3 (object_id_class,object_id_identity)
);


alter table acl_entry
    add foreign key (acl_object_identity) references acl_object_identity(id);

alter table acl_entry
    add foreign key (sid) references acl_sid(id);

alter table acl_object_identity
    add foreign key (parent_object) references acl_object_identity (id);

alter table acl_object_identity
    add foreign key (object_id_class) references acl_class (id);

alter table acl_object_identity
    add foreign key (owner_sid) references acl_sid (id);



