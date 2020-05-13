package se.kth.IV1350.processOfsale.view;

import se.kth.IV1350.processOfsale.model.Observer;
import se.kth.IV1350.processOfsale.model.Sale;

import java.time.LocalDateTime;

public class TotalRevenueView implements Observer {

    private double income = 0.0;


    public TotalRevenueView(){

        
       
    }


    @Override
    public void updateTotalIncome (double totalPayment){

        income += totalPayment;
        showRevenueOnScreen();
    }


    public void showRevenueOnScreen(){

        StringBuilder screenBuilder = new StringBuilder();
        screenBuilder.append("*** Total Revenue ***");
        screenBuilder.append("-------------------");

        LocalDateTime dateAndTime = LocalDateTime.now();
        screenBuilder.append("Date and Time: ");
        screenBuilder.append (dateAndTime.toString());

        screenBuilder.append("-------------------");

        screenBuilder.append(" Revenue ");
        screenBuilder.append(income + " ");

        screenBuilder.append("-------------------");

        System.out.println(screenBuilder.toString());

    }

}
