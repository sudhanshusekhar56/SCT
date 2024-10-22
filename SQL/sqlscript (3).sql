REM   Script: Session 04
REM   created consumer table, implemented refrerences and foreign key concept

CREATE TABLE consumer ( 
  name VARCHAR2(50) NOT NULL, 
  address VARCHAR2(255), 
  city VARCHAR2(100) NOT NULL, 
  bill_number NUMBER(5) PRIMARY KEY, 
  bill_amount NUMBER(10, 2) NOT NULL, 
  consumer_id NUMBER(13), 
  CONSTRAINT fk_consumer_customer FOREIGN KEY (consumer_id) REFERENCES customer(consumer_id) 
);

 desc consumer


INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890124, 'Jane Smith', '123 Elm St', 'New York', 10001, 120.50);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890124, 'Jane Smith', '123 Elm St', 'New York', 10002, 150.75);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890124, 'Jane Smith', '123 Elm St', 'New York', 10003, 90.20);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890125, 'Mark Johnson', '456 Oak Ave', 'Los Angeles', 10004, 200.00);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890125, 'Mark Johnson', '456 Oak Ave', 'Los Angeles', 10005, 180.35);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890125, 'Mark Johnson', '456 Oak Ave', 'Los Angeles', 10006, 220.10);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890126, 'Emily Davis', '789 Pine St', 'Chicago', 10007, 170.45);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890126, 'Emily Davis', '789 Pine St', 'Chicago', 10008, 195.75);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890127, 'Michael Brown', '101 Cedar Rd', 'Houston', 10009, 105.65);

INSERT INTO consumer (consumer_id, name, address, city, bill_number, bill_amount)  
VALUES (1234567890127, 'Michael Brown', '101 Cedar Rd', 'Houston', 10010, 130.20);

select * from consumer;

select avg(bill_amount),city as average_bill from consumer group by city order by city desc;

