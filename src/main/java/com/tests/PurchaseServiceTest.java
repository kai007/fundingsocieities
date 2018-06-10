package main.java.com.tests;

import main.java.com.ProductService;
import main.java.com.PurchaseService;
import main.java.com.WalletDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kartikeya on 6/7/18.
 */
public class PurchaseServiceTest {
    private PurchaseService purchaseService ;
    private WalletDataService walletDataService ;

    @Before
    public void setUp() throws Exception {
        walletDataService = new WalletDataService(new ProductService());
        purchaseService = new PurchaseService(walletDataService);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMakePurchase() throws Exception {
        boolean purchaseStatus = purchaseService.makePurchase(1l,1l);
        assertEquals(true, purchaseStatus);
    }

}