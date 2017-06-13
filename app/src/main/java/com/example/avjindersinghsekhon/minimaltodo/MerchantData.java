package com.example.avjindersinghsekhon.minimaltodo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ismael on 6/13/17.
 */

public class MerchantData implements Serializable {

    @SerializedName("merchant_profile")
    private Merchant merchant;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantData that = (MerchantData) o;

        return merchant != null ? merchant.equals(that.merchant) : that.merchant == null;

    }

    @Override
    public int hashCode() {
        return merchant != null ? merchant.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MerchantData{" +
                "merchant=" + merchant +
                '}';
    }
}
