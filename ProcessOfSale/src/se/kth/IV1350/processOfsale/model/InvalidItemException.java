package se.kth.IV1350.processOfsale.model;

public class InvalidItemException extends Exception {

    private int itemIdentification;

        public InvalidItemException (int itemIdentification){

            this.itemIdentification = itemIdentification;
        }

        public int getInvalidItemIdentifier(){

            return itemIdentification;

        }
    }

