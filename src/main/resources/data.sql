INSERT INTO authors (first_name, last_name, birth_date, died_date, birth_city)
SELECT 'Leo', 'Tolstoy', '1828-09-09', '1910-11-07', 'Yasnaya Polyana'
WHERE NOT EXISTS(SELECT 1 FROM authors);
INSERT INTO authors (first_name, last_name, birth_date, died_date, birth_city)
SELECT 'F.Scott', 'Fitzgerald', '1896-09-24', '1940-12-21', 'St. Paul'
WHERE NOT EXISTS(SELECT 1 FROM authors WHERE last_name = 'Fitzgerald');
INSERT INTO authors (first_name, last_name, birth_date, died_date, birth_city)
SELECT 'Agatha', 'Christie', '1890-09-15', '1976-01-12', 'Torquay'
WHERE NOT EXISTS(SELECT 1 FROM authors WHERE last_name = 'Christie');
INSERT INTO authors (first_name, last_name, birth_date, died_date, birth_city)
SELECT 'Anton', 'Chekhov', '1860-01-29', '1904-07-15', 'Taganrog'
WHERE NOT EXISTS(SELECT 1 FROM authors WHERE last_name = 'Chekhov');
INSERT INTO authors (first_name, last_name, birth_date, died_date, birth_city)
SELECT 'Haruki', 'Murakami', '1949-01-12', NULL, 'Sasebo'
WHERE NOT EXISTS(SELECT 1 FROM authors WHERE last_name = 'Murakami');

INSERT INTO books (title, genre, year, price, circulation, author_id)
SELECT 'War and Peace', 'Novel', 1869, '$120.00', 1000000, 1
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'War and Peace');
INSERT INTO books (title, genre, year, price, circulation, author_id)
SELECT 'Anna Karenina', 'Novel', 1878, '$100.00', 900000, 1
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'Anna Karenina');
INSERT INTO books (title, genre, year, price, circulation, author_id)
SELECT 'The Great Gatsby', 'Fiction', 1925, '$95.00', 1500000, 2
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'The Great Gatsby');
INSERT INTO books (title, genre, year, price, circulation, author_id)
SELECT 'And Then There Were None', 'Detective Novel', 1939, '$70.00', 1750000, 3
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'And Then There Were None');
INSERT INTO books (title, genre ,year ,price ,circulation ,author_id)
SELECT 'The Mousetrap', 'Detective Novel', 1947,'$67.00',1600000 ,3
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'The Mousetrap');
INSERT INTO books (title ,genre ,year ,price ,circulation ,author_id)
SELECT 'Cards on the Table','Detective Novel' ,1936 ,'$69.00' ,1300000 ,3
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'Cards on the Table');
INSERT INTO books (title ,genre ,year ,price ,circulation ,author_id)
SELECT 'Curtain','Detective Novel' ,1975 ,'$73.00' ,1111000 ,3
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'Curtain');
INSERT INTO books (title ,genre ,year ,price,circulation ,author_id)
SELECT 'The Cherry Orchard','Drama' ,1904 ,'$99.00' ,1420000 ,4
WHERE NOT EXISTS(SELECT 1 FROM books WHERE title = 'The Cherry Orchard');