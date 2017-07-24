/* 7.0 Triggers */

CREATE OR REPLACE TRIGGER newCategoryTrigger
    AFTER INSERT ON Category
    FOR EACH ROW
    
    DECLARE
        v_cid NUMBER;
    
    BEGIN
        -- after a new record is inserted into category,
        -- store the category id
        SELECT CatId INTO v_cid FROM Category;
    END;
/

CREATE OR REPLACE TRIGGER updatedCategoryTrigger
    AFTER UPDATE ON Category
    FOR EACH ROW
    
    DECLARE
        v_cid NUMBER;
       
    BEGIN
        -- when a record in the category table is updated,
        -- store its category id
        SELECT CatId INTO v_cid FROM Category;
    END;
/

CREATE OR REPLACE TRIGGER deletedCategoryTrigger
    AFTER DELETE ON Category
    FOR EACH ROW
    
    DECLARE
        v_cid NUMBER;
    
    BEGIN
        -- after a category is deleted,
        -- store the deleted category id
        SELECT CatId INTO v_cid FROM Category;
    END;
/

/* Create a view first to use the instead of trigger */
CREATE VIEW ProductPrices AS
SELECT UnitCost
FROM Product;

CREATE OR REPLACE TRIGGER restrictProductDelete
    INSTEAD OF DELETE ON ProductPrices
    FOR EACH ROW
    
    DECLARE
        v_unitCost NUMBER;
        
    BEGIN
        -- instead of deleting a product,
        -- first check if the total is priced above 500.
        -- if it is, delete it
        
        SELECT UnitCost INTO v_unitCost FROM ProductPrices;
        
        IF (v_unitCost > 500) THEN
            DELETE FROM ProductPrices
            WHERE v_unitCost > 500;
        END IF;
    END;
/