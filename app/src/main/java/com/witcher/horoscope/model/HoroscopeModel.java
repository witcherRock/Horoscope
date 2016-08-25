package com.witcher.horoscope.model;

import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.data.IRestApi;
import com.witcher.horoscope.data.enity.Horo;
import javax.inject.Inject;
import rx.Observable;


/**
 * Created by Александр on 17.08.2016.
 */

public class HoroscopeModel {
    @Inject
    protected IRestApi mRestApi;

    public HoroscopeModel() {
        SAApplication.getApplicationComponent().inject(this);
    }

    public Observable<Horo> getHoroscope(String type) {
        return mRestApi.getHoroscope(type);
    }
}
