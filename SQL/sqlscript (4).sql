REM   Script: Session 05
REM   created monthlyBill table and implemented join to extract data from one table depending on some condition from other table

create table MonthlyBill ( 
     consumer_id NUMBER(13) primary key, 
    status varchar2(6) check (status in ('paid','unpaid')), 
    constraint fk_constraint foreign key (consumer_id ) references customer(consumer_id)  
);

select c.customer_name, c.consumer_id from customer c where c.consumer_id in (select b.consumer_id from monthlybill b where b.status = 'unpaid');

INSERT INTO MonthlyBill (consumer_id, status) 
VALUES (1234567890124, 'paid');

INSERT INTO MonthlyBill (consumer_id, status) 
VALUES (1234567890125, 'unpaid');

INSERT INTO MonthlyBill (consumer_id, status) 
VALUES (1234567890126, 'paid');

INSERT INTO MonthlyBill (consumer_id, status) 
VALUES (1234567890127, 'unpaid');

select c.customer_name, c.consumer_id from customer c where c.consumer_id in (select b.consumer_id from monthlybill b where b.status = 'unpaid');

