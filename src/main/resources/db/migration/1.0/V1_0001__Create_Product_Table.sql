create table PRODUCT
(
    PRODUCT_NO  INT not null,
    NAME        varchar(50) null,
    DESCRIPTION varchar(200) null,
    price       INT null,
    CONSTRAINT PK_PRODUCT PRIMARY KEY (PRODUCT_NO)
);

create sequence S_PRODUCT_0
    START WITH 1
    INCREMENT BY 10;