SET DATABASE COLLATION "English" STRENGTH IDENTICAL;
SET IGNORECASE TRUE;
SET MODE MySQL;


CREATE TABLE IF NOT EXISTS student (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	age INT NOT NULL
);

INSERT INTO student(name, email, age) VALUES
("Amit Sharma","amit@gmail.com", 22),
("Priya Singh", "priya@gmail.com", 20);


