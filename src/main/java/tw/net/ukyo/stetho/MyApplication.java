package tw.net.ukyo.stetho;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by ukyo on 2016/6/6.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
