package com.lordmayors.shftr.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class TextAwesome extends TextView
{
    public TextAwesome(Context context)
    {
        super(context);
        init( context );
    }

    public TextAwesome(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init( context );
    }

    public void init( Context context )
    {
        Typeface typeface = FontCache.get(context,FontCache.FONT_AWESOME);

        setTypeface(typeface);

    }

}