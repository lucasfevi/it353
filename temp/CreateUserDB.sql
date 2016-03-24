-- Drop the table before creating it
DROP TABLE Project353.Users;

-- Create a table using the following syntac or interactively via the IDE
CREATE TABLE Project353.Users (
  id            INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  first_name    VARCHAR(25),
  last_name     VARCHAR(25),
  email         VARCHAR(255),
  username      VARCHAR(25),
  sec_question  VARCHAR(255),
  sec_answer    VARCHAR(255)
);
