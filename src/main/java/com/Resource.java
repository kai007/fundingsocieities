package main.java.com;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Kartikeya on 5/28/18.
 */

public class Resource {
    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @Context
    HttpServletRequest request;

    @Path("/wallet/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchWalletDetails(@Context HttpServletRequest request,@PathParam("id") String id) {

        JSONObject walletDetailsJSON = walletDataService.fetchWalletDetailsJSON(Long.valueOf(id));

        return Response.ok(walletDetailsJSON).build();

    }

    @Path("/products/{id}/purchase")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response purchaseProduct(@Context HttpServletRequest request,@PathParam("id") String id, @RequestBody Map<String, String> data) {

        boolean purchaseState = purchaseService.makePurchase(Long.valueOf(id), Long.valueOf(data.get("“user_id”")));

        return  Response.ok(purchaseState).build();

    }

    @Path("/sales/current")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlashSaleStatus(@Context HttpServletRequest request,@QueryParam("country") String country) {

        List<JSONObject> flashSaleStatus = productService.fetchSalesNumbers();

        return Response.ok(flashSaleStatus).build();

    }
}
