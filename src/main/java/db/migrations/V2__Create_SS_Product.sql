CREATE TABLE SS_Product (
    Product_ID int NOT NULL PRIMARY KEY,
    Product_Name VARCHAR(20) NOT NULL,
    Product_Description VARCHAR(50) NOT NULL,
    Product_Color VARCHAR(50) NOT NULL,
    Product_Size decimal(10,2) NOT NULL,
    Product_Price decimal(10,2) NOT NULL
);