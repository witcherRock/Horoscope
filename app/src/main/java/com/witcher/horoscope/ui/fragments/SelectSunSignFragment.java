package com.witcher.horoscope.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.witcher.horoscope.R;
import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.presenters.SelectSunSignPresenter;
import com.witcher.horoscope.view.SelectSunSignView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectSunSignFragment extends Fragment implements SelectSunSignView{

    @Inject
    protected SelectSunSignPresenter mSelectSunSignPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SAApplication.getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_sun_sign_fragment, container, false);

        ButterKnife.bind(this, view);

        mSelectSunSignPresenter.setView(this);
        mSelectSunSignPresenter.onCreateView(savedInstanceState);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSelectSunSignPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mSelectSunSignPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSelectSunSignPresenter.onDestroy();
    }

    @OnClick({  R.id.btn_aries,     R.id.btn_taurus,    R.id.btn_gemini,
                R.id.btn_cancer,    R.id.btn_leo,       R.id.btn_virgo,
                R.id.btn_libra,     R.id.btn_scorpio,   R.id.btn_sagittarius,
                R.id.btn_capricorn, R.id.btn_aquarius,  R.id.btn_pisces})
    protected void onSelectSunSing(View view){
        ConstantsSunSign extra = ConstantsSunSign.EMPTY;
        switch (view.getId()){
            case R.id.btn_aries:        extra = ConstantsSunSign.ARIES;         break;
            case R.id.btn_taurus:       extra = ConstantsSunSign.TAURUS;        break;
            case R.id.btn_gemini:       extra = ConstantsSunSign.GEMINI;        break;
            case R.id.btn_cancer:       extra = ConstantsSunSign.CANCER;        break;
            case R.id.btn_leo:          extra = ConstantsSunSign.LEO;           break;
            case R.id.btn_virgo:        extra = ConstantsSunSign.VIRGO;         break;
            case R.id.btn_libra:        extra = ConstantsSunSign.LIBRA;         break;
            case R.id.btn_scorpio:      extra = ConstantsSunSign.SCORPIO;       break;
            case R.id.btn_sagittarius:  extra = ConstantsSunSign.SAGITTARIUS;   break;
            case R.id.btn_capricorn:    extra = ConstantsSunSign.CAPRICORN;     break;
            case R.id.btn_aquarius:     extra = ConstantsSunSign.AQUARIUS;      break;
            case R.id.btn_pisces:       extra = ConstantsSunSign.PISCES;        break;
//            default: extra = "Error in SelectSunSignFragment!";
        }

        this.mSelectSunSignPresenter.nextStep(extra);
    }

    @OnLongClick({  R.id.btn_aries,     R.id.btn_taurus,    R.id.btn_gemini,
                    R.id.btn_cancer,    R.id.btn_leo,       R.id.btn_virgo,
                    R.id.btn_libra,     R.id.btn_scorpio,   R.id.btn_sagittarius,
                    R.id.btn_capricorn, R.id.btn_aquarius,  R.id.btn_pisces})
    protected boolean onLongClick(View view){
        String text;
        switch (view.getId()){
            case R.id.btn_aries:        text = getString(R.string.aries_text);         break;
            case R.id.btn_taurus:       text = getString(R.string.taurus_text);        break;
            case R.id.btn_gemini:       text = getString(R.string.gemini_text);        break;
            case R.id.btn_cancer:       text = getString(R.string.cancer_text);        break;
            case R.id.btn_leo:          text = getString(R.string.leo_text);           break;
            case R.id.btn_virgo:        text = getString(R.string.virgo_text);         break;
            case R.id.btn_libra:        text = getString(R.string.libra_text);         break;
            case R.id.btn_scorpio:      text = getString(R.string.scorpio_text);       break;
            case R.id.btn_sagittarius:  text = getString(R.string.sagittarius_text);   break;
            case R.id.btn_capricorn:    text = getString(R.string.capricorn_text);     break;
            case R.id.btn_aquarius:     text = getString(R.string.aquarius_text);      break;
            case R.id.btn_pisces:       text = getString(R.string.pisces_text);        break;
            default: text = "Error in SelectSunSignFragment!";
        }

        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();

        return true;
    }


}
