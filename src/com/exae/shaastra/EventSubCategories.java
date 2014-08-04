package com.exae.shaastra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class EventSubCategories extends ActionBarActivity implements OnClickListener {
	int screenwidth, screenheight;
	String titles[] = { "Aerobotics", "Wright Design", "Airshow",
			"Boeing National Aeromodelling Competition" };
	String description = "Wright design is a design and build event which gives you the opportunity to bring out the best of the aero modeler in you....";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.event_sub_categories);
		screenwidth = getWindowManager().getDefaultDisplay().getWidth();
		screenheight = getWindowManager().getDefaultDisplay().getHeight();
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView yourTextView = (TextView) findViewById(titleId);
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"TitilliumWeb-Regular.ttf");
		yourTextView.setTypeface(tf);
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#292929")));
		getSupportActionBar().setHomeButtonEnabled(true);
		
		ScrollView sv = new ScrollView(this);
		LinearLayout linear_layout = new LinearLayout(this);
		linear_layout.setOrientation(LinearLayout.VERTICAL);
		sv.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.bg));
		for (int i = 0; i <= (titles.length / 1); i++) {
			LinearLayout ll = new LinearLayout(this);
			LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			ll.setLayoutParams(params);
			ll.setOrientation(LinearLayout.HORIZONTAL);
			for (int j = 0; j <= 0; j++) {
				if ((i * 1 + j + 1) < titles.length + 1) {
					LinearLayout event = (LinearLayout) getLayoutInflater()
							.inflate(R.layout.event_sub_categories, null);
					((TextView) event.findViewById(R.id.title))
							.setText(titles[i * 1 + j]);
					((TextView) event.findViewById(R.id.description))
							.setText(description);
					((Button) event.findViewById(R.id.view_details)).setId(i
							* 1 + j);
					((Button) event.findViewById(i*1+j)).setOnClickListener(this);
					LayoutParams event_params = new LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					event_params.width = (screenwidth / 1) - 10;
					// event_params.height = (screenwidth / 1) - 10;
					event_params.gravity = Gravity.CENTER;
					event_params.setMargins(5, 5, 0, 0);
					event.setLayoutParams(event_params);
					ll.addView(event);

				} else {
					break;
				}
			}
			linear_layout.addView(ll, i);
		}
		sv.addView(linear_layout);
		setContentView(sv);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this, EventDetails.class);
		startActivity(i);
	}
}
