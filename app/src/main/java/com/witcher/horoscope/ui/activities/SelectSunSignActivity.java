package com.witcher.horoscope.ui.activities;

import android.support.v4.app.Fragment;

import com.witcher.horoscope.ui.fragments.SelectSunSignFragment;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectSunSignActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SelectSunSignFragment();
    }
}
