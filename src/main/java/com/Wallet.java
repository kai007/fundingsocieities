package main.java.com;

import java.io.Serializable;

/**
 * Created by Kartikeya on 5/28/18.
 */
public class Wallet implements Serializable{
    private static long serialVersionUID = 1L;

    private Double balance;

    private String currency;

    public Wallet(long serialVersionUID,Double balance,String currency){
        this.serialVersionUID = serialVersionUID;
        this.balance = balance;
        this.currency = currency;
    }

    public void updateBalance(Double balance){
        this.balance = balance;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    /** Amount left in the wallet */
    public Double getBalance() {
        return balance;
    }

    /** The currency of the wallet amount */
    public String getCurrency() {
        return currency;
    }
}
