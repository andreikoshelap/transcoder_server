insert into user (id, username, password, first_name, sur_name,
                  account_non_expired, account_non_locked, credentials_non_expired, enabled)
values (1, 'admin', 'password', 'John', 'Dow', true, false, true, true),
(5, 'ivan', 'password', 'Ivan', 'Dubov', true, false, true, true),
(3, 'sebastien', 'password', 'Sebastien', 'Col', true, false, true, true),
(4, 'shmakodjavka', 'password', 'Elisey', '', true, false, true, true),
(2, 'user', 'password', 'Alice', 'Dow', true, false, true, true);

insert into city_capital(id, title, population, lat, lng, founding_date, message_date)
values (1, 'Tallinn', 1331057, 59.43, 24.72, '1154-01-01 00.00.00', '2023-06-01 00.00.00'),
 (2, 'Riga', 1901548, 57.0, 25.0, '1201-01-01 00.00.00', '2023-06-01 00.00.00'),
 (3, 'Riga', 2001548, 57.0, 25.0, '1201-01-01 00.00.00', '2023-01-01 00.00.00'),
 (4, 'London', 67215293, 54.0, -2.0, '1066-01-01 00.00.00', '2023-06-01 00.00.00');

insert into filter (id, filter_name)
values    (1, 'main filter');

insert into filter_condition (id, field_name, condition_operator, property_value,filter_id)
values    (1, 'title', 'EQUALS','Tallinn', 1),
(2, 'population', 'MORE', '600000', 1),
(3, 'message_date', 'BEFORE', '2023-01-02 00.00.00', 1);

insert into acl_sid (id, principal, sid)
values    (1, 1, 'admin'),
(2, 1, 'user'),
(3, 0, 'role_editor');

insert into acl_class (id, class)
values    (1, 'com.kn.koshelap.transcoder.capital');

insert into acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting)
values    (1, 1, 1, null, 3, 0),
(2, 1, 2, null, 3, 0),
(3, 1, 3, null, 3, 0);

insert into acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
values    (1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 1, 1, 1),
(3, 1, 3, 3, 1, 1, 1, 1),

(4, 2, 1, 2, 1, 1, 1, 1),
(5, 2, 2, 3, 1, 1, 1, 1),
(6, 3, 1, 3, 1, 1, 1, 1),

(7, 3, 2, 3, 2, 1, 1, 1);




