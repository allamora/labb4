package se.kth.IV1350.processOfsale.view;

import java.time.LocalDateTime;

public class ErrorMessageHandler {

    void showMsg (String message) {

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("*** ERROR ***");
        messageBuilder.append("--");

        LocalDateTime dateAndTime = LocalDateTime.now();
        messageBuilder.append("Date and Time: ");
        messageBuilder.append (dateAndTime.toString() + "\n");

        messageBuilder.append("--");

        messageBuilder.append(message);

        messageBuilder.append("--" + "\n");

        System.out.println(messageBuilder.toString());
    }


}
