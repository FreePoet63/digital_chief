CREATE TABLE IF NOT EXISTS authors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    died_date DATE,
    birth_city VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    price VARCHAR(255) NOT NULL,
    circulation INT NOT NULL,
    author_id BIGINT REFERENCES authors(id)
);