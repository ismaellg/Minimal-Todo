package com.example.avjindersinghsekhon.minimaltodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ismael on 6/12/17.
 */

public class ReceiptFragment extends Fragment {

    private static final String TX_CODE = "TX_CODE";

    @BindView(R.id.tx_code)
    TextView txCode;

    @BindView(R.id.merchant)
    TextView merchant;

    @BindView(R.id.value)
    TextView value;

    private Unbinder unbinder;

    public static ReceiptFragment newInstance(String txCode) {
        Bundle args = new Bundle();

        args.putSerializable(TX_CODE, txCode);

        ReceiptFragment fragment = new ReceiptFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receipt, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
