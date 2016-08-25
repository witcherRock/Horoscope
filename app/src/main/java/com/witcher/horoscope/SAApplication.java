package com.witcher.horoscope;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.witcher.horoscope.di.component.ApplicationComponent;
import com.witcher.horoscope.di.component.DaggerApplicationComponent;
import com.witcher.horoscope.di.module.ApplicationModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Александр on 17.08.2016.
 */
public class SAApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    public static ApplicationComponent getApplicationComponent() { return mApplicationComponent; }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        initializeInjector();
    }

    private void initializeInjector() {

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }
}