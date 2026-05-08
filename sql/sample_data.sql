USE FoodExpress2;

Insert INTO Vendor Values
(1,'Dominos','286 5th Avenue'),
(2,'Five Guys', '48 Baker Street'),
(3,'Panera Bread', '345 Jackson Blvd'),
(4,'IHOP','21th Maple Street'),
(5,'Dennys','68 Oak Street')
;

INSERT INTO MenuItem Values
(001, 01,'Large Meats Pizza',12.99),
(002, 01,'Large Cheese Pizza', 10.99),
(003, 01,'Large Veggie Pizza',13.99),
(004, 01, 'Large Fries',5.99),
(005, 01, 'Small Fries', 3.99),
(006, 01,'6 pic Wings', 6.99),
(101, 02, 'Burger',5.99),
(102, 02, 'Cheese Burger', 7.99), 
(103,02,'Large Fries',6.99),
(104, 02,'Small Fries',4.99),
(201, 03,'Bacon Turkey Sandwich',8.99),
(202, 03,'Chicken Salad',9.79),
(203, 03,'Broccoli Cheddar Soup', 6.49),
(204, 03,'Mac & Cheese',7.99),
(301, 04,'Buttermilk Pandcakes',9.99),
(302, 04,'Big Steak Omelette', 10.99),
(303,04,'Breakfast Burrito', 11.99),
(304, 04,'Steakburger with fries', 14.99),
(401, 05,'All-American Slam', 13.99),
(402, 05,'Burbon Bacon Burger', 14.99),
(403, 05,'Prime Rib Philly Melt', 12.99),
(404, 05,'Chicken Tenders w/Fries', 10.99);

INSERT INTO Customer VALUES
(1, 'Jame Jackson', 'jamiejackson@email.com','45 Apple Lane','(443) 999-0102'),
(2, 'Sandy Bellock', 'sandyballock03@gmail.com','112 Holly court','(443) 890-2229'),
(3, 'Eddie Brock', 'eddievemon009@gmail.com', '34th street', '(443) 390-0056')
;

INSERT INTO Driver VALUES
(100, '(443) 987-001','Charlie Brown'),
(200, '(443) 334-2111', 'Lily Rose')
;
INSERT INTO Driver Value(300, '(443) 555-5555', 'Stacy Fakename');

 
INSERT INTO Orders
(OrderID, CustomerID, Status, TotalAmount)
VALUES
(1, 1, 'Placed', 18.98),
(2, 2, 'Preparing', 15.98),
(3, 3, 'Delivered', 12.99);
 
 
INSERT INTO OrderItem
(OrderItemID, OrderID, ItemID, Quantity)
VALUES
(1, 1, 001, 1),
(2, 1, 004, 1),
 
(3, 2, 101, 1),
(4, 2, 104, 2),
 
(5, 3, 403, 1);
 
INSERT INTO Delivery
(DeliveryID, OrderID, DriverID, DeliveryStatus)
VALUES
(1, 1, 100, 'Assigned'),
(2, 2, 200, 'Picked Up'),
(3, 3, 300, 'Delivered');

