package se.kth.IV1350.processOfsale.model;

import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.Catalog;
import se.kth.IV1350.processOfsale.integration.DatabaseConnectionFailException;
import se.kth.IV1350.processOfsale.view.TotalRevenueView;


import java.util.ArrayList;
import java.util.List;


/**
 * Represents the entire salelog and information of every item the customer has bought
 */
public class Sale {

    private Receipt receipt;
    private double totalPayment;
    private ArrayList<Item> storedItems = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();


    /**
     * Calculates the payment which is to be provided by the customer for the total sale.
     *
     * @param itemIdentification Contains the information needed to calculate the price per selected item.
     * @return The price for the sale.
     *
     * @throws InvalidItemException If the entered item does not exist in the stores database
     *
     * @throws DatabaseConnectionFailException If database connection fails
     */

    public double calculateTotalPayment(int itemIdentification) throws InvalidItemException, DatabaseConnectionFailException {

        ItemDTO itemone = Catalog.getDescription(itemIdentification);

        double pricePerItem = itemone.getPrice();
        double itemVat = itemone.getVatRate();


        double totalPricePerItem = (pricePerItem * itemVat) + pricePerItem;

        return totalPayment += totalPricePerItem;

    }

    /**
     * Registers observers. Any <code>Observer</code> that is * passed to this method will be notified when this object * changes state.
     *
     * @param observer The observer that shall be registered.
     */

    public void addObserver(Observer observer) {

        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {

            observer.updateTotalIncome(totalPayment);
        }
    }

    /**
     * Gets the total payment required from the customer
     *
     * @return The total amount to be paid by the customer
     */
    public double getTotalPayment() {

        return totalPayment;
    }

    /**
     * Stores the item in the sale log
     *
     * @param itemIdentification The barcode of the item
     * @return The list of all bought items
     *
     * @throws InvalidItemException If the entered item does not exist in the stores database
     * @throws DatabaseConnectionFailException If database connection fails
     */

    public ItemDTO storeItemInSale(int itemIdentification) throws InvalidItemException, DatabaseConnectionFailException {

        Item item = new Item(itemIdentification, 1);

        boolean found = false;

        for (Item storedItem : storedItems) {

            if (storedItem.getItemIdentification() == item.getItemIdentification()) {

                storedItem.addOneToQuantity();
                found = true;
            }
        }

        if (found == false) {
            storedItems.add(item);
        }

        calculateTotalPayment(itemIdentification);

        return item.getItemDTO();
    }

    /**
     * Gets the list of all bought items
     *
     * @return The list of all items
     */
    public ArrayList<Item> getStoredItems() {

        return storedItems;
    }


    /**
     * Creates a string of the entire list of bought items
     *
     * @return The list of items in a string format
     */
    public String saleString() {

        StringBuilder saleBuilder = new StringBuilder();

        for (Item storedItem : storedItems) {

            saleBuilder.append(storedItem.toString() + "\n");

        }

        notifyObservers();
        return saleBuilder.toString();
    }

}
