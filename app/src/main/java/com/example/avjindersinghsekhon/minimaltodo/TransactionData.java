package com.example.avjindersinghsekhon.minimaltodo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ismael on 6/13/17.
 */

public class TransactionData implements Serializable {

    @SerializedName("transaction_code")
    private String code;

    private BigDecimal amount = BigDecimal.ZERO;

    private String currency;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionData that = (TransactionData) o;

        return code != null ? code.equals(that.code) : that.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "code='" + code + '\'' +
                '}';
    }
}
