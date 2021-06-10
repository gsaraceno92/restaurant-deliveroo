-- Set category field required
ALTER TABLE foods MODIFY category varchar(100) NOT NULL;

ALTER TABLE drinks MODIFY category varchar(100) NOT NULL;