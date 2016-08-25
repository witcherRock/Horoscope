package com.witcher.horoscope.di.component;

import com.witcher.horoscope.di.module.ApplicationModule;
import com.witcher.horoscope.model.HoroscopeModel;
import com.witcher.horoscope.presenters.HoroscopePresenter;
import com.witcher.horoscope.ui.activities.ShowHoroscopeActivity;
import com.witcher.horoscope.ui.fragments.CheckSunSignFragment;
import com.witcher.horoscope.ui.fragments.SelectSunSignFragment;
import com.witcher.horoscope.ui.fragments.SelectTopicFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Александр on 17.08.2016.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(HoroscopeModel horoscopeModel);
    void inject(HoroscopePresenter horoscopePresenter);
    void inject(SelectSunSignFragment selectSunSignFragment);
    void inject(SelectTopicFragment selectTopicFragment);
    void inject(ShowHoroscopeActivity showHoroscopeActivity);
    void inject(CheckSunSignFragment checkSunSignFragment);
}
