package com.example.avjindersinghsekhon.minimaltodo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ismael on 6/12/17.
 */

public class Receipt implements Serializable {

    @SerializedName("transaction_data")
    private TransactionData txData;

    @SerializedName("merchant_data")
    private MerchantData merchantData;

    public TransactionData getTxData() {
        return txData;
    }

    public void setTxData(TransactionData txData) {
        this.txData = txData;
    }

    public MerchantData getMerchantData() {
        return merchantData;
    }

    public void setMerchantData(MerchantData merchantData) {
        this.merchantData = merchantData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        return txData != null ? txData.equals(receipt.txData) : receipt.txData == null;
    }

    @Override
    public int hashCode() {
        return txData != null ? txData.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "txData=" + txData +
                ", merchantData=" + merchantData +
                '}';
    }
}
