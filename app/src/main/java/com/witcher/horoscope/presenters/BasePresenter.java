package com.witcher.horoscope.presenters;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Александр on 17.08.2016.
 */
public abstract class BasePresenter<T> implements ILifePresenter {
    protected CompositeSubscription mCompositeSubscription;

    protected T mView;

    public void setView(T mView) { this.mView = mView; }

    public BasePresenter() { this.mCompositeSubscription = new CompositeSubscription(); }

    public void addSubscription(Subscription subscription) { mCompositeSubscription.add(subscription); }

    public void unSubscriptions() {
        mCompositeSubscription.unsubscribe();
    }

    @Override
    public void onStop() { unSubscriptions(); }

    @Override
    public void onDestroy() {
        //unSubscriptions();
        this.mView = null;
    }
}

