package com.example.avjindersinghsekhon.minimaltodo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import static com.example.avjindersinghsekhon.minimaltodo.MainActivity.LIGHTTHEME;
import static com.example.avjindersinghsekhon.minimaltodo.MainActivity.THEME_PREFERENCES;
import static com.example.avjindersinghsekhon.minimaltodo.MainActivity.THEME_SAVED;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String theme = getSharedPreferences(THEME_PREFERENCES, MODE_PRIVATE).getString(THEME_SAVED, LIGHTTHEME);

        int themeResId;

        if(theme.equals(LIGHTTHEME)){
            themeResId = R.style.CustomStyle_LightTheme;
        } else{
            themeResId = R.style.CustomStyle_DarkTheme;
        }

        setTheme(themeResId);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_receipt);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.content_frame);

        if(fragment == null) {
            fm.beginTransaction().replace(R.id.content_frame, ReceiptFragment.newInstance(getIntent().getStringExtra(TX_CODE))).commit();
        }
    }
}
