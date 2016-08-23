package coop.nofuemagia.elgermen;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by Tanoo on 22/8/2016.
 */
public class Util {
    public static String leerMetaData(Context c, String cual) {
        try {
            ApplicationInfo ai = c.getPackageManager().getApplicationInfo(c.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            String myApiKey = bundle.getString(cual);
            return myApiKey;
        } catch (Exception e) {
            return null;
        }
    }
}
