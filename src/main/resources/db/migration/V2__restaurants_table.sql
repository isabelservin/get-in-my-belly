DROP TABLE IF EXISTS restaurants CASCADE;
CREATE TABLE restaurants (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
image_url TEXT,
restaurant_type_id INTEGER REFERENCES restaurant_categories(id)
);