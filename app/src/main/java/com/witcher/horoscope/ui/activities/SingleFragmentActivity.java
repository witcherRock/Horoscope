package com.witcher.horoscope.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.witcher.horoscope.R;
import com.witcher.horoscope.ui.fragments.CheckSunSignFragment;
import com.witcher.horoscope.ui.fragments.OnFragmentResultListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Александр on 17.08.2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity implements OnFragmentResultListener {

    protected Bundle mBundle;

    @BindView(R.id.toolbar_first)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        handleIntent(getIntent());

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            addFragment();
        }
    }

    protected abstract Fragment getFragment();

    protected void handleIntent(Intent intent) {
        this.mBundle = intent.getExtras();
    }

    protected void addFragment() {
        replaceFragment(getFragment(), false);
    }

    protected Fragment findFragmentByClass(Class fragmentClass) {
        return getSupportFragmentManager().findFragmentByTag(fragmentClass.getName());
    }

    protected void replaceFragment(Fragment showFragment, boolean addToBackStack) {
        if (showFragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, showFragment, showFragment.getClass().getName());

            if (addToBackStack)
                fragmentTransaction.addToBackStack(showFragment.getClass().getName());

            fragmentTransaction.commit();
        }
    }

    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    protected void setHomeAsUpIndicator(int resId) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    protected void hideActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
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
                if(!this.getCurrentFragment().getClass().getName().equals(CheckSunSignFragment.class.getName())){
                    Intent intent = new Intent(getBaseContext(), CheckSunSignActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.action_share:
                showDialogShare();
                break;

        }

        return super.onOptionsItemSelected(item);
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
