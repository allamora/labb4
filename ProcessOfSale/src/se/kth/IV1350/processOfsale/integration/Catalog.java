package se.kth.IV1350.processOfsale.integration;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.model.InvalidItemException;


public class Catalog {

    /**
     * The Catalog
     *
     * @param itemIdentification The barcode of the selected item
     *
     * @return The description of the selected item, or an exception if the item is invalid or connection to the database is not established
     *
     * @throws InvalidItemException If the entered item does not exist in the stores database
     *
     * @throws DatabaseConnectionFailException If database connection fails
     */

    public static ItemDTO getDescription (int itemIdentification) throws InvalidItemException, DatabaseConnectionFailException {

        if (itemIdentification == 12222113)
            return new ItemDTO("Jordgubbar", 0.12, 60);

       else if (itemIdentification == 14234442)
            return new ItemDTO("Korv", 0.06, 30);

       else if (itemIdentification == 17737733)
            return new ItemDTO("Mjölk", 0.04, 20);

        else if (itemIdentification == 11111111)
             throw new DatabaseConnectionFailException();

        else throw new InvalidItemException(itemIdentification);

    }
}