DROP TABLE IF EXISTS restaurant_reviews CASCADE;

CREATE TABLE restaurant_reviews (
id SERIAL PRIMARY KEY,
restaurant_rating INTEGER NOT NULL,
review TEXT,
date_posted TIMESTAMP,
location_id INTEGER REFERENCES locations(id)
);