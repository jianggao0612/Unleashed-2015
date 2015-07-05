package com.lordmayors.shftr.views;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 4/07/15.
 */
public class FontCache
{
    public static String FONT_AWESOME = "fontawesome-webfont.ttf";

    private static Map<String, Typeface> map = new HashMap<String,Typeface>();

    public static Typeface get(Context context,String strTypeface)
    {
        Typeface typeface = map.get( strTypeface );

        if (typeface == null)
        {
            typeface = Typeface.createFromAsset(context.getAssets(), strTypeface );
            map.put(strTypeface, typeface);
        }

        return typeface;
    }
}
