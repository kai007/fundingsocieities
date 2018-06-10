package main.java.com;

import main.java.com.exceptions.NotSufficientBalanceException;
import main.java.com.exceptions.UserNotFoundException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Kartikeya on 5/28/18.
 */
public class WalletDataService {
    private ProductService productService;
    private static final long COMPANY_USER = 1;

    @Autowired
    public WalletDataService(ProductService productService){
        this.productService = productService;
    }

    private static final Logger logger = Logger.getLogger(WalletDataService.class.getName());

    final static Map<Long,Wallet> map = new HashMap<>();
    static{
        map.put(1l,new Wallet(1,100000d,"SGD"));

        for(long i = 2 ;i<10;i++) {
            map.put(i, new Wallet(i,Math.random()*100,"SGD"));
        }
    }

    public Double fetchCompanyBalance(){
        return map.get(1l).getBalance();
    }

    public void updateWalletBalance(Long userId,Double balance){
        Wallet companyWallet = map.get(userId);
        companyWallet.updateBalance(balance);
        map.put(1l,companyWallet);
    }

    public Wallet fetchWalletDetails(Long userId){
        return map.get(userId);
    }

    public JSONObject fetchWalletDetailsJSON(Long userId){
        if(!map.containsKey(userId)){
            throw new UserNotFoundException("User Not Found for ID " + userId);
        }
        return jsonifyWallet(map.get(userId));
    }

    public JSONObject jsonifyWallet(Wallet wallet){
        return new JSONObject()
                .accumulate("id",wallet.getSerialVersionUID())
                .accumulate("balance",wallet.getBalance())
                .accumulate("currency",wallet.getCurrency());
    }

    public boolean buyProduct(Long productId,Long userId){
        if(!map.containsKey(userId)){
            throw new UserNotFoundException("User Not Found for ID " + userId);
        }
        Double existingUserBalance = map.get(userId).getBalance();
        Double companyBalance = fetchCompanyBalance();
        Product product = productService.fetchProductDetails(productId);

        if(product.getPrice() > existingUserBalance){
            throw new NotSufficientBalanceException("email already exists", "emailId");
        }
        updateWalletBalance(COMPANY_USER,companyBalance+product.getPrice());
        updateWalletBalance(userId,existingUserBalance-product.getPrice());
        return true;
    }

}
