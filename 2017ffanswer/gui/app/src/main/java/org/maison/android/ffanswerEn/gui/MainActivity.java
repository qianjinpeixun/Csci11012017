package org.maison.android.ffanswerEn.gui;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.maison.android.ffanswerEn.gui.R;
import org.maison.android.ffanswerEn.gui.databinding.ActivityMainBinding;
import org.maison.android.ffanswerEn.utils.IabHelper;
import org.maison.android.ffanswerEn.utils.IabResult;
import org.maison.android.ffanswerEn.utils.Inventory;
import org.maison.android.ffanswerEn.utils.Purchase;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private String TAG="MainActivity";

    private ViewPager pager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
        .build();
        ImageLoader.getInstance().init(config);

        pager=binding.pager;
        tabLayout=binding.tablayout;
        //ViewPager pager = (ViewPager) findViewById(R.id.pager);

        /** Getting fragment manager */
        FragmentManager fm = getSupportFragmentManager();

        /** Instantiating FragmentPagerAdapter */
        //MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(fm);
        MyFragmentStatePagerAdapter pagerAdapter = new MyFragmentStatePagerAdapter(fm);


        /** Setting the pagerAdapter to the pager object */
        pager.setAdapter(pagerAdapter);

        //tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(pager);

    }



}
