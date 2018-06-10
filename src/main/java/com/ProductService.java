package main.java.com;

import main.java.com.exceptions.ProductNotFoundException;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Kartikeya on 5/29/18.
 */
public class ProductService {

    final static Map<Long,Product> productMap = new HashMap<>();
    static{
        for(long i = 1 ;i<=50;i++) {
            long items = Double.valueOf(Math.random()*100).longValue();
            productMap.put(i, new Product(i,Math.random()*1000,"SGD",items,items-5,Double.valueOf(Math.random()*100000).longValue()));
        }
    }
    public ProductService(){

    }

    public Product fetchProductDetails(long productId){
        if(!productMap.containsKey(productId)){
            throw new ProductNotFoundException("Product Not Found for ID " + productId);
        }
        return productMap.get(productId);
    }

    public List<JSONObject> fetchSalesNumbers(){

        return productMap.entrySet().stream().map(productEntry -> new JSONObject()
                .accumulate("product_id",productEntry.getValue().getId())
                .accumulate("price",productEntry.getValue().getPrice())
                .accumulate("currency",productEntry.getValue().getCurrency())
                .accumulate("total_items",productEntry.getValue().getTotalItems())
                .accumulate("time_left",productEntry.getValue().getTimeLeft())).collect(Collectors.toList());
    }

}
