package org.maison.android.ffanswerEn.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

	final int PAGE_COUNT = 14;

	private String TAG="MainStatePagerAdapter";

	/** Constructor of the class */
	public MyFragmentStatePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {

		MyFragment myFragment = new MyFragment();
		Bundle data = new Bundle();
		data.putInt("current_page", arg0);
		myFragment.setArguments(data);
		Log.d(TAG,"getItem,arg0="+arg0);
		return myFragment;

	}

	/** Returns the number of pages */
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "Leçon " + (position + 1);
	}

}
