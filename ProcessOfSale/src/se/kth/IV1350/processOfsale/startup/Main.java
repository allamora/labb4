package se.kth.IV1350.processOfsale.startup;

import se.kth.IV1350.processOfsale.controller.Controller;
import se.kth.IV1350.processOfsale.view.View;

/**
 * Starts the entire application, contains the main method used to start the application.
 */

public class Main {

    /**
     * The main method used to start the entire application
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main (String[] args) {

        Controller contr = new Controller ();
        View view = new View (contr);
        view.runFakeExecution();
    }
}