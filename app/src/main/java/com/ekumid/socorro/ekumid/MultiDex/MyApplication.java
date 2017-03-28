package com.ekumid.socorro.ekumid.MultiDex;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by lucky on 12-03-2017.
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

}
