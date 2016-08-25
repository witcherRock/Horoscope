package com.witcher.horoscope.view;

import com.witcher.horoscope.data.enity.BaseSunSign;
import com.witcher.horoscope.data.enity.Horo;

/**
 * Created by Александр on 17.08.2016.
 */
public interface HoroscopeView {
    boolean isOnline();
    void showErrorDialog();
    void enabledProgressBar(boolean enabled);
    void showHoroscope(BaseSunSign sunSignPrediction);
}
