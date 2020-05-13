package se.kth.IV1350.processOfsale.view;

import se.kth.IV1350.processOfsale.controller.Controller;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.DatabaseConnectionFailException;
import se.kth.IV1350.processOfsale.model.*;
import se.kth.IV1350.processOfsale.view.ErrorMessageHandler;

/**
 * This is a placeholder for the real view, it contains hardcoded execution calls to all system operations in
 * the controller.
 */

public class View {

    private int itemIdentification;
    private Sale sale;
    private String storedItems;
    private Receipt receipt;
    private Change change;

    private Controller contr;

    /**
     * The construction of the View, creates a new instance that uses the specified controller for all calls to
     * other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View (Controller contr) {

        this.contr = contr;

    }

    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    public void runFakeExecution (){

        Observer saleObserver = new TotalRevenueView();

        contr.startNewSale();
        contr.addObserver(saleObserver);

        System.out.println("                    ");
        System.out.println("          Welcome To The Store");
        System.out.println("          --------------------");
        System.out.println("                    ");


        System.out.println("                           ");
        System.out.println("           Your Selected Items");
        System.out.println("******************************************");
        System.out.println("                    ");

        try {
            ItemDTO firsttItem = contr.entersItemIdentifier(11111111);

            System.out.println("Item has been identified: " + firsttItem.getItemDescription());
            System.out.println("Price: " + firsttItem.getPrice());
            System.out.println("VAT: " + firsttItem.getVatRate());

            System.out.println("                                  ");
        }

        catch (InvalidItemException exc) {

            handlerOfExceptionMessage("Item with ID: " + exc.getInvalidItemIdentifier() +    "is invalid");
            handlerOfLog("Intended for user interface: The item with barcode: " + exc.getInvalidItemIdentifier() + "is invalid", exc);
        }

        catch (DatabaseConnectionFailException exc){
            handlerOfExceptionMessage("Connection error with database, try again");
            handlerOfLog("Intended for Log: The connection to the database failed at: ", exc);
        }

        try {
            ItemDTO secondItem = contr.entersItemIdentifier(34562343);

            System.out.println("Item has been identified: " + secondItem.getItemDescription());
            System.out.println("Price: " + secondItem.getPrice());
            System.out.println("VAT: " + secondItem.getVatRate());

            System.out.println("                                  ");
        }

        catch (InvalidItemException exc){
            handlerOfExceptionMessage("Item with ID: " + exc.getInvalidItemIdentifier() + " " + "is invalid");
            handlerOfLog(" *Intended for user interface* The item with barcode: " + exc.getInvalidItemIdentifier() + " " + "is invalid   ", exc);
        }

        catch (DatabaseConnectionFailException exc){
            handlerOfExceptionMessage("Connection error with database, try again");
            handlerOfLog("Intended for Log: The connection to the database failed", exc );
        }

        try {

            ItemDTO thirdItem = contr.entersItemIdentifier(17737733);
            System.out.println("Item has been identified: " + thirdItem.getItemDescription());
            System.out.println("Price: " + thirdItem.getPrice());
            System.out.println("VAT: " + thirdItem.getVatRate());

            System.out.println("                                  ");

             }

        catch (InvalidItemException exc){
            handlerOfExceptionMessage("Item" + exc.getInvalidItemIdentifier() + "is invalid");
            handlerOfLog("Intended for user interface: The item with barcode" + itemIdentification + "is invalid", exc);

        }

        catch (DatabaseConnectionFailException exc){
            handlerOfExceptionMessage("Connection error with database, try again");
            handlerOfLog("Intended for Log: The connection to the database failed", exc );

        }

        try {

            ItemDTO fourthItem = contr.entersItemIdentifier(17737733);
            System.out.println("Item has been identified: " + fourthItem.getItemDescription());
            System.out.println("Price: " + fourthItem.getPrice());
            System.out.println("VAT: " + fourthItem.getVatRate());

            System.out.println("                                  ");
        }

        catch (InvalidItemException exc){
            handlerOfExceptionMessage("Item" + exc.getInvalidItemIdentifier() + "is invalid");
            handlerOfLog("Intended for user interface: The item with ID" + exc.getInvalidItemIdentifier() + "is invalid", exc);

        }

        catch (DatabaseConnectionFailException exc){
            handlerOfExceptionMessage("Connection error with database, try again");
            handlerOfLog("Intended for Log: The connection to the database failed", exc );

        }

        try {

            double totalPriceForSale = contr.endsCurrentSale();

            System.out.println("            Running Total");
            System.out.println("******************************************");
            System.out.println("Price for the entire sale: " + totalPriceForSale);
        }

        catch (InvalidItemException exc){
            handlerOfExceptionMessage("Item" + exc.getInvalidItemIdentifier() + "is invalid");
            handlerOfLog("Intended for user interface: The item with ID" + exc.getInvalidItemIdentifier() + "is invalid", exc);

        }

        catch (DatabaseConnectionFailException exc){
            handlerOfExceptionMessage("Connection error with database, try again");
            handlerOfLog("Intended for Log: The connection to the database failed", exc );

        }


        double paidAmount = contr.entersAmountPaid(500);
        System.out.println("Customer has paid: " + paidAmount);


        double change = contr.calculationOfChange(500);
        System.out.println("Change to give customer: " + change + "\n");

        Receipt receipt = contr.printOutReceipt();
        System.out.println("Completed Sale: "+ "\n" +  "\n" +receipt.createReceipt());




    }

    private void handlerOfExceptionMessage (String message){

        ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();

        errorMessageHandler.showMsg(message);

    }

    private void handlerOfLog (String message, Exception root){

        LogHandler logHandler = new LogHandler();

        logHandler.displayMsg(message + root.toString());
    }

}

