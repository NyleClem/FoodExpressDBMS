USE FoodExpress2;

UPDATE Customer
SET Address  = '45 Apple Lane', Phone= '(443) 999-0102'
WHERE CustomerID = 1;
UPDATE Customer
SET Address  = '112 Holly court', Phone= '(443) 890-2229'
WHERE CustomerID = 2;
UPDATE Customer
SET Address  = '34th street', Phone= '(443) 390-0056'
WHERE CustomerID = 3;

UPDATE Driver
SET DriverName = 'Charlie Brown', Phone ='(443) 987-001'
WHERE DriverID =100;
UPDATE Driver
SET DriverName = 'Lily Rose', Phone ='(443) 334-2111'
WHERE DriverID =200;
UPDATE Driver
SET DriverName = 'Stacy Fakename', Phone = '(443) 555-5555'
WHERE DriverID =300;


Select V.Location, V.VendorName,M.ItemName,M.Price FROM Vendor V
LEFT JOIN MenuItem M ON  V.VendorID = M.VendorID
Where V.VendorID = 1
Order BY M.Price DESC;

-- There was A driver with an ID 300 but it was deleted 
DELETE FROM Driver WHERE DriverID = 300;
Select DriverName, Phone From Driver;

Select V.VendorName, COUNT(M.VendorID) AS 'Numbers of items'
FROM Vendor V
LEFT JOIN MenuItem M ON M.VendorID = V.VendorID
GROUP BY V.VendorName;






