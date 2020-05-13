package se.kth.IV1350.processOfsale.model;
import java.time.LocalDateTime;


/**
 * Represent one receipt that proves the sale and the payment.
 */
public class Receipt {

    private Sale sale;
    private Change change;
    private double totalPayment;
    private String receipt;


    /**
     * Cosntructs the receipt
     *
     * @param sale Information regarding the entire sale
     * @param change Change given to the customer
     * @param totalPayment
     */

    public Receipt (Sale sale, Change change, double totalPayment){

        this.sale = sale;
        this.change = change;
        this.totalPayment = totalPayment;
    }

    /**
     * Creates the receipt
     *
     * @return The receipt
     */
    public String createReceipt ()
    {
        StringBuilder receipt = new StringBuilder();
        appendLine (receipt, "Receipt");
        appendLine(receipt, "******************************************");
        endSection (receipt);

        LocalDateTime dateAndTime = LocalDateTime.now();
        receipt.append("Date and Time: ");
        appendLine (receipt, dateAndTime.toString());
        endSection(receipt);

        receipt.append("Item list: " + "\n");
        appendLine(receipt, sale.saleString());

        receipt.append( "\n" + "To Pay: " + sale.getTotalPayment() +"\n");


        receipt.append("Change: " + change.getChange());


        return receipt.toString();

    }


    private void appendLine( StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder){
        builder.append("\n");
    }

}
