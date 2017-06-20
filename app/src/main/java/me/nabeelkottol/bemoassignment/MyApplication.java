package me.nabeelkottol.bemoassignment;

import android.app.Application;
import timber.log.Timber;

/**
 * Created by nabeelkottol on 20/06/17.
 */

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}
