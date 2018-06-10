package main.java.com;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * Created by Kartikeya on 5/29/18.
 */
public class PurchaseService {
    private WalletDataService walletDataService;
    private static final Logger logger = Logger.getLogger(PurchaseService.class.getName());

    @Autowired
    public PurchaseService(WalletDataService walletDataService) {
        this.walletDataService = walletDataService;
    }

    public boolean makePurchase(Long productId, Long userId){
        return walletDataService.buyProduct(productId,userId);
    }
}
