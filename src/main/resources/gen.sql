create table `role` (
	id bigint not null auto_increment,
    name varchar(20) not null,
    primary key (id)
);

create table `user` (
	id bigint not null auto_increment,
    username varchar(200) not null,
    email varchar(200) not null,
    password varchar(64) not null,
    primary key (id)
);

create table `users_roles` (
	`user_id` bigint not null,
    `role_id` bigint not null,
    key `user_fk_idx` (`user_id`),
    key `role_fk_idx` (`role_id`),
    constraint `user_fk` foreign key (`user_id`) references `user` (`id`) on delete cascade
);

create table `item` (
	id bigint not null auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    originalPrice float,
    currentBid float,
    primary key (id)
);

create table `bid` (
	id bigint not null auto_increment,
    amount float,
    primary key (id)
);

create table `car` (
    id bigint not null auto_increment,
    brand varchar(200) not null,
    model varchar(200) not null,
    description text not null,
    year int not null,
    variant varchar(200) not null,
    transmission varchar(200) not null,
    fueltype varchar(200) not null,
    location varchar(200) not null,
    price float not null,
    primary key (id)
);

create table `message` (
	id bigint not null auto_increment,
    sender varchar(200) not null,
    email varchar(200) not null,
    subject varchar(200) not null,
    message text not null,
    timestamp timestamp,
    primary key (id)
);