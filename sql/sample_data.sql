USE FoodExpress;

Insert INTO Vendor Values
(01,'Dominos','286 5th Avenue'),
(02, 'Five Guys', '48 Baker Street'),
(03,'Panera Bread', '345 Jackson Blvd'),
(04,'IHOP','21th Maple Street'),
(05,'Dennys','68 Oak Street')
;

INSERT INTO MenuItem Values
(001,'Large Meats Pizza',12.99,01),
(002,'Large Cheese Pizza', 10.99,01),
(003,'Large Veggie Pizza',13.99,01),
(004, 'Large Fries',5.99,01),
(005, 'Small Fries', 3.99,01),
(006, '6 pic Wings', 6.99,01),
(101, 'Burger',5.99,02),
(102, 'Cheese Burger', 7.99,02), 
(103,'Large Fries',6.99,02),
(104, 'Small Fries',4.99,02),
(201,'Bacon Turkey Sandwich',8.99,03),
(202, 'Chicken Salad',9.79,03),
(203, 'Broccoli Cheddar Soup', 6.49,03),
(204, 'Mac & Cheese',7.99,03),
(301,'Buttermilk Pandcakes',9.99,04),
(302, 'Big Steak Omelette', 10.99,04),
(303,'Breakfast Burrito', 11.99,04),
(304, 'Steakburger with fries', 14.99,04),
(401, 'All-American Slam', 13.99,05),
(402, 'Burbon Bacon Burger', 14.99,05),
(403, 'Prime Rib Philly Melt', 12.99,05),
(404, 'Chicken Tenders w/Fries', 10.99,05)
;

INSERT INTO Customer VALUES
(1, 'Jame Jackson', 'jamiejackson@email.com','45 Apple Lane','(443) 999-0102'),
(2, 'Sandy Bellock', 'sandyballock03@gmail.com','112 Holly court','(443) 890-2229'),
(3, 'Eddie Brock', 'eddievemon009@gmail.com', '34th street', '(443) 390-0056')
;

INSERT INTO Orders VALUES 
(01,'Complete','15 mins',001,1),
(02, 'Complete', '10 mins',101, 2),
(03, 'In-Progress', '30 mins',303,2)
;

INSERT INTO Driver VALUES
(100, '(443) 987-001','Charlie Brown'),
(200, '(443) 334-2111', 'Lily Rose')
;

INSERT INTO Delivery VALUES 
(1,'Complete', '34th street', '5:30pm', 01,100),
(2, 'Complete', '34th street', '3:25pm', 02,200),
(3, 'In-Progress', '112 Holly Court', NULL, 03,200)
;