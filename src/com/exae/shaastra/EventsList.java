package com.exae.shaastra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class EventsList extends ActionBarActivity implements OnClickListener {

	String events_list[] = { "AEROFEST", "DESIGN AND BUILD", "CODING",
			"INVOLVE & QUIZZES", "ELECTRONICS", "FLAGSHIP", "SPOTLIGHT",
			"WORKSHOPS", "SHOWS", "B-EVENTS" };
	int bg_img_ids[] = { R.drawable.aero, R.drawable.design, R.drawable.coding,
			R.drawable.involve, R.drawable.elec, R.drawable.dept,
			R.drawable.spotlight, R.drawable.ws, R.drawable.exhibitions,
			R.drawable.bevent };
    int event_icon_ids[]={ R.drawable.aerofest1, R.drawable.design1, R.drawable.coding1,
			R.drawable.quiz1, R.drawable.elec1, R.drawable.dept1,
			R.drawable.spotlight1, R.drawable.workshop1, R.drawable.shows1,
			R.drawable.bevent1 };
	String description = "Involving both. competitions and shows, Aero Fest lays down a perfect platform for Shaastra to shine. Unleash the aero-modeller within you and treat yourself with a perfect 'airy' experience.";
	int screenwidth, screenheight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(screenwidth / 60, screenwidth / 60, screenwidth / 60,
				screenwidth / 60);
		params.width = screenwidth - 10;
		params.height = screenwidth / 2;
		for (int i = 0; i < events_list.length; i++) {
			LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(
					R.layout.events_list, null);
			((RelativeLayout)ll.findViewById(R.id.rl)).setBackgroundDrawable(getResources().getDrawable(bg_img_ids[i]));
			((ImageView)ll.findViewById(R.id.event_img)).setImageDrawable(getResources().getDrawable(event_icon_ids[i]));
			ll.setLayoutParams(params);
			ll.setOnClickListener(this);
			ll.setId(i);
			linear_layout.addView(ll, i);
		}
		sv.addView(linear_layout);
		setContentView(sv);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this, EventSubCategories.class);
		startActivity(i);
	}
	
	
	

}
