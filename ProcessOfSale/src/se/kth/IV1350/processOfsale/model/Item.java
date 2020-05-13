package se.kth.IV1350.processOfsale.model;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.Catalog;
import se.kth.IV1350.processOfsale.integration.DatabaseConnectionFailException;


/**
     * Represents an item instances and it's containments are immutalble
     */
    public class Item {

        private ItemDTO itemDTO;
        private int itemIdentification;
        private int quantity;

        /**
         * The constructor that creates an item
         *
         * @param itemIdentification Being created according to its barcode
         * @param quantity Quantity of the specific item
         *
         * @throws InvalidItemException If the entered item does not exist in the stores database
         *
         * @throws DatabaseConnectionFailException If database connection fails
         */

            public Item (int itemIdentification, int quantity) throws InvalidItemException, DatabaseConnectionFailException {

                 this.itemIdentification = itemIdentification;
                 this.quantity = quantity;
                 this.itemDTO = Catalog.getDescription(itemIdentification);

            }
            /**
             * Gets the barcode
             *
             * @return The barcode
             */
            public int getItemIdentification(){

                return itemIdentification;
            }

            /**
             * Gets quantity of item
             *
             * @return The quantity of the specified item
             */

            public int getQuantity(){

                return quantity;
            }

            /**
             * Gets the item price details
             *
             * @return The price details
             */

            public ItemDTO getItemDTO (){

                return itemDTO;

            }

            /**
             * Creates a string of the item barcode and quantity of the item
             *
             * @return
             */

             public String toString (){

                String itemString = itemDTO.getItemDescription() + " " + quantity + " " + itemIdentification;

                return itemString;
            }

            /**
             * Increases the quantity of a specifik item
             *
             */

            public void addOneToQuantity () {

                this.quantity++;

            }



    }


