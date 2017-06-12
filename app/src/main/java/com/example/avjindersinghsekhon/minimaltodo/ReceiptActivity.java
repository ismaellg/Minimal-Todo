package com.example.avjindersinghsekhon.minimaltodo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ismael on 6/12/17.
 */

public class ReceiptActivity extends AppCompatActivity {

    private static final String TX_CODE = "TX_CODE";

    public static Intent newInstance(Context context, String txCode) {
        Intent intent = new Intent(context, ReceiptActivity.class);

        intent.putExtra(TX_CODE, txCode);

        return intent;
    }
}
