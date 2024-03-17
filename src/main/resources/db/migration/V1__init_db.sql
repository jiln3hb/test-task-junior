create table products (
    id bigint not null,
    name varchar(255) not null,
    manufacture_country varchar(255) not null,
    manufacture_company varchar(255) not null,
    online_available boolean not null,
    instalment_option boolean not null,
    primary key (id));

create table television_sets (
    id bigint not null,
    product_id bigint not null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    color varchar(50) not null,
    size varchar(255) not null,
    price decimal(10,2) not null,
    category varchar(255) not null,
    technology varchar(255) not null,
    availability boolean not null,
    primary key (id),
    foreign key (product_id) references products);

create table vacuum_cleaners (
    id bigint not null,
    product_id bigint not null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    color varchar(50) not null,
    size varchar(255) not null,
    price decimal(10,2) not null,
    volume float not null,
    mods_number int not null,
    availability boolean not null,
    primary key (id),
    foreign key (product_id) references products);

create table fridges (
    id bigint not null,
    product_id bigint not null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    color varchar(50) not null,
    size varchar(255) not null,
    price decimal(10,2) not null,
    doors_number int not null,
    compressor_type varchar(255) not null,
    availability boolean not null,
    primary key (id),
    foreign key (product_id) references products);

create table smartphones (
    id bigint not null,
    product_id bigint not null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    color varchar(50) not null,
    size varchar(255) not null,
    price decimal(10,2) not null,
    memory_amount int not null,
    cameras_number int not null,
    availability boolean not null,
    primary key (id),
    foreign key (product_id) references products);

create table computers (
    id bigint not null,
    product_id bigint not null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    color varchar(50) not null,
    size varchar(255) not null,
    price decimal(10,2) not null,
    volume float not null,
    category varchar(255) not null,
    cpu_type varchar(255) not null,
    availability boolean not null,
    primary key (id),
    foreign key (product_id) references products);

create sequence product_id_seq start with 1 increment by 1;
create sequence model_id_seq start with 1 increment by 1;