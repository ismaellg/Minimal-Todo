package com.example.avjindersinghsekhon.minimaltodo;

/**
 * Created by ismael on 6/12/17.
 */

public interface ReceiptView {

    void showLoading();

    void setReceipt(Receipt receipt);

    void showError(Throwable throwable);

    void dismissLoading();

}
