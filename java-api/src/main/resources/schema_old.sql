CREATE TABLE IF NOT EXISTS Dogs
(id INTEGER not null AUTO_INCREMENT,
name VARCHAR(255) not null,
age INTEGER not null,
owner_id VARCHAR(255) not null,
PRIMARY KEY (id));
