import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class EventMap extends Fragment{

	int screenwidth, screenheight;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
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
		TextView tv = new TextView(getActivity());
		tv.setGravity(Gravity.CENTER_HORIZONTAL);
		tv.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
		tv.setTextColor(Color.parseColor("#9a1000"));
		tv.setText("Location");
		ll.addView(tv, params);
		TextView tv1 = new TextView(getActivity());
		tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
		tv1.setGravity(Gravity.CENTER_HORIZONTAL);
		tv1.setText("Event is happening at");
		ll.addView(tv1, params);
		TextView tv2 = new TextView(getActivity());
		tv2.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
		tv2.setTextColor(Color.parseColor("#9a1000"));
		tv2.setGravity(Gravity.CENTER_HORIZONTAL);
		tv2.setText("Students Activity Center(SAC)");
		ll.addView(tv2, params);
		Button b1=new Button(getActivity());
		b1.setGravity(Gravity.CENTER_HORIZONTAL);
		b1.setBackgroundColor(Color.parseColor("#9a1000"));
		b1.setTextColor(Color.WHITE);
		b1.setText("Show in Map");
		params.gravity=Gravity.CENTER_HORIZONTAL;
		ll.addView(b1, params);
		return sv;
	}
}
