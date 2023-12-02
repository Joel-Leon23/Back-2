INSERT INTO Users(username, password, enabled, name, last_name, email) VALUES ('john_doe', '$2a$10$/VZvxeq7q4GPPFiqEuPIRuOv7fDmQoZrJQb4Qq2j0K/QfKRiusOD6', true, 'John', 'Doe', 'john.doe@example.com');
INSERT INTO Users(username, password, enabled, name, last_name, email) VALUES ('jane_smith', '$2a$10$xhYZPlhCKfJfLKITCL/6pudR2luDMbzDVIC7AOdqygfYPmhUPu7aK', true, 'Jane', 'Smith', 'jane.smith@example.com');

INSERT INTO roles(name) VALUES ('ROLE_USER');
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');

INSERT INTO users_to_roles(user_id, roles_id) VALUES(1,1);
INSERT INTO users_to_roles(user_id, roles_id) VALUES(2,2);
INSERT INTO users_to_roles(user_id, roles_id) VALUES(2,1);