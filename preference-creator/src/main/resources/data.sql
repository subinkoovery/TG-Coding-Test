DROP TABLE IF EXISTS PREFERENCE;
DROP TABLE IF EXISTS CUSTOMER;
DROP INDEX IF EXISTS customerId_PREFERENCEiNDEX;



CREATE TABLE CUSTOMER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_Name VARCHAR(64) NOT NULL,
  name VARCHAR(255) NOT NULL,
  created_By INT NOT NULL,
  creation_Time DATETIME NOT NULL,
  modified_By INT NULL,
  modified_Time DATETIME NULL
);


CREATE TABLE PREFERENCE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_Id INT NOT NULL,
  preference_Type VARCHAR(25) NOT NULL,
  created_By INT NOT NULL,
  creation_Time DATETIME NOT NULL,
  modified_By INT NULL,
  modified_Time DATETIME NULL,
  FOREIGN KEY (customer_Id) REFERENCES CUSTOMER(ID)
);
CREATE INDEX customerId_PREFERENCEiNDEX ON PREFERENCE(customer_Id);

INSERT INTO CUSTOMER(id,user_Name,name,created_By,creation_Time,modified_By,modified_Time) VALUES(1,'admin','Customer Preference Admin',1,CURRENT_TIMESTAMP(),NULL,NULL);

CREATE SEQUENCE HIBERNATE_SEQUENCE
  START WITH 2
  INCREMENT BY 1
  MINVALUE 1;