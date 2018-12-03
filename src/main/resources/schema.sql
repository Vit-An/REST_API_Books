INSERT INTO `authors` VALUES (1,'1951-06-10' , 'male','Шкляр Василь Миколайович' );
INSERT INTO `authors` VALUES (2,'1961-07-28' , 'male','Joshua Bloch' );
INSERT INTO `authors` VALUES (3, null, 'male', 'Martin Fowler' );
INSERT INTO `authors` VALUES (4,  null, 'male','Chad Fowler');
INSERT INTO `authors` VALUES (5,'1965-07-31' , 'female','J. K. Rowling' );
INSERT INTO `authors` VALUES (6,'1964-06-22' , 'male','Dan Brown' );
INSERT INTO `authors` VALUES (7, '1962-08-10', 'female','Suzanne Collins' );

INSERT INTO `books` VALUES (1, 'historical novel', 'Залишенець. Чорний ворон', null,  5);
INSERT INTO `books` VALUES (2, 'novel','Ключ', '1999-01-01',  3);
INSERT INTO `books` VALUES (3, 'technical','Effective Java: Programming Language Guide', '2001-03-02',  5);
INSERT INTO `books` VALUES (4, 'technical','Java Concurrency in Practice', '2006-04-23',  '4');
INSERT INTO `books` VALUES (5, 'technical','Java Puzzlers: Traps, Pitfalls, and Corner Cases', '2005-02-02',  4);
INSERT INTO `books` VALUES (6, 'technical','Patterns of Enterprise Application Architecture', '2002-06-25', 3);
INSERT INTO `books` VALUES (7, 'fantasy','Harry Potter and the Philosophers Stone', '1997-06-26',  5);
INSERT INTO `books` VALUES (8, 'education','The Passionate Programmer', '1999-09-21',  5);
INSERT INTO `books` VALUES (9, 'crime','The Lost Symbol', null,  4);

INSERT INTO `author_book` VALUES (1, 1);
INSERT INTO `author_book` VALUES (1, 2);
INSERT INTO `author_book` VALUES (2, 3);
INSERT INTO `author_book` VALUES (2, 4);
INSERT INTO `author_book` VALUES (2, 5);
INSERT INTO `author_book` VALUES (3, 6);
INSERT INTO `author_book` VALUES (6, 9);
INSERT INTO `author_book` VALUES (4, 8);
INSERT INTO `author_book` VALUES (5, 7);