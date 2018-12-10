--Question 2.1 Select all records from the Employee table.
SELECT *
FROM EMPLOYEE;

-- Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--QUESTION 2.2 Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

--Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--QUESTION 2.3 Insert two new records into Genre table 
INSERT ALL
INTO GENRE
VALUES(26,'Country')
INTO GENRE
VALUES(27,'Folk')
SELECT * FROM DUAL;

-- Insert two new records into Employee table
INSERT ALL
INTO EMPLOYEE
VALUES (9,'Sparrow', 'Jack', 'Pirate',1,TO_DATE('1970-04-19 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2014-08-20 00:00:00','yyyy-mm-dd hh24:mi:ss'),'1080 Private Dr.','Tampa','FL','USA','T2P 2T3','+1 (321) 123-3214','+1 (403) 467-8780','sparrow@chinookcorp.com')
INTO EMPLOYEE
VALUES (10,'Dumbledore', 'Albus', 'Headmaster',NULL,TO_DATE('1902-08-19 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('1940-08-20 00:00:00','yyyy-mm-dd hh24:mi:ss'),'1 Hogwarts Lane','London','LANCASTER','ENGLAND','T2P 4TF','+1 (321) 123-5555','+1 (403) 467-5555','dumbledore@chinookcorp.com')
SELECT * FROM DUAL;

-- Insert two new records into Customer table
INSERT ALL
INTO CUSTOMER
VALUES (60,'Harry', 'Potter',NULL,'4 Privet Drive','Whinging','England',NULL,'SW1V 3EN','+44 020 7777 5722',NULL,'potter@hogwarts.edu',5)
INTO CUSTOMER
VALUES (61,'Ron', 'Weasley',NULL,'1999 Magical Way','Whinging','England',NULL,'SW1V 3EN','+44 020 7777 8888',NULL,'weasley@hogwarts.edu',5)
SELECT * FROM DUAL;

--2.4 Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME  = 'Robert'
WHERE FIRSTNAME = 'Aaron';
UPDATE CUSTOMER SET LASTNAME  = 'Walter'
WHERE LASTNAME = 'Mitchell';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--QUESTION 2.5  Select all invoices with a billing address like “T%” 
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--QUESTION 2.6 Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT EMPLOYEEID
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

--Question 2.7 Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CUSTOMER
DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;

ALTER TABLE CUSTOMER
   ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
   FOREIGN KEY (SUPPORTREPID) REFERENCES EMPLOYEE(EMPLOYEEID) ON DELETE CASCADE;

ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
    ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
    
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
    ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;

DELETE 
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--QUESTION 3.1 Create a function that returns the current time.
SELECT TO_CHAR
    (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')
    FROM DUAL;
    
--create a function that return the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;

--QUESTION 3.2  Create a function that returns the average total of all invoices
SELECT ROUND(AVG(TOTAL),2) FROM INVOICE;

-- Create a function that returns the most expensive track
SELECT *
FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

--QUESTION 3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE),2) FROM INVOICELINE;

-- Create a function that returns all employees who are born after 1968.
SELECT LASTNAME,FIRSTNAME
FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';


