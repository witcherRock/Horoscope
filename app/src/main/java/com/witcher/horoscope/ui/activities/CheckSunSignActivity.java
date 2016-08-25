package com.witcher.horoscope.ui.activities;

import android.support.v4.app.Fragment;

import com.witcher.horoscope.ui.fragments.CheckSunSignFragment;

/**
 * Created by Александр on 24.08.2016.
 */
public class CheckSunSignActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CheckSunSignFragment();
    }
}
