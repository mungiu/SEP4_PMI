package utils.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(){
        super("The password is incorrect.");
    }
}
