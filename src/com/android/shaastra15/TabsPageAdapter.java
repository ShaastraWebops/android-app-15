import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPageAdapter extends FragmentPagerAdapter {

	public TabsPageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
         switch(index){
         case 0:
        	 return new EventIntroduction();
         case 1:
        	 return new EventFormat();
         case 2:
        	 return new EventMap();
         case 3:
        	 return new EventPrizeMoney();
         }
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}
