package main.java.com;

import java.io.Serializable;

/**
 * Created by Kartikeya on 5/28/18.
 */
public class Product implements Serializable{
    private long serialVersionUID = 1L;

    private Double price;

    private String currency;

    private long totalItems;

    private long itemsLeft;

    private long timeLeft;

    public Product(Long id,Double price, String currency,Long totalItems,Long itemsLeft,Long timeLeft){
        this.serialVersionUID = id;
        this.price = price;
        this.currency = currency;
        this.totalItems = totalItems;
        this.itemsLeft = itemsLeft;
        this.timeLeft = timeLeft;
    }

    public long getId() {
        return serialVersionUID;
    }

    /** Amount left in the wallet */
    public Double getPrice() {
        return price;
    }

    /** The currency of the wallet amount */
    public String getCurrency() {
        return currency;
    }

    /** The currency of the wallet amount */
    public long getTotalItems() {
        return totalItems;
    }

    /** The currency of the wallet amount */
    public long getItemsLeft() {
        return itemsLeft;
    }

    /** The currency of the wallet amount */
    public long getTimeLeft() {
        return timeLeft;
    }
}
