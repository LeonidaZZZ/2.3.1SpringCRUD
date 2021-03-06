CREATE TABLE spring-crud.roles (
  id   INT          NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE spring-crud.users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  firstName VARCHAR(255) NOT NULL,
  lastName VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE spring-crud.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO spring-crud.users VALUES (1, 'admin@mail.ru', 'admin','admin','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.');

INSERT INTO spring-crud.roles VALUES (1, 'ROLE_USER');
INSERT INTO spring-crud.roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO spring-crud.user_roles VALUES (1, 2);

