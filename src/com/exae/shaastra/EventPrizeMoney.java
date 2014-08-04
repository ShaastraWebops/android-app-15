package com.exae.shaastra;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class EventPrizeMoney extends Fragment{

	int screenwidth, screenheight;
	String text="Prizes worth Rs.60,000/- to be won!!!\n\n1st Prize - Rs.30,000/-\n2nd Prize - Rs.20,000/-\n3rd Prize - Rs.10,000/-\n\nCertificates will be given to top 3 teams and also to the finalists which stand as testimony of your skill and valour.";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
				"TitilliumWeb-Regular.ttf");
		screenwidth = getActivity().getWindowManager().getDefaultDisplay()
				.getWidth();
		screenheight = getActivity().getWindowManager().getDefaultDisplay()
				.getHeight();
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(screenwidth / 60, screenwidth / 60, screenwidth / 60,
				screenwidth / 60);
		ScrollView sv = (ScrollView) inflater.inflate(R.layout.fragment, null);
		LinearLayout ll = (LinearLayout) sv.findViewById(R.id.ex);
		TextView tv=new TextView(getActivity());
		tv.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
		tv.setText(text);
		tv.setTypeface(tf);
		tv.setTextColor(Color.WHITE);
		ll.addView(tv, params);
		return sv;
	}
}
