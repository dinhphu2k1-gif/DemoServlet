CREATE TABLE Users(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50),
    password varchar(50)
);

INSERT INTO User VALUES 
(null, 'admin@email.com', '123456'),
(null, 'user@email.com', '123');