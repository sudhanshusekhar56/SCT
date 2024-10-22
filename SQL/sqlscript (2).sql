REM   Script: Session 03
REM   retrieving data from customer table for name ending with 'a'

select * from customer where customer_name like '%a' order by customer_name desc;

select consumer_id, customer_name, email from customer where customer_name like '%a' order by customer_name desc;

