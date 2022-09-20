ALTER TABLE todo ADD description varchar(255);

UPDATE todo set description="add some data to check migration result";