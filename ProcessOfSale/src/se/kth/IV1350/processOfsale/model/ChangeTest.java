package se.kth.IV1350.processOfsale.model;

import se.kth.IV1350.processOfsale.model.Sale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTest {

    private Sale sale;
    private double cashFromCustomer;
    private double payment;

    @BeforeEach
    void setUp() {

        sale = new Sale();

        cashFromCustomer = 500;
        payment = sale.getTotalPayment();
    }

    @AfterEach
    void tearDown() {

        cashFromCustomer = 0;
        payment = 0;
    }

    @Test
    void testIfCorrectResult() {

        Change change = new Change ();

          double result = change.calculateChange(cashFromCustomer,sale);

          assertEquals (500, result, "Wrong amount of change");

    }
}