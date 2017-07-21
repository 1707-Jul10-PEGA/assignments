/* 8.0 Indexes */

/* 8.1 Clustered Indexes */
/* Create a clustered index on a table */
CREATE TABLE myTable (
    myId INT,
    myValue VARCHAR2(255),
    CONSTRAINT myPk PRIMARY KEY (myId)
    )
    ORGANIZATION INDEX;

INSERT INTO myTable
    VALUES(1, 'Hello');

SELECT *
FROM myTable;