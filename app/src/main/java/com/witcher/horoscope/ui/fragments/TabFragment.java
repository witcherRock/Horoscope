package com.witcher.horoscope.ui.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.witcher.horoscope.R;
import com.witcher.horoscope.common.ConstantsSunSign;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Александр on 18.08.2016.
 */
public class TabFragment extends Fragment {

    @BindView(R.id.tv_prediction)
    protected TextView mTextView;

    @BindView(R.id.imageView)
    protected ImageView mImageView;

    private String mPrediction;
    private ConstantsSunSign mSunSing;


    public TabFragment() {
    }

    public void setPrediction(String mPrediction) {
        this.mPrediction = mPrediction;
    }
    public void setSunSing(ConstantsSunSign mSunSing) { this.mSunSing = mSunSing; }

    private void setDrawable(){
        int drawableID = -1;
        switch (mSunSing){
            case ARIES:         drawableID = R.drawable.aquarius_1;         break;
            case TAURUS:        drawableID = R.drawable.taurus_1;           break;
            case GEMINI:        drawableID = R.drawable.gemini_1;           break;
            case CANCER:        drawableID = R.drawable.cancer_1;           break;
            case LEO:           drawableID = R.drawable.leo_1;              break;
            case VIRGO:         drawableID = R.drawable.virgo_1;            break;
            case LIBRA:         drawableID = R.drawable.libra_1;            break;
            case SCORPIO:       drawableID = R.drawable.scorpio_1;          break;
            case SAGITTARIUS:   drawableID = R.drawable.sagittarius_1;      break;
            case CAPRICORN:     drawableID = R.drawable.capricornus_1;      break;
            case AQUARIUS:      drawableID = R.drawable.aquarius_1;         break;
            case PISCES:        drawableID = R.drawable.scorpio_1;          break;
        }

        if(drawableID != -1)    Picasso.with(getContext()).load(drawableID).into(mImageView);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment, container, false);
        ButterKnife.bind(this, view);

        mTextView.setTypeface(Typeface.createFromAsset(
                getActivity().getAssets(), "fonts/Bankir-Retro.ttf"));

        if(mPrediction != null) mTextView.setText(mPrediction);

        setDrawable();

        return view;
    }
}
