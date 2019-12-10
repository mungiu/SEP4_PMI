package utils.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("The email is not registered.");
    }
}
