CREATE TABLE SS_Product (
    Product_ID int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Product_Name VARCHAR(20) NOT NULL,
    Product_Description VARCHAR(100) NOT NULL,
    Product_Color VARCHAR(20) NOT NULL,
    Product_Size decimal(10,2) NOT NULL,
    Product_Price decimal(10,2) NOT NULL
);

INSERT INTO SS_Product (Product_Name, Product_Description, Product_Color, Product_Size, Product_Price)
VALUES ('Nike Zoom', 'Running Shoes made for wet weather protection',
        'Black', 8.00, 80.00);

INSERT INTO SS_Product (Product_Name, Product_Description, Product_Color, Product_Size, Product_Price)
VALUES ('Puma Sneakers', 'Breathable for everyday use', 'White',
        6.5, 70.00)
