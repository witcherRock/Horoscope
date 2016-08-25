package com.witcher.horoscope.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;

import com.witcher.horoscope.R;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.common.ExtraParameters;
import com.witcher.horoscope.ui.activities.SelectTopicActivity;
import com.witcher.horoscope.view.CheckSunSignView;

import butterknife.BindView;

/**
 * Created by Александр on 24.08.2016.
 */
public class CheckSunSignPresenter extends BasePresenter<CheckSunSignView> {

    @Override
    public void onCreateView(Bundle saveInstance) {
    }

    @Override
    public void onStart() { }

    public void startPrediction(ConstantsSunSign sunSign){
        Intent intent = new Intent(mView.getContext(), SelectTopicActivity.class);
        intent.putExtra(ExtraParameters.EXTRA_PARAM_SUN_SIGN, sunSign);
        mView.getContext().startActivity(intent);
    }
}
