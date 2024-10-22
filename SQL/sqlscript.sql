REM   Script: session01
REM   creating customer table and inserting data

CREATE TABLE customer ( 
    consumer_id NUMBER(13) PRIMARY KEY, -- 13-digit consumer ID, primary key 
    customer_name VARCHAR2(50) NOT NULL, -- Customer name with a max of 50 characters 
    email VARCHAR2(100) NOT NULL, -- Email field 
    mobile_number VARCHAR2(10) NOT NULL, -- 10-digit mobile number 
    user_id VARCHAR2(20) NOT NULL, -- User ID, minimum 5 and max 20 characters 
    password VARCHAR2(30) NOT NULL, -- Password with a max of 30 characters 
    confirm_password VARCHAR2(30) NOT NULL, -- Confirm password with a max of 30 characters 
    status VARCHAR2(8) CHECK (status IN ('Active', 'Inactive')) NOT NULL -- Status can be 'Active' or 'Inactive' 
);

INSERT INTO customer (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status) 
VALUES  
(1234567890123, 'John Doe', 'john.doe@example.com', '9876543210', 'john_d', 'password123', 'password123', 'Active');

INSERT INTO customer (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status) 
VALUES  
(1234567890124, 'Jane Smith', 'jane.smith@example.com', '9876543211', 'jane_s', 'mypassword456', 'mypassword456', 'Inactive');

INSERT INTO customer (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status) 
VALUES  
(1234567890125, 'Mark Johnson', 'mark.j@example.com', '9876543212', 'mark_j', 'markpass789', 'markpass789', 'Active');

INSERT INTO customer (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status) 
VALUES  
(1234567890126, 'Emily Davis', 'emily.d@example.com', '9876543213', 'emily_d', 'password456', 'password456', 'Active');

INSERT INTO customer (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status) 
VALUES  
(1234567890127, 'Michael Brown', 'michael.b@example.com', '9876543214', 'mike_b', 'pass1234', 'pass1234', 'Inactive');

