CREATE TABLE users (
  id INTEGER NOT NULL,
   name VARCHAR(255),
   password VARCHAR(255),
   CONSTRAINT pk_user PRIMARY KEY (id)
);