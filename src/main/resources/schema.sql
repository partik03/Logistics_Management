drop database if exists project;
create database project;
use project;
CREATE TABLE IF NOT EXISTS User(
                                   userId INT AUTO_INCREMENT PRIMARY KEY,
                                   username VARCHAR(50) UNIQUE NOT NULL,
                                   password VARCHAR(100) NOT NULL,
                                   firstName VARCHAR(50) NOT NULL,
                                   lastName VARCHAR(50),
                                   contact CHAR(10) NOT NULL,
                                   age INT NOT NULL,
                                   enabled boolean default true,
                                   address VARCHAR(100) NOT NULL,
                                   dateOfBirth DATE,

                                   authority ENUM("SA","A","D","WM","C") NOT NULL
);

CREATE TABLE IF NOT EXISTS Warehouse(
                                        warehouseId INT AUTO_INCREMENT PRIMARY KEY,
                                        street VARCHAR(50),
                                        city VARCHAR(50),
                                        state VARCHAR(50),
                                        pinCode CHAR(6) NOT NULL,
                                        capacity INT NOT NULL,
                                        userId INT,
                                        CONSTRAINT FK_WM_EMP FOREIGN KEY(userId) REFERENCES User(userId)
);

CREATE TABLE IF NOT EXISTS Product(
                                      productId INT AUTO_INCREMENT PRIMARY KEY,
                                      productName VARCHAR(20) NOT NULL,
                                      weight INT,
                                      description VARCHAR(100),
                                      userId INT NOT NULL,
                                      CONSTRAINT FK_PRODUCTINUSER FOREIGN KEY(userId) REFERENCES User(userId)
);

CREATE TABLE IF NOT EXISTS Orders(
                                     orderId INT AUTO_INCREMENT PRIMARY KEY,
                                     orderDate DATE,
                                     sendersName VARCHAR(100),
                                     recieversName VARCHAR(100),
                                     sendersEmail VARCHAR(100),
                                     recieversEmail VARCHAR(100),
                                     sendersPhone INT,
                                     recieversPhone INT,
                                     sendersAddress VARCHAR(100),
                                     recieversAddress VARCHAR(100),
                                     userId INT NOT NULL,
                                     productId INT NOT NULL,
                                     CONSTRAINT FK_userINORDERS FOREIGN KEY(userId) REFERENCES User(userId),
                                     CONSTRAINT FK_PRODUCTINORDERS FOREIGN KEY(productId) REFERENCES Product(productId)
);

CREATE TABLE IF NOT EXISTS Invoice(
                                      invoiceId INT AUTO_INCREMENT PRIMARY KEY,
                                      address VARCHAR(100),
                                      amount INT NOT NULL,
                                      dateOfPublish DATE NOT NULL,
                                      paymentStatus ENUM("Pending","Success","Failed") NOT NULL,
                                      orderId INT NOT NULL UNIQUE,
                                      CONSTRAINT FK_ORDER FOREIGN KEY(orderId) REFERENCES Orders(orderId)
);

CREATE TABLE IF NOT EXISTS Carrier(
                                      carrierId INT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(50) NOT NULL,
                                      number VARCHAR(50),
                                      capacity INT,
                                      userId INT,
                                      CONSTRAINT FK_EMP FOREIGN KEY(userId) REFERENCES User(userId)
);

CREATE TABLE IF NOT EXISTS Shipment(
                                       shipmentId INT AUTO_INCREMENT PRIMARY KEY,
                                       shipmentDate DATE NOT NULL,
                                       status ENUM("Preparing","Dispatched","Delivered"),
                                       estimatedDeliveryDate DATE NOT NULL,
                                       orderId INT NOT NULL,
                                       warehouseId INT,
                                       carrierId INT,
                                       CONSTRAINT FK_ORDER2 FOREIGN KEY(orderId) REFERENCES Orders(orderId),
                                       CONSTRAINT FK_user FOREIGN KEY(warehouseId) REFERENCES Warehouse(warehouseId),
                                       CONSTRAINT FK_CARRIER FOREIGN KEY(carrierId) REFERENCES Carrier(carrierId)
);

CREATE TABLE IF NOT EXISTS Complaint(
                                        complaintId INT AUTO_INCREMENT PRIMARY KEY,
                                        userId INT NOT NULL,
                                        orderId INT NOT NULL,
                                        description VARCHAR(1000) NOT NULL,
                                        email VARCHAR(100) NOT NULL,
                                        CONSTRAINT FK_USERINCOMPLAINT FOREIGN KEY(userId) REFERENCES User(userId),
                                        CONSTRAINT FK_ORDERINCOMPLAINT FOREIGN KEY(orderId) REFERENCES Orders(orderId)
);
INSERT INTO User values(1,"user@gmail.com","user","user","user","0000000000",20,1,"user","2003-10-10","SA");
INSERT INTO Carrier values(1,"BlankCarrier","0000",9999,1);
INSERT INTO Warehouse values(1,"blank","blank","blank","000000",9999,1);

CREATE INDEX Complaint_User ON Complaint(userId);
CREATE INDEX Shipment_Orders ON Shipment(orderId);
CREATE INDEX Carrier_User ON Carrier(userId);
CREATE INDEX Invoice_Orders ON Invoice(orderId);
CREATE INDEX Orders_User ON Orders(userId);
CREATE INDEX Product_User ON Product(userId);
CREATE INDEX Warehouse_User ON Warehouse(userId);
CREATE INDEX User_Username ON User(username);

-- select * from User;	
-- select * from Product;
-- select username, password from User where username="hitanshumusicz@gmail.com";
-- update user set authority="A" where userId=1;