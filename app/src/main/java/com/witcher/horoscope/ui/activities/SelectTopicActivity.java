package com.witcher.horoscope.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.witcher.horoscope.ui.fragments.SelectTopicFragment;

/**
 * Created by Александр on 17.08.2016.
 */
public class SelectTopicActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        Bundle bundle = getIntent().getExtras();

        SelectTopicFragment fragment = new SelectTopicFragment();

        if (bundle != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }
}
