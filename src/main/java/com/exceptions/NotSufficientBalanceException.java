package main.java.com.exceptions;

import net.sf.json.JSONObject;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kartikeya on 6/10/18.
 */
public class NotSufficientBalanceException extends WebApplicationException {

    public NotSufficientBalanceException() {
        super(Response.status(400).build());
    }

    public NotSufficientBalanceException(String message,String key) {

        super(Response.status(400).type(MediaType.APPLICATION_JSON_TYPE).
                entity(getPut(message, key)).build());
    }

    private static Object getPut(String message, String key) {
        JSONObject status = new JSONObject();
        status.put(key,message);
        return status;
    }
}
