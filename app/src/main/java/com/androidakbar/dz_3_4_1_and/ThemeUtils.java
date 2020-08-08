package com.androidakbar.dz_3_4_1_and;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {
    private static int sTheme = R.style.AppTheme;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity) {
        activity.setTheme(sTheme);
    }
}
