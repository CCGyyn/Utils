package com.miki.utils;

import android.app.Activity;

/**
 * @author：cai_gp on 2019/7/15 16:05
 */
public class MainActivity extends Activity {
    MyLogUtil m;
    @Override
    public void onBackPressed() {
        android.util.Log.d("ccg", "" + m.getClass().getName());
    }
}
