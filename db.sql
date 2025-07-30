create table tab1
(
    id      int auto_increment
        primary key,
    name    varchar(50)                         not null,
    age     int                                 null,
    created timestamp default CURRENT_TIMESTAMP null
);

INSERT INTO test_db.tab1 (id, name, age, created) VALUES (1, 'ab', 12, '2025-07-20 18:19:31');
INSERT INTO test_db.tab1 (id, name, age, created) VALUES (2, 'cdd', 13, '2025-07-20 18:20:40');
INSERT INTO test_db.tab1 (id, name, age, created) VALUES (3, '夸大', 14, '2025-07-20 18:20:40');
