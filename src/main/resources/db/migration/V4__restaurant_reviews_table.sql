DROP TABLE IF EXISTS restaurant_reviews CASCADE;

CREATE TABLE restaurant_reviews (
id SERIAL PRIMARY KEY,
restaurant_rating INTEGER NOT NULL,
health_dept_rating INTEGER,
location_id INTEGER REFERENCES locations(id)
);