DROP TABLE IF EXISTS review_images CASCADE;
CREATE TABLE review_images (
id serial PRIMARY KEY,
image_url TEXT NOT NULL,
alt_text TEXT,
location_id INTEGER REFERENCES locations(id),
review_id INTEGER REFERENCES restaurant_reviews(id)
);