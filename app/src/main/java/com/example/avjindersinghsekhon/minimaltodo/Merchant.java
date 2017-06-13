package com.example.avjindersinghsekhon.minimaltodo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ismael on 6/13/17.
 */

public class Merchant implements Serializable {

    @SerializedName("business_name")
    private String name;

    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merchant merchant = (Merchant) o;

        if (name != null ? !name.equals(merchant.name) : merchant.name != null) return false;
        return email != null ? email.equals(merchant.email) : merchant.email == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
