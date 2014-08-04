package com.exae.shaastra;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class EventIntroduction extends Fragment implements OnClickListener {

	int screenwidth, screenheight;
	String text = "Want to make something that flies? Think you are smart enough to automate it? We present AEROBOTICS, a unique blend of two very exciting fields of aero modelling and robotics, thereby Taking Robotics to the Vertical Dimension. \nAll you need is a flying machine up to perform a specific set of tasks in a controlled environment. Testing the team on a variety of skills, the event pushes your innovation and creativity to the limits.";
    ImageView iv;
    int img_id_list[]={R.drawable.swimming,R.drawable.himalya,R.drawable.hospital,R.drawable.gurunat};
    int current_item;
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
		current_item=0;
		ScrollView sv = (ScrollView) inflater.inflate(R.layout.fragment, null);
		LinearLayout ll = (LinearLayout) sv.findViewById(R.id.ex);
		RelativeLayout rl = (RelativeLayout) getActivity().getLayoutInflater()
				.inflate(R.layout.facilities_list, null);
		iv=(ImageView) rl.findViewById(R.id.fac_img);
		android.widget.RelativeLayout.LayoutParams para=(android.widget.RelativeLayout.LayoutParams) iv.getLayoutParams();
		para.height=3*screenwidth/5;
		((ImageView)rl.findViewById(R.id.back)).setOnClickListener(this);
		((ImageView)rl.findViewById(R.id.next)).setOnClickListener(this);
        LayoutParams params=new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(screenwidth/60,screenwidth/60,screenwidth/60, screenwidth/60);
        rl.setLayoutParams(params);
		ll.addView(rl);
        TextView tv=new TextView(getActivity());
        tv.setTextAppearance(getActivity(), android.R.style.TextAppearance_Large);
        tv.setTextColor(Color.WHITE);
        tv.setTypeface(tf);
        tv.setText("Introduction");
        ll.addView(tv, params);
        TextView tv1=new TextView(getActivity());
        tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Small);
        tv1.setTextColor(Color.WHITE);
        tv1.setTypeface(tf);
        tv1.setText(text);
        ll.addView(tv1, params);
		return sv;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.next:
			if (current_item == img_id_list.length-1) {
				iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),
						img_id_list[0]));
				current_item = 0;
			} else
				iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),
						img_id_list[++current_item]));
			break;

		case R.id.back:
			if (current_item == 0) {
				iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),
						img_id_list[img_id_list.length-1]));
				current_item =img_id_list.length-1;
			} else
			iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),
					img_id_list[--current_item]));
			break;
		}
	}

}
