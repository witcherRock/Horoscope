package com.witcher.horoscope.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.NumberPicker;

import com.squareup.picasso.Picasso;
import com.witcher.horoscope.R;
import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.presenters.CheckSunSignPresenter;
import com.witcher.horoscope.view.CheckSunSignView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Александр on 24.08.2016.
 */
public class CheckSunSignFragment extends Fragment implements CheckSunSignView {

    @BindView(R.id.number_picker_day)
    protected NumberPicker mDayPicker;

    @BindView(R.id.number_picker_month)
    protected NumberPicker mMonthPicker;

    @BindView(R.id.imageViewSunSignCheck)
    protected ImageView mImageView;

    @BindView(R.id.btn_sun_sign)
    protected AppCompatButton mCompatButton;

    @Inject
    protected CheckSunSignPresenter mCheckSunSignPresenter;

    private CustomDatePicker mCustomDatePicker;

    private class CustomDatePicker implements NumberPicker.OnValueChangeListener{
        private final String[] mMonth = {
                "January",      "February",      "March",    "April",
                "May",          "June",         "July",     "August",
                "September",    "October",      "November", "December"
        };

        private final ConstantsSunSign[] mSunSign = {
                ConstantsSunSign.CAPRICORN, ConstantsSunSign.AQUARIUS,  ConstantsSunSign.PISCES,
                ConstantsSunSign.ARIES,     ConstantsSunSign.TAURUS,    ConstantsSunSign.GEMINI,
                ConstantsSunSign.CANCER,    ConstantsSunSign.LEO,       ConstantsSunSign.VIRGO,
                ConstantsSunSign.LIBRA,     ConstantsSunSign.SCORPIO,   ConstantsSunSign.SAGITTARIUS
        };

        private ConstantsSunSign mOldValue;

        public void onSetupPicker(){
            mMonthPicker.setMinValue(1);
            mMonthPicker.setDisplayedValues(mMonth);
            mMonthPicker.setMaxValue(mMonth.length);

            mDayPicker.setMinValue(1);
            mDayPicker.setMaxValue(31);

            mMonthPicker.setOnValueChangedListener(this);
            mDayPicker.setOnValueChangedListener(this);

            mOldValue = ConstantsSunSign.CAPRICORN;
            Picasso.with(getContext()).load(R.drawable.capricornus_1).into(mImageView);
            mCompatButton.setText(getString(R.string.capricorn_text));
            mCompatButton.setTag(ConstantsSunSign.CAPRICORN);
        }
        private void onChangeMaxDays(int i1){
            int maxDays         = 0;
            switch (i1){
                case 1: maxDays  = 31; break;
                case 2: maxDays  = 29; break;
                case 3: maxDays  = 31; break;
                case 4: maxDays  = 30; break;
                case 5: maxDays  = 31; break;
                case 6: maxDays  = 30; break;
                case 7: maxDays  = 31; break;
                case 8: maxDays  = 31; break;
                case 9: maxDays  = 30; break;
                case 10: maxDays = 31; break;
                case 11: maxDays = 30; break;
                case 12: maxDays = 31; break;
            }
            mDayPicker.setMaxValue(maxDays);
        }

        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            int currentMonth    = -1;
            int currentDay      = -1;

            switch(numberPicker.getId()){
                case R.id.number_picker_day:
                    currentMonth = mMonthPicker.getValue();
                    currentDay = i1;              break;
                case R.id.number_picker_month:
                    currentMonth = i1;
                    currentDay = mDayPicker.getValue();
                    onChangeMaxDays(i1);          break;
            }

            ConstantsSunSign sunSignName = ConstantsSunSign.EMPTY;

            if ((currentDay >= 22) && (currentMonth < 12) && (currentMonth >= 1))
                sunSignName = mSunSign[currentMonth]; else sunSignName = mSunSign[currentMonth  - 1];
            if ((currentDay < 22 )&&(currentMonth == 1)|| (currentMonth == 12)&& (currentDay>=22))
                sunSignName = mSunSign[0];

            if(mOldValue == sunSignName) return;
            else mOldValue = sunSignName;

            int drawableID = -1, stringID = -1;
            switch (sunSignName){
                case ARIES:         drawableID = R.drawable.aquarius_1;         stringID = R.string.aquarius_text;     break;
                case TAURUS:        drawableID = R.drawable.taurus_1;           stringID = R.string.taurus_text;       break;
                case GEMINI:        drawableID = R.drawable.gemini_1;           stringID = R.string.gemini_text;       break;
                case CANCER:        drawableID = R.drawable.cancer_1;           stringID = R.string.cancer_text;       break;
                case LEO:           drawableID = R.drawable.leo_1;              stringID = R.string.leo_text;          break;
                case VIRGO:         drawableID = R.drawable.virgo_1;            stringID = R.string.virgo_text;        break;
                case LIBRA:         drawableID = R.drawable.libra_1;            stringID = R.string.libra_text;        break;
                case SCORPIO:       drawableID = R.drawable.scorpio_1;          stringID = R.string.scorpio_text;      break;
                case SAGITTARIUS:   drawableID = R.drawable.sagittarius_1;      stringID = R.string.sagittarius_text;  break;
                case CAPRICORN:     drawableID = R.drawable.capricornus_1;      stringID = R.string.capricorn_text;    break;
                case AQUARIUS:      drawableID = R.drawable.aquarius_1;         stringID = R.string.aquarius_text;     break;
                case PISCES:        drawableID = R.drawable.scorpio_1;          stringID = R.string.scorpio_text;      break;
            }

            if(drawableID != -1)    Picasso.with(getContext()).load(drawableID).into(mImageView);
            if(stringID != -1)      mCompatButton.setText(getString(stringID));
            mCompatButton.setTag(sunSignName);
        }
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SAApplication.getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.check_sun_sign_fragment, container, false);

        ButterKnife.bind(this, view);

        mCheckSunSignPresenter.setView(this);
        mCheckSunSignPresenter.onCreateView(savedInstanceState);

        mCustomDatePicker = new CustomDatePicker();
        mCustomDatePicker.onSetupPicker();

        return view;
    }

    @OnClick(R.id.btn_sun_sign)
    public void onClickPrediction(View view){
        ConstantsSunSign sunSign = (ConstantsSunSign)view.getTag();
        mCheckSunSignPresenter.startPrediction(sunSign);
        //getActivity().finish();
    }

    @Override
    public void onStart() {
        super.onStart();

        mCheckSunSignPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mCheckSunSignPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mCheckSunSignPresenter.onDestroy();
    }

}
