package main.java.com.exceptions;

/**
 * Created by Kartikeya on 6/10/18.
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
