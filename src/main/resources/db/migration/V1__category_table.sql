DROP TABLE IF EXISTS restaurant_categories CASCADE;
CREATE TABLE restaurant_categories (
id SERIAL PRIMARY KEY,
type VARCHAR(255) NOT NULL,
img TEXT NOT NULL,
description TEXT
);