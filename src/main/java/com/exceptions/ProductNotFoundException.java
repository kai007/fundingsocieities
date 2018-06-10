package main.java.com.exceptions;

/**
 * Created by Kartikeya on 6/10/18.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
