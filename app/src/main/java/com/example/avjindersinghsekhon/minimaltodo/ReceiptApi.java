package com.example.avjindersinghsekhon.minimaltodo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ismael on 6/12/17.
 */

public interface ReceiptApi {

    @GET("v0.1/receipts/{transactionCode}?mid={merchantId}")
    Single<Receipt> getReceipt(@Path("transactionCode") String txCode, @Path("merchantId") String merchantId);

}
