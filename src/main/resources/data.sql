CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO student (firstname, lastname, email) VALUES ('John', 'Doe', 'john.doe@example.com');
INSERT INTO student (firstname, lastname, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');
