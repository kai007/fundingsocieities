package main.java.com.tests;

import main.java.com.Product;
import main.java.com.ProductService;
import main.java.com.PurchaseService;
import main.java.com.WalletDataService;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.util.JavaScriptUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kartikeya on 6/7/18.
 */
public class ProductServiceTest {
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        productService = new ProductService();
    }
    @Test
    public void testFetchProductDetails() throws Exception {
        Product result = productService.fetchProductDetails(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("SGD", result.getCurrency());
        assertNotNull(result.getPrice());
        assertNotNull(result.getTimeLeft());
        assertNotNull(result.getItemsLeft());
        assertNotNull(result.getTotalItems());

    }

    @Test
    public void testFetchSalesNumbers() throws Exception {
        List<JSONObject> salesList = productService.fetchSalesNumbers();
        assertNotNull(salesList.get(0));
        assertNotNull(salesList.get(0).getString("product_id"));
        assertNotNull(salesList.get(0).getString("price"));
        assertNotNull(salesList.get(0).getString("currency"));
        assertNotNull(salesList.get(0).getString("total_items"));
        assertNotNull(salesList.get(0).getString("time_left"));
    }
}