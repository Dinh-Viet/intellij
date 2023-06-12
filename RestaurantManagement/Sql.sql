CREATE TABLE Admin (
    admin_id INT PRIMARY KEY,
    admin_name VARCHAR(50),
    admin_email VARCHAR(50),
    admin_password VARCHAR(50)
);

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(50),
    user_email VARCHAR(50),
    user_password VARCHAR(50)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY, 
    order_date DATE,
	user_id INT FOREIGN KEY REFERENCES Users(user_id)
);

CREATE TABLE Food (
    food_id INT PRIMARY KEY,
    food_name VARCHAR(50),
    food_price DECIMAL(10, 2)
);

CREATE TABLE Drink (
    drink_id INT PRIMARY KEY,
    drink_name VARCHAR(50),
    drink_price DECIMAL(10, 2)
);

CREATE TABLE Order_Food (
    order_food_id INT PRIMARY KEY,
    quantity INT,
	order_id INT FOREIGN KEY REFERENCES Orders(order_id),
	food_id INT FOREIGN KEY REFERENCES Food(food_id)
);

CREATE TABLE Order_Drink (
    order_drink_id INT PRIMARY KEY,
    quantity INT,
    order_id INT FOREIGN KEY REFERENCES Orders(order_id),
    drink_id INT FOREIGN KEY REFERENCES Drink(drink_id)
);