USE FoodExpress;

UPDATE Vendor
SET Location = '286 5th Avenue', VendorName= 'Dominos'
WHERE VendorID = 1;
UPDATE Vendor
SET Location = '48 Baker Street', VendorName= 'Five Guys'
WHERE VendorID = 2;
UPDATE Vendor
SET Location = '345 Jackson Blvd', VendorName= 'Pandora'
WHERE VendorID = 3;
UPDATE Vendor
SET Location = '21th Maple Street', VendorName= 'IHOP'
WHERE VendorID = 4;
UPDATE Vendor
SET Location = '68 Oak Street', VendorName= 'Dennys'
WHERE VendorID = 5;

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






