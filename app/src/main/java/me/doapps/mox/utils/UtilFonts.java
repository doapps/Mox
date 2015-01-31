package me.doapps.mox.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Bryam on 20/01/2015.
 */
public class UtilFonts {
    public static Typeface setBadaboom(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/badaboom.ttf");
    }

}