package se.kth.IV1350.processOfsale.model;

import se.kth.IV1350.processOfsale.model.Sale;
import se.kth.IV1350.processOfsale.controller.Controller;


/**
 * The change for the customer
 */
public class Change {

    private double change = 0.0;

    /**
     * Calculates the change for the customer
     *
     * @param cashFromCustomer The money given by the customer
     *
     * @return The change
     */
    public double calculateChange (double cashFromCustomer, Sale sale){

        double payment = sale.getTotalPayment();
        double recievedCash = cashFromCustomer;

        change = (recievedCash - payment);

        return change;

    }

    public double getChange (){

        return change;
    }
}
