import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class EventFormat extends Fragment {

	String text[] = {
			"Round-1: Prelims (TDP Submission)",
			"In this round, teams will need to submit a Team Description Paper (TDP). You will have to provide your complete team details, answer a subjective questionnaire related to your design of the Aerobot and submit your design\n\nNote: Submission of TDP should be done in a prescribed format; please check the problem statement tab to download the TDP",
			"Round-2: Checkpoint",
			"Shortlisted teams from the first round will be invited to IIT Madras during Shaastra 2015, which will be held from 4th to 7th of January.\n\nThis round will conprise of \n\n1.Checking the presence of all modules required to complete the problem statement.\n\n2.Completing a specific set of tasks to check proper working of the hovercraft.\n\n3.Checking whether all the modules satisfy the rules and regulations.",
			"Round-3: Final Round",
			"Final round will comprise of a competition between the selected teams to coompete the problem statement on the game arena." };
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
		tv.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Medium);
		tv.setTextColor(Color.parseColor("#9a1000"));
		tv.setText(text[0]);
		ll.addView(tv, params);
		TextView tv1 = new TextView(getActivity());
		tv1.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Small);
		tv1.setText(text[1]);
		ll.addView(tv1, params);
		TextView tv2 = new TextView(getActivity());
		tv2.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Medium);
		tv2.setTextColor(Color.parseColor("#9a1000"));
		tv2.setText(text[2]);
		ll.addView(tv2, params);
		TextView tv3 = new TextView(getActivity());
		tv3.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Small);
		tv3.setText(text[3]);
		ll.addView(tv3, params);
		TextView tv4 = new TextView(getActivity());
		tv4.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Medium);
		tv4.setTextColor(Color.parseColor("#9a1000"));
		tv4.setText(text[4]);
		ll.addView(tv4, params);
		TextView tv5 = new TextView(getActivity());
		tv5.setTextAppearance(getActivity(),
				android.R.style.TextAppearance_Small);
		tv5.setText(text[5]);
		ll.addView(tv5, params);
		return sv;
	}
}
