drop database if exists project;
create database project;
use project;
CREATE TABLE IF NOT EXISTS Employee(
                                       empId INT AUTO_INCREMENT PRIMARY KEY,
                                       password VARCHAR(50) NOT NULL,
                                       firstName VARCHAR(50) NOT NULL,
                                       lastName VARCHAR(50),
                                       contact CHAR(10) NOT NULL,
                                       role ENUM("SA","A","D","WM") NOT NULL
);

CREATE TABLE IF NOT EXISTS Warehouse(
                                        warehouseId INT AUTO_INCREMENT PRIMARY KEY,
                                        street VARCHAR(50),
                                        city VARCHAR(50),
                                        state VARCHAR(50),
                                        pinCode CHAR(6) NOT NULL,
                                        capacity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer(
                                       customerId INT AUTO_INCREMENT PRIMARY KEY,
                                       password VARCHAR(100) NOT NULL,
                                       firstName VARCHAR(50) NOT NULL,
                                       lastName VARCHAR(50),
                                       age INT NOT NULL,
                                       address VARCHAR(100) NOT NULL,
                                       dateOfBirth DATE,
                                       phone CHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS Product(
                                      productId INT AUTO_INCREMENT PRIMARY KEY,
                                      productName VARCHAR(20) NOT NULL,
                                      weight INT,
                                      description VARCHAR(100),
                                      warehouseId INT NOT NULL,
                                      CONSTRAINT FK_WAREHOUSE FOREIGN KEY(warehouseId) REFERENCES Warehouse(warehouseId)
);

CREATE TABLE IF NOT EXISTS Orders(
                                     orderId INT AUTO_INCREMENT PRIMARY KEY,
                                     orderDate DATE NOT NULL,
                                     customerId INT NOT NULL,
                                     productId INT NOT NULL,
                                     quantity INT,
                                     CONSTRAINT FK_CUSTOMERINORDERS FOREIGN KEY(customerId) REFERENCES Customer(customerId),
                                     CONSTRAINT FK_PRODUCTINORDERS FOREIGN KEY(productId) REFERENCES Product(productId)
);

CREATE TABLE IF NOT EXISTS Invoice(
                                      invoiceId INT AUTO_INCREMENT PRIMARY KEY,
                                      address VARCHAR(100),
                                      amount INT NOT NULL,
                                      dateOfPublish DATE NOT NULL,
                                      paymentStatus ENUM("Pending","Success","Failed") NOT NULL,
                                      orderId INT NOT NULL,
                                      CONSTRAINT FK_ORDER FOREIGN KEY(orderId) REFERENCES Orders(orderId)
);

CREATE TABLE IF NOT EXISTS Carrier(
                                      carrierId INT AUTO_INCREMENT PRIMARY KEY,
                                      personName VARCHAR(50) NOT NULL,
                                      contact CHAR(10),
                                      capacity INT,
                                      empId INT NOT NULL,
                                      CONSTRAINT FK_EMP FOREIGN KEY(empId) REFERENCES Employee(empId)
);

CREATE TABLE IF NOT EXISTS Shipment(
                                       shipmentId INT AUTO_INCREMENT PRIMARY KEY,
                                       shipmentDate DATE NOT NULL,
                                       status ENUM("Preparing","Dipatched","Delivered"),
                                       estimatedDeliveryDate DATE NOT NULL,
                                       orderId INT NOT NULL,
                                       customerId INT NOT NULL,
                                       carrierId INT NOT NULL,
                                       CONSTRAINT FK_ORDER2 FOREIGN KEY(orderId) REFERENCES Orders(orderId),
                                       CONSTRAINT FK_CUSTOMER FOREIGN KEY(customerId) REFERENCES Customer(customerId),
                                       CONSTRAINT FK_CARRIER FOREIGN KEY(carrierId) REFERENCES Carrier(carrierId)
);

CREATE TABLE IF NOT EXISTS Complaint(
                                        complaintId INT AUTO_INCREMENT PRIMARY KEY,
                                        customerId INT NOT NULL,
                                        orderId INT NOT NULL,
                                        description VARCHAR(1000) NOT NULL,
                                        email VARCHAR(100) NOT NULL,
                                        CONSTRAINT FK_CUSTOMERINCOMPLAINT FOREIGN KEY(customerId) REFERENCES Customer(customerId),
                                        CONSTRAINT FK_ORDERINCOMPLAINT FOREIGN KEY(orderId) REFERENCES Orders(orderId)
);
show tables;


desc Customer;
insert into Customer(password,firstName,lastName,age,address,dateOfBirth,phone) values(123,hit,pra,18,"dayalbagh","2003-07-06","9758021043");

