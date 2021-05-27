ALTER TABLE review_images
DROP COLUMN IF EXISTS location_id CASCADE,
ADD COLUMN restaurant_id INTEGER REFERENCES restaurants(id);

ALTER TABLE restaurant_reviews
DROP COLUMN IF EXISTS location_id CASCADE,
ADD COLUMN restaurant_id INTEGER REFERENCES restaurants(id);

DROP TABLE IF EXISTS locations CASCADE;

ALTER TABLE restaurants
ADD COLUMN address VARCHAR(255) NOT NULL,
ADD COLUMN phone_number VARCHAR(255) NOT NULL,
ADD COLUMN health_dept_rating INTEGER,
ADD COLUMN description TEXT;

