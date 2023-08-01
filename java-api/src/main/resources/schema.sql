CREATE TABLE IF NOT EXISTS Owners
(owner_id INTEGER not null AUTO_INCREMENT,
name VARCHAR(255) not null,
PRIMARY KEY (owner_id));

CREATE TABLE IF NOT EXISTS Dogs
(id INTEGER not null AUTO_INCREMENT,
name VARCHAR(255) not null,
age INTEGER not null,
owner_id INTEGER not null,
PRIMARY KEY (id),
FOREIGN KEY (owner_id) REFERENCES Owners(owner_id));
