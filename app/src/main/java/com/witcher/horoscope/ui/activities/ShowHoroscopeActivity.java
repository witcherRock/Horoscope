package com.witcher.horoscope.ui.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.witcher.horoscope.R;
import com.witcher.horoscope.SAApplication;
import com.witcher.horoscope.common.ConstantsSunSign;
import com.witcher.horoscope.common.ExtraParameters;
import com.witcher.horoscope.data.enity.Aquarius;
import com.witcher.horoscope.data.enity.Aries;
import com.witcher.horoscope.data.enity.BaseSunSign;
import com.witcher.horoscope.data.enity.Cancer;
import com.witcher.horoscope.data.enity.Capricorn;
import com.witcher.horoscope.data.enity.Gemini;
import com.witcher.horoscope.data.enity.Leo;
import com.witcher.horoscope.data.enity.Libra;
import com.witcher.horoscope.data.enity.Pisces;
import com.witcher.horoscope.data.enity.Sagittarius;
import com.witcher.horoscope.data.enity.Scorpio;
import com.witcher.horoscope.data.enity.Taurus;
import com.witcher.horoscope.data.enity.Virgo;
import com.witcher.horoscope.presenters.HoroscopePresenter;
import com.witcher.horoscope.ui.fragments.CheckSunSignFragment;
import com.witcher.horoscope.ui.fragments.OnFragmentResultListener;
import com.witcher.horoscope.ui.fragments.TabFragment;
import com.witcher.horoscope.ui.adapters.ViewPagerAdapter;
import com.witcher.horoscope.view.HoroscopeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Александр on 17.08.2016.
 */
public class ShowHoroscopeActivity extends AppCompatActivity implements HoroscopeView, OnFragmentResultListener {

    @BindView(R.id.tabs)
    protected TabLayout tabLayout;
    @BindView(R.id.viewpager)
    protected ViewPager viewPager;
    @BindView(R.id.toolbar_second)
    protected Toolbar mToolbar;
    @BindView(R.id.progressBar)
    protected ProgressBar mProgressBar;

    @Inject
    protected HoroscopePresenter mHoroscopePresenter;

    private BaseSunSign mBaseSunSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_horoscope_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        setDisplayHomeAsUpEnabled(true);

        SAApplication.getApplicationComponent().inject(this);
//
//        setupViewPager(viewPager);
//
//        tabLayout.setupWithViewPager(viewPager);

        Bundle bundle = getIntent().getExtras();
        ConstantsSunSign sunSing = (ConstantsSunSign)bundle.get(ExtraParameters.EXTRA_PARAM_SUN_SIGN);
        String topic = bundle.getString(ExtraParameters.EXTRA_PARAM_TOPIC);

        mHoroscopePresenter.setTypeHoroscope(topic);
        mHoroscopePresenter.setSunSign(sunSing);
        mHoroscopePresenter.setView(this);
        mHoroscopePresenter.onCreateView(savedInstanceState);


    }

    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }
    protected void showDialogShare(){
        TextView showText = new TextView(this);
        showText.setText(getString(R.string.text_share_link));
        showText.setTextIsSelectable(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(showText)
                .setTitle(getString(R.string.title_dialog_share))
                .setCancelable(true)
                .show();
    }

    private ConstantsSunSign switchSunSing(){
        String nameClass = mBaseSunSign.getClass().getName();
        ConstantsSunSign sunSign = ConstantsSunSign.EMPTY;
        if(nameClass.equals(Aquarius.class.getName()))      sunSign = ConstantsSunSign.AQUARIUS;
        if(nameClass.equals(Aries.class.getName()))         sunSign = ConstantsSunSign.ARIES;
        if(nameClass.equals(Cancer.class.getName()))        sunSign = ConstantsSunSign.CAPRICORN;
        if(nameClass.equals(Capricorn.class.getName()))     sunSign = ConstantsSunSign.CAPRICORN;
        if(nameClass.equals(Gemini.class.getName()))        sunSign = ConstantsSunSign.GEMINI;
        if(nameClass.equals(Leo.class.getName()))           sunSign = ConstantsSunSign.LEO;
        if(nameClass.equals(Libra.class.getName()))         sunSign = ConstantsSunSign.LIBRA;
        if(nameClass.equals(Pisces.class.getName()))        sunSign = ConstantsSunSign.PISCES;
        if(nameClass.equals(Sagittarius.class.getName()))   sunSign = ConstantsSunSign.SAGITTARIUS;
        if(nameClass.equals(Scorpio.class.getName()))       sunSign = ConstantsSunSign.SCORPIO;
        if(nameClass.equals(Taurus.class.getName()))        sunSign = ConstantsSunSign.TAURUS;
        if(nameClass.equals(Virgo.class.getName()))         sunSign = ConstantsSunSign.VIRGO;

        return sunSign;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ConstantsSunSign sunSign = switchSunSing();

        TabFragment fragment = new TabFragment();
        fragment.setPrediction(mBaseSunSign.getToday());
        fragment.setSunSing(sunSign);
        adapter.addFragment(fragment, getString(R.string.tab_today_text));

        fragment = new TabFragment();
        fragment.setPrediction(mBaseSunSign.getTomorrow());
        fragment.setSunSing(sunSign);
        adapter.addFragment(fragment, getString(R.string.tab_tomorrow_text));

        fragment = new TabFragment();
        fragment.setPrediction(mBaseSunSign.getTomorrow02());
        fragment.setSunSing(sunSign);
        adapter.addFragment(fragment, getString(R.string.tab_tomorrow2_text));

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_check_sun_sign:
                    Intent intent = new Intent(getBaseContext(), CheckSunSignActivity.class);
                    startActivity(intent);
                break;
            case R.id.action_share:
                showDialogShare();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean isOnline() {
        try
        {
            ConnectivityManager cm = (ConnectivityManager)getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        }
        catch (Exception e) { return false; }
    }

    @Override
    public void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.text_no_internet)
                .setTitle(R.string.title_dialog_no_internet)
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void enabledProgressBar(boolean enabled) {
        if(enabled) mProgressBar.setVisibility(ProgressBar.VISIBLE);
        else mProgressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void showHoroscope(BaseSunSign sunSignPrediction) {

        mBaseSunSign = sunSignPrediction;

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onStart() {
        super.onStart();

        mHoroscopePresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mHoroscopePresenter.onStart();
    }

    @Override
    public void onDestroy() {
        mHoroscopePresenter.onDestroy();

        super.onDestroy();
    }

    @Override
    public void onClose() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void onResult(Intent intent) {
        setResult(RESULT_OK, intent);
        finish();
    }
}
