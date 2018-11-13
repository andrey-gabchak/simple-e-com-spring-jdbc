CREATE TABLE ROLE (
  NAME VARCHAR(10) PRIMARY KEY
);

CREATE TABLE USER_TO_ROLE (
  FK_USER_ID BIGINT NOT NULL,
  FK_ROLE_ID VARCHAR (10) NOT NULL,
  PRIMARY KEY (FK_USER_ID, FK_ROLE_ID),
  CONSTRAINT FK_UTR_USERS FOREIGN KEY (FK_USER_ID)
  REFERENCES USERS(ID),
  CONSTRAINT FK_UTR_ROLES FOREIGN KEY (FK_ROLE_ID)
  REFERENCES ROLE(NAME)
);

CREATE TABLE ORDERS (
  ORDER_ID LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
  CUSTOMER_ID LONG NOT NULL,
  EMPLOYEE_ID LONG,
  ORDER_DATE DATE,
  COMMENT TEXT,
  ORDER_DETAIL_ID LONG NOT NULL
);

CREATE TABLE ORDER_DETAILS (
  ORDER_DETAIL_ID LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ORDER_ID LONG NOT NULL,
  PRODUCT_ID LONG NOT NULL,
  PRODUCT_QUANTITY LONG NOT NULL,
  ORDER_AMOUNT DOUBLE NOT NULL
);

ALTER TABLE ORDERS
  ADD CONSTRAINT FK_ORDER_DETAIL
FOREIGN KEY (ORDER_DETAIL_ID)
REFERENCES ORDER_DETAILS(ORDER_DETAIL_ID);

ALTER TABLE ORDER_DETAILS
  ADD CONSTRAINT FK_ORDER
FOREIGN KEY (ORDER_ID)
REFERENCES ORDERS(ORDER_ID);