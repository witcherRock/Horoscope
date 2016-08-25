package com.witcher.horoscope.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.common.ExtraParameters;
import com.witcher.horoscope.common.Utils;
import com.witcher.horoscope.ui.activities.SelectTopicActivity;
import com.witcher.horoscope.ui.fragments.SelectTopicFragment;
import com.witcher.horoscope.view.SelectSunSignView;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectSunSignPresenter extends BasePresenter<SelectSunSignView> {
    @Override
    public void onCreateView(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void nextStep(ConstantsSunSign sunSign) {
            Intent intent = new Intent(mView.getContext(), SelectTopicActivity.class);
            intent.putExtra(ExtraParameters.EXTRA_PARAM_SUN_SIGN, sunSign);
            mView.getContext().startActivity(intent);
    }

}
