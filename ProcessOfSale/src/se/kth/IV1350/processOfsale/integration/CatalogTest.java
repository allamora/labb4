package se.kth.IV1350.processOfsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.model.InvalidItemException;
import se.kth.IV1350.processOfsale.integration.Catalog;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void checkDatabaseConnection () throws InvalidItemException, DatabaseConnectionFailException{

        try {
            Catalog.getDescription(11111111);
            fail("Expected exception");
        }

        catch (DatabaseConnectionFailException exc) {

    }




}

}