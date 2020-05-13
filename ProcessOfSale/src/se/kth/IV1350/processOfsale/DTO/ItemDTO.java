package se.kth.IV1350.processOfsale.DTO;


import se.kth.IV1350.processOfsale.integration.Catalog;

/**
     * Data transfer object of an item, containing its attributes
     */

    public class ItemDTO {

        private String itemDescription;
        private double vatRate;
        private double price;


        /**
         * The constructor that creates a new instance of an object item
         *
         * @param vatRate The vatRate of the specified item
         * @param price The price of the item
         */

        public ItemDTO (String itemDescription, double vatRate, double price){

            this.vatRate = vatRate;
            this.price = price;
            this.itemDescription = itemDescription;
        }

        /**
         * Gets vatRate of the item
         *
         * @return The vatRate of specified item
         */
        public double getVatRate(){

            return vatRate;
        }

        /**
         * Gets price of an item
         *
         * @return Price of an item
         */
        public double getPrice(){

            return price;
        }

    /**
     * Retrieves the description of the selected item
     *
     * @return The description of the item
     */
    public String getItemDescription(){

             return itemDescription;
        }

    /**
     * Creates a string with price details of the item
     *
     * @return The price details
     */
    public String toString (){

            String itemString = " Item Vat Rate" + vatRate + " Item Price" + price;

            return itemString;
        }

    }


