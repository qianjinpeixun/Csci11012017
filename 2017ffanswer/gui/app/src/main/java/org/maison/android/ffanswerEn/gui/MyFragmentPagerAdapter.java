package org.maison.android.ffanswerEn.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	final int PAGE_COUNT = 14;
	private String TAG="MyFragmentPagerAdapter";
	

	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {

		MyFragment myFragment = new MyFragment();
		Bundle data = new Bundle();
		data.putInt("current_page", arg0);
		myFragment.setArguments(data);

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
