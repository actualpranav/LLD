package Tic_Tac_Toe.models.exceptions;

public class DuplicateSymbolException extends Exception{
    public DuplicateSymbolException(String message){
        super(message);
    }
}
