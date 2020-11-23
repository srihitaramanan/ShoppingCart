DROP TABLE IF EXISTS cart;
	 
CREATE TABLE cart (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_id INT(20) NOT NULL,
  seller_id INT(20) NOT NULL,
  item_title VARCHAR(250),
  price DECIMAL(10,1),
  tax DECIMAL(10,1)
);
