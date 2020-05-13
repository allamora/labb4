package se.kth.IV1350.processOfsale.view;

import java.time.LocalDateTime;

public class LogHandler {

    void displayMsg (String message) {

        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("*** ERROR ***");
        logBuilder.append("--");

        LocalDateTime dateAndTime = LocalDateTime.now();
        logBuilder.append("Date and Time: ");
        logBuilder.append (dateAndTime.toString() + "\n");

        logBuilder.append("--");

        logBuilder.append(message);

        logBuilder.append("--" + "\n");

        System.out.println(logBuilder.toString());
    }

}
