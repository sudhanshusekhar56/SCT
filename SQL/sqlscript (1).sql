REM   Script: session02
REM   altering table, adding new columns

alter table customer add title varchar2(4) check (title in ('Mr.','Mrs.'));

alter table customer add billNumber number(5);

