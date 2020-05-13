package se.kth.IV1350.processOfsale.integration;
import se.kth.IV1350.processOfsale.model.Receipt;


/**
 * The printer for the receipt
 */
public class Printer {

    private String receipt;

    /**
     * Prints the receipt
     *
     * @param receipt All the information that is to be printed onto the receipt
     *
     * @return confirmation of the receipt being printed
     */

    public String printReceipt (Receipt receipt){

        return ("Receipt has been printed");

    }
}


