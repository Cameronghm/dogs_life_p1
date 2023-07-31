drop table if exists heroes;
create table heroes
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) not null,
    alias varchar(50) not null,
    superPower varchar(70) not null,
    teamID int not null
);