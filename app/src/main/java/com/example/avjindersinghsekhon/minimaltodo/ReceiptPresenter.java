package com.example.avjindersinghsekhon.minimaltodo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ismael on 6/12/17.
 */

public class ReceiptPresenter {

    private ReceiptInteractor interactor;

    private ReceiptView view;

    private Disposable disposable;

    public ReceiptPresenter() {
        this(new ReceiptInteractor());
    }

    public ReceiptPresenter(ReceiptInteractor interactor) {
        this.interactor = interactor;
    }

    public void getReceipt(String txCode) {
        disposable = interactor.getReceipt(txCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Receipt>() {
                    @Override
                    public void accept(Receipt receipt) throws Exception {
                        if(view != null) {
                            view.setReceipt(receipt);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(view != null) {
                            view.showError(throwable);
                        }
                    }
                });
    }

}
