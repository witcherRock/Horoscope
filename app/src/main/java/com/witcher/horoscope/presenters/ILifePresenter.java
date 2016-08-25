package com.witcher.horoscope.presenters;

import android.os.Bundle;

/**
 * Created by Александр on 17.08.2016.
 */
public interface ILifePresenter {

    void onCreateView(Bundle saveInstance);
    void onStart();
    void onStop();
    void onDestroy();
}
