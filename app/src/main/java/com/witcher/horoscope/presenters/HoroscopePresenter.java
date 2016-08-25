package com.witcher.horoscope.presenters;

import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.data.enity.BaseSunSign;
import com.witcher.horoscope.data.enity.Horo;
import com.witcher.horoscope.model.HoroscopeModel;
import com.witcher.horoscope.view.HoroscopeView;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Александр on 17.08.2016.
 */
public class HoroscopePresenter extends BasePresenter<HoroscopeView>{
    private String mTypeHoroscope;
    private ConstantsSunSign mSunSign;

    public void setTypeHoroscope(String mTypeHoroscope) {
        this.mTypeHoroscope = mTypeHoroscope;
    }

    public void setSunSign(ConstantsSunSign mSunSign) { this.mSunSign = mSunSign; }

    @Inject
    protected HoroscopeModel mHoroscopeModel;

    public HoroscopePresenter(){
        SAApplication.getApplicationComponent().inject(this);}

    @Override
    public void onCreateView(Bundle saveInstance) {
        if(!mView.isOnline()){
            mView.showErrorDialog();
            mView.enabledProgressBar(false);
            return;
        }

        mView.enabledProgressBar(true);
        Subscription subscription = mHoroscopeModel.getHoroscope(mTypeHoroscope)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Horo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e, "error load horoscope");
                    }

                    @Override
                    public void onNext(Horo horoscopes) {
                        BaseSunSign sunSign = null;
                        switch (mSunSign){
                            case ARIES:         sunSign = horoscopes.getAries();        break;
                            case TAURUS:        sunSign = horoscopes.getTaurus();       break;
                            case GEMINI:        sunSign = horoscopes.getGemini();       break;
                            case CANCER:        sunSign = horoscopes.getCancer();       break;
                            case LEO:           sunSign = horoscopes.getLeo();          break;
                            case VIRGO:         sunSign = horoscopes.getVirgo();        break;
                            case LIBRA:         sunSign = horoscopes.getLibra();        break;
                            case SCORPIO:       sunSign = horoscopes.getScorpio();      break;
                            case SAGITTARIUS:   sunSign = horoscopes.getSagittarius();  break;
                            case CAPRICORN:     sunSign = horoscopes.getCapricorn();    break;
                            case AQUARIUS:      sunSign = horoscopes.getAquarius();     break;
                            case PISCES:        sunSign = horoscopes.getPisces();       break;
//                            default: sunSign = BaseSunSign(); ????

                        }
                        mView.enabledProgressBar(false);
                        mView.showHoroscope(sunSign);
                    }
                });

        addSubscription(subscription);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
