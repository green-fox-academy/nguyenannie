/*list all tables*/
SELECT TABLE_NAME FROM information_schema.tables
where TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = 'bookstore';

/*select all data from all tables*/
SELECT * FROM author, book_mast, category, despatch, newpublisher,;

/*create a query selecting all books with its name, authors name, category name, publishers name and price*/
SELECT bm.book_name, au.aut_name, cat.cate_descrip, pub.pub_name, bm.book_price FROM book_mast AS bm
LEFT JOIN author AS au ON bm.aut_id = au.aut_id
LEFT JOIN category AS cat ON bm.cate_id = cat.cate_id
LEFT JOIN publisher AS pub ON bm.pub_id =pub.pub_id;
