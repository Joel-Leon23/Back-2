INSERT INTO Users(username, password, enabled, name, last_name, email)VALUES('john_doe', 'password123', true, 'John', 'Doe', 'john.doe@example.com');
INSERT INTO Users(username, password, enabled, name, last_name, email)VALUES('jane_smith', 'secure_password', true, 'Jane', 'Smith', 'jane.smith@example.com');

INSERT INTO roles(name) VALUES ('ROLE_USER');
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');

INSERT INTO users_to_roles(user_id, roles_id) VALUES(1,1);
INSERT INTO users_to_roles(user_id, roles_id) VALUES(2,2);
INSERT INTO users_to_roles(user_id, roles_id) VALUES(2,1);