package se.kth.IV1350.processOfsale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.Catalog;
import se.kth.IV1350.processOfsale.integration.DatabaseConnectionFailException;
import se.kth.IV1350.processOfsale.model.InvalidItemException;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    Sale sale;

    @BeforeEach
    void setUp() {

         sale = new Sale();
    }

    @AfterEach
    void tearDown() {

         sale = null;
    }

    @Test
    void calculateCorrectTotalPayment() throws InvalidItemException, DatabaseConnectionFailException {

       double result = sale.calculateTotalPayment(12222113);

       assertEquals (67.2,result, "Wrong Payment");

    }

    @Test
    void checkInvalidItem () throws InvalidItemException, DatabaseConnectionFailException{

        try {
            sale.calculateTotalPayment(33657422);
            fail("Expected exception");

        }

        catch (InvalidItemException exc) {

          assertEquals( 33657422, exc.getInvalidItemIdentifier()); //handlerOfExceptionMessage
          assertEquals (33657422, exc.getInvalidItemIdentifier()); //handlerOfLog
        }

    }

}