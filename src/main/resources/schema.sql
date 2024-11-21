CREATE TABLE IF NOT EXISTS roles (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL	
);

CREATE TABLE IF NOT EXISTS companies (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL UNIQUE	
);

CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,	
	telephone VARCHAR(50) NOT NULL,
	emergency_contact VARCHAR(50) NOT NULL,	
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
	role_id INT NOT NULL,
	company_id INT NOT NULL,
	company_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (id),
	FOREIGN KEY (company_id) REFERENCES companies (id),
	FOREIGN KEY (company_name) REFERENCES companies (name)
);