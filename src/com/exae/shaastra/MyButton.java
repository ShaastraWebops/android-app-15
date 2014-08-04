package com.exae.shaastra;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class MyButton extends Button{

	public MyButton(Context context) {
		super(context);
		init(null);
	}

	public MyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}
	private void init(AttributeSet attrs) {
		if (attrs!=null) {
			// TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
			// String fontName = a.getString(R.styleable.MyTextView_fontName);
			 //if (fontName!=null) {
				 Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "TitilliumWeb-Regular.ttf");
				 setTypeface(myTypeface);
				 setBackgroundDrawable(getResources().getDrawable(R.drawable.my_button));
				 setTextColor(Color.BLACK);
				 
			 //}
			 //a.recycle();
		}
	}

}
