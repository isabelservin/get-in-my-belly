DROP TABLE IF EXISTS locations;
CREATE TABLE locations (
id serial PRIMARY KEY,
address VARCHAR(255) NOT NULL,
phone_number VARCHAR(255) NOT NULL,
image_url TEXT,
health_dept_rating INTEGER,
restaurant_id INTEGER REFERENCES restaurants(id)
);