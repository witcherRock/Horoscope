package com.witcher.horoscope.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.witcher.horoscope.R;
import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.common.ConstantsURL;
import com.witcher.horoscope.common.ExtraParameters;
import com.witcher.horoscope.presenters.SelectTopicPresenter;
import com.witcher.horoscope.view.SelectTopicView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectTopicFragment extends Fragment implements SelectTopicView{

    @Inject
    protected SelectTopicPresenter mSelectTopicPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SAApplication.getApplicationComponent().inject(this);

        Bundle bundle = getArguments();

        if (bundle != null) {
            mSelectTopicPresenter.setSunSign((ConstantsSunSign)bundle.get(ExtraParameters.EXTRA_PARAM_SUN_SIGN));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_topic_fragment, container, false);

        ButterKnife.bind(this, view);

        mSelectTopicPresenter.onCreateView(savedInstanceState);
        mSelectTopicPresenter.setView(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSelectTopicPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mSelectTopicPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSelectTopicPresenter.onDestroy();
    }

    @OnClick({R.id.btn_common, R.id.btn_love, R.id.btn_business})
    protected void onSelectTopic(View view){
        String extra;
        switch (view.getId()){
            case R.id.btn_common:       extra = ConstantsURL.COMMON;         break;
            case R.id.btn_love:         extra = ConstantsURL.LOVE;           break;
            case R.id.btn_business:     extra = ConstantsURL.BUSINESS;       break;
            default: extra = "Error in SelectTopicFragment!";
        }

        this.mSelectTopicPresenter.showHoroscope(extra);
    }

}
