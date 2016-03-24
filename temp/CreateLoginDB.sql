-- Drop the table before creating it
DROP TABLE Project353.LoginInfo;

-- Create a table using the following syntac or interactively via the IDE
CREATE TABLE Project353.LoginInfo (
  USERID    VARCHAR(25),
  PASSWORD  VARCHAR(25)
);

INSERT INTO Project353.LoginInfo VALUES ('Billy123', 'aaaaaaaa');
INSERT INTO Project353.LoginInfo VALUES ('Mary1234', 'bbbbbbbb');
INSERT INTO Project353.LoginInfo VALUES ('Joe12345', 'cccccccc');
