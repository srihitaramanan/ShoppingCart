1. Import this "shoppingcart" project as maven project into eclipse IDE or any of your fav IDE
2. Run Maven Build using command "clean install" in eclipse
   if you are building via cmd use "mvn clean install"
3. Once maven build is success, Run the application
4. To run application open the class "ShoppingcartApplication.java" and run it as java application
5. You can find console log that Tomcat server started on 8080 port. like below,
   -->Tomcat started on port(s): 8080 (http) with context path '/checkout'
   also you will see below one, that means your application running
   -->Started ShoppingcartApplication in 12.082 seconds (JVM running for 13.161)

6. We are using in memory H2 database for data persistance.
7. You can launch the DB using URL http://localhost:8080/checkout/h2-console
8. Username/Password are sa/password
9. after login to H2 db console run the below scripts

CREATE TABLE cart (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  item_id BIGINT(20) NOT NULL,
  seller_id BIGINT(20) NOT NULL,
  item_title VARCHAR(250),
  price DECIMAL(10,1),
  tax DECIMAL(10,1)
);

CREATE SEQUENCE cart_seq
  START WITH 1
  INCREMENT BY 1
  NO CACHE;

10. After this, execute the APIs from any Rest client Ex: postman
    in request header set content-type as "application/json"

11. Please find the below API end point details with execution result.


Task 1. Create Cart API - POST 
-------------------------------
End point - http://localhost:8080/checkout/api/v1/createCart

Request1:

   {
        "itemId" : 123434343442,
        "sellerId" : 4321678,
        "itemTitle" : "apple iphone 8 cover",
        "price" : 60.00,
        "tax" : 5.00
   }

Response1:
 {
    "cartId": "1"
 }

Request2:
 {
        "itemId" : 123434343480,
        "sellerId" : 4321678,
        "itemTitle" : "apple iphone XR cover",
        "price" : 65.00,
        "tax" : 6.00
 }

Response2:
{
    "cartId": "2"
}


Task 2: Get Cart Details API - GET
-----------------------------------
End point - http://localhost:8080/checkout/api/v1/cart/1

Request1 : Passing cartId = 1

Response1:
{
    "itemId": 123434343442,
    "sellerId": 4321678,
    "itemTitle": "apple iphone 8 cover",
    "price": 60.0,
    "tax": 5.0
}

http://localhost:8080/checkout/api/v1/cart/2

Request2 : Passing cartId = 2

Response2:
{
    "itemId": 123434343480,
    "sellerId": 4321678,
    "itemTitle": "apple iphone XR cover",
    "price": 65.0,
    "tax": 6.0
}

12. You can verify your data in DB using below SQL query.
SELECT * FROM cart;
