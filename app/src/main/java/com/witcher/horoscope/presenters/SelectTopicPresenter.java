package com.witcher.horoscope.presenters;

import android.content.Intent;
import android.os.Bundle;

import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.common.ExtraParameters;
import com.witcher.horoscope.common.Utils;
import com.witcher.horoscope.ui.activities.ShowHoroscopeActivity;
import com.witcher.horoscope.view.SelectTopicView;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectTopicPresenter extends BasePresenter<SelectTopicView> {

    private ConstantsSunSign mSunSign;

    public void setSunSign(ConstantsSunSign sunSign) {
        this.mSunSign = sunSign;
    }

    @Override
    public void onCreateView(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void showHoroscope(String topicHoroscope) {
        if (Utils.isValidName(topicHoroscope)) {
            Intent intent = new Intent(mView.getContext(), ShowHoroscopeActivity.class);
            intent.putExtra(ExtraParameters.EXTRA_PARAM_SUN_SIGN, this.mSunSign);
            intent.putExtra(ExtraParameters.EXTRA_PARAM_TOPIC, topicHoroscope);
            mView.getContext().startActivity(intent);
        }
    }
}
