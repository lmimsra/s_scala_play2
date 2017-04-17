# Users schema

# --- !Ups

CREATE TABLE IF NOT EXISTS User (
  id      BIGINT(30)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id VARCHAR(30)  NOT NULL,
  email   VARCHAR(255) NOT NULL,
  name    VARCHAR(255) NOT NULL,
  isAdmin BOOLEAN      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Password (
  id       BIGINT(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id  VARCHAR(30)   NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO User VALUES ("testuser1","te1gcs@aerdf.js","test man",false);
INSERT INTO User VALUES ("testuser2","te2gcs@aerdf.js","test woman",true);

# --- !Downs

DROP TABLE User;
DROP TABLE Password;