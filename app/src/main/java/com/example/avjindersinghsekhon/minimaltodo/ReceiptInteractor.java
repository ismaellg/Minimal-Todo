package com.example.avjindersinghsekhon.minimaltodo;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ismael on 6/12/17.
 */

public class ReceiptInteractor {

    private ReceiptApi api;

    public ReceiptInteractor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(ReceiptApi.class);
    }

    public Single<Receipt> getReceipt(String txCode) {
        return api.getReceipt(txCode, BuildConfig.MERCHANT_ID);
    }

}
