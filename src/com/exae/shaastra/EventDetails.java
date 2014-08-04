package com.exae.shaastra;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

public class EventDetails extends ActionBarActivity implements TabListener {

	
	String tabs[] = { "Introduction", "Event Format", "Map", "Prize Money" };
	ActionBar action_bar;
	ViewPager view_pager;
	TabsPageAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_details);
		view_pager = (ViewPager) findViewById(R.id.pager);
		action_bar = getSupportActionBar();
		action_bar.setDisplayShowTitleEnabled(true);
		action_bar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
		adapter = new TabsPageAdapter(getSupportFragmentManager());
		view_pager.setAdapter(adapter);
		action_bar.setHomeButtonEnabled(true);
		action_bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		action_bar.setStackedBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#292929")));
		for (String tab_name : tabs) {
			action_bar.addTab(action_bar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int arg0) {
						// TODO Auto-generated method stub
						action_bar.setSelectedNavigationItem(arg0);
					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {
						// TODO Auto-generated method stub

					}
				});
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		view_pager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
