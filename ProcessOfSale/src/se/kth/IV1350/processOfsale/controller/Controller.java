package se.kth.IV1350.processOfsale.controller;

import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.model.*;
import se.kth.IV1350.processOfsale.model.Change;
import se.kth.IV1350.processOfsale.integration.*;
import se.kth.IV1350.processOfsale.view.TotalRevenueView;

import java.util.ArrayList;


/**
 * This is the applications only controller, all calls to the model pass through this class.
 */
public class Controller {

    private Sale sale;
    private double totalpriceinclvat;
    private ArrayList <Item> storedItems;
    private Change change;
    private double changeToCustomer;
    private Printer printer;
    private Receipt receipt;
    private double totalPayment;
    private ItemDTO itemDTO;
    private Item item;
    private double amountPaid;





    /**
     * Starts a new sale, and this method must be called first before doing anything else during sale.
     */
    public void startNewSale() {

        sale = new Sale ();
    }

    /**
     * Scans the specific item selected by the customer.
     *
     * @param itemIdentification The specific items barcode.
     *
     * @return The description of the selected item.
     *
     * @throws InvalidItemException If the entered item does not exist in the stores database
     *
     * @throws DatabaseConnectionFailException If database connection fails
     */

    public ItemDTO entersItemIdentifier (int itemIdentification) throws InvalidItemException, DatabaseConnectionFailException{


        return sale.storeItemInSale(itemIdentification);


    }

    /**
     * Ends the sale
     *
     * @return The amount to be paid by the customer
     *
     * @throws InvalidItemException If the entered item does not exist in the stores database
     *
     * @throws DatabaseConnectionFailException If database connection fails
     */
    public double endsCurrentSale () throws InvalidItemException, DatabaseConnectionFailException{

     return totalpriceinclvat = sale.getTotalPayment();

    }

    /**
     * Adds an observer
     *
     * @param observer The added observer
     */
    public void addObserver (Observer observer){

      sale.addObserver(observer);
    }



    /**
     * Customer gives money to the cashier
     *
     * @param cashFromCustomer The amount given by the customer
     *
     * @return Verification of customer giving money
     */

    public double entersAmountPaid (double cashFromCustomer){

              return cashFromCustomer;

    }

    /**
     * Calculates the change that is to be given to the customer
     *
     * @param cashFromCustomer The amount given by the customer
     *
     * @return The change for the customer
     */
    public double calculationOfChange (double cashFromCustomer){

        change = new Change();

       return change.calculateChange(cashFromCustomer, this.sale);

    }

    /**
     * The receipt for the customer
     *
     * @return The receipt
     */
    public Receipt printOutReceipt (){

        printer = new Printer();

        Receipt receipt = new Receipt(sale, change, sale.getTotalPayment());

        printer.printReceipt(receipt);

        return receipt;
    }
}
