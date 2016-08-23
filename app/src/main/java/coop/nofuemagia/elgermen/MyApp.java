package coop.nofuemagia.elgermen;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Tanoo on 22/8/2016.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
    }
}
