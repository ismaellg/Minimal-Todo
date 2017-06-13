package com.example.avjindersinghsekhon.minimaltodo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ismael on 6/12/17.
 */

public class ReceiptFragment extends Fragment implements ReceiptView {

    private static final String TX_CODE = "TX_CODE";

    @BindView(R.id.tx_code)
    TextView txCode;

    @BindView(R.id.merchant)
    TextView merchant;

    @BindView(R.id.value)
    TextView value;

    private ReceiptPresenter presenter;

    private Unbinder unbinder;

    private Dialog dialog;

    public static ReceiptFragment newInstance(String txCode) {
        Bundle args = new Bundle();

        args.putSerializable(TX_CODE, txCode);

        ReceiptFragment fragment = new ReceiptFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new ReceiptPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receipt, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        dialog = new ProgressDialog(getContext()) {
            {
                setIndeterminate(true);
                setMessage(getContext().getString(R.string.loading));
                setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        presenter.cancel();
                    }
                });
            }
        };

        presenter.attachView(this);

        presenter.getReceipt(getArguments().getString(TX_CODE));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();

        presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter = null;
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void setReceipt(Receipt receipt) {
        if(receipt.getTxData() != null) {
            TransactionData txData = receipt.getTxData();

            txCode.setText(txData.getCode());

            NumberFormat nf = NumberFormat.getInstance();

            nf.setMaximumFractionDigits(2);

            nf.setMinimumFractionDigits(2);

            value.setText(getString(R.string.amount, nf.format(txData.getAmount()), txData.getCurrency()));
        }

        if(receipt.getMerchantData() != null && receipt.getMerchantData().getMerchant() != null) {
            merchant.setText(receipt.getMerchantData().getMerchant().getName());
        }
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoading() {
        dialog.dismiss();
    }
}
