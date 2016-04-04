package com.vtron.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xinghua on 2016/4/4.
 */
public class MarqueeText extends TextView {
    public MarqueeText(Context context){
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean isFocused(){
        return true;
    }
}
