package se.kth.IV1350.processOfsale.integration;

public class DatabaseConnectionFailException  extends Exception{

    private String errorConnectionMessage;


    public void DatabaseConnectionFailureException (String message){

        this.errorConnectionMessage = message;

    }

    public String getErrorConnectionMessage (){

        return errorConnectionMessage;
    }

}
