CREATE TABLE IF NOT EXISTS item (
	id INT GENERATED ALWAYS AS IDENTITY,
	item_name VARCHAR(250) NOT NULL,
	item_desc VARCHAR(250) NOT NULL,
	item_url VARCHAR(250),
	category INT NOT NULL,
	status VARCHAR(250),
	status_date DATE NOT NULL,
	primary key (id),
	FOREIGN KEY (category) REFERENCES category(id)
);