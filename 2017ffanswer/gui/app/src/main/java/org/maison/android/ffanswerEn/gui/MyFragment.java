package org.maison.android.ffanswerEn.gui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.maison.android.ffanswerEn.gui.databinding.MyfragmentLayoutBinding;
import org.maison.android.ffanswerEn.viewmodel.MainViewModel;

public class MyFragment extends Fragment { /* public class DetailActivity extends Activity {*/
    static final String TAG = "MainFragment";
    int mCurrentPage;
    private Context mContext;
    private MainActivity myAct;
    private MyfragmentLayoutBinding binding;

    private MainViewModel mainViewModel;
    private Bundle bundle;
    private int currNo;
    private Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Getting the arguments to the Bundle object */
        Bundle data = getArguments();
        /** Getting integer data of the key current_page from the bundle */
        mCurrentPage = data.getInt("current_page", 0);

        Log.d(TAG,"mCurrentPage="+mCurrentPage);
        myAct = (MainActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //View v = inflater.inflate(R.layout.myfragment_layout, container, false);

        mContext = container.getContext();

        binding = DataBindingUtil.inflate(inflater, R.layout
                .myfragment_layout, container, false);
        MainViewModel mainViewModel = new MainViewModel(mCurrentPage, mContext);
        Log.d(TAG,"mCurrentPage="+mCurrentPage+",mainViewModel="+mainViewModel);
        binding.setListenPage(mainViewModel);
        return binding.getRoot();
    }


}
