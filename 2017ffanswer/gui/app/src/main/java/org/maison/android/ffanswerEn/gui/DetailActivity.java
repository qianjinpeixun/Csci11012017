package org.maison.android.ffanswerEn.gui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.maison.android.ffanswerEn.events.MessageEvent;
import org.maison.android.ffanswerEn.gui.databinding.ActivityDetailBinding;
import org.maison.android.ffanswerEn.gui.databinding.ActivityMainBinding;
import org.maison.android.ffanswerEn.utils.IabBroadcastReceiver;
import org.maison.android.ffanswerEn.utils.IabHelper;
import org.maison.android.ffanswerEn.utils.IabResult;
import org.maison.android.ffanswerEn.utils.Inventory;
import org.maison.android.ffanswerEn.utils.Purchase;
import org.maison.android.ffanswerEn.viewmodel.DetailViewModel;


public class DetailActivity extends AppCompatActivity implements IabBroadcastReceiver.IabBroadcastListener {
    IabHelper mHelper;
    private boolean hasBuy;
    private Context mContext;
    private final int RC_REQUEST = 10001;
    // Provides purchase notification while this app is running
    IabBroadcastReceiver mBroadcastReceiver;
    private String TAG = "DetailActivity";
    static final String SKU_PREMIUM = "org.mason.ffanswer.argent";
    static final String SKU_50 = "org.mason.ffanswer.50buy";
    static final String SKU_100 = "org.mason.ffanswer.100buy";
    static final String SKU_all = "org.mason.ffanswer.alltext";
    //static final String SKU_all = "android.test.purchased";


    private boolean maybeBuy = false;
    boolean mIsPremium = false;
    boolean mIs50 = false;
    boolean mIs100 = false;
    boolean mIsall = false;

    DetailViewModel detailViewModel;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);
        mContext = this;
        hasBuy = false;
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Bundle bundle = this.getIntent().getExtras();
        String currentNo = bundle.getString("currentNo");
        detailViewModel = new DetailViewModel(Integer.valueOf(currentNo).intValue(), mContext);
        binding.setDetailViewModel(detailViewModel);
        Log.d(TAG, "currentNo=" + currentNo);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-2826997374472905~2585259275");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        /*
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                //.addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
                .build();
        adView.loadAd(request);
        */

        String ke = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgLmGS1cYENIs4A3Cv2vpiE/cVBIbXHF6T0XT+w1KaNFg0RUbSm" +
                "+NtkTz4XEUJqBczpYuh00AwfVRqcdn9X5Tw1eFSRdM80bVH0X9B47FK+rSWmkv8ma4GIVUfTpjYkg9AMhIokOWrqL" +
                "+fYsW5fdm0ymukSxpYO3qapbWG2RdCjjaplDuqr5JmPAE79lJW997VpzDBtj58" +
                "/dCkBiOcn2WDQ5l276nnLVrwdxrOLW4z6xJwuyS/kmGUtlBk/T0i3ADOGSRwfu7IzoNNy4VnH60AyAUw72K4jUvcaXedTmAW" +
                "/ZM4pRzr7+r+hpfkL7FKVGTxg0/UsJg641yTU3CAdC18QIDAQAB";
        mHelper = new IabHelper(this, ke);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    maybeBuy = false;
                    complain("Problem setting up in-app billing: " + result);
                    Log.d(TAG, "Problem setting up In-app Billing: " + result);
                    return;
                }
                if (mHelper == null) return;
                // Hooray, IAB is fully set up!
                maybeBuy = true;

                mBroadcastReceiver = new IabBroadcastReceiver(DetailActivity.this);
                IntentFilter broadcastFilter = new IntentFilter(IabBroadcastReceiver.ACTION);
                registerReceiver(mBroadcastReceiver, broadcastFilter);

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                Log.d(TAG, "Setup successful. Querying inventory.");
                try {
                    mHelper.queryInventoryAsync(mGotInventoryListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    complain("Error querying inventory. Another async operation in progress.");
                }
            }
        });


    }


    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;


            if (result.isFailure()) {
                // handle error here
                complain(" Connect to internet failed, maybe you can reboot your device and be sure that you have " +
                        "been connected the WEB.");
                return;
            }

            // Is it a failure?


            Log.d(TAG, "Query inventory was successful.");

            // does the user have the premium upgrade?
            // Do we have the premium upgrade?
            Purchase allPurchase = inventory.getPurchase(SKU_all);
            mIsall = (allPurchase != null);

            Purchase prePurchase = inventory.getPurchase(SKU_PREMIUM);
            mIsPremium = (prePurchase != null);

            Purchase a50Purchase = inventory.getPurchase(SKU_50);
            mIs50 = (a50Purchase != null);

            Purchase a100Purchase = inventory.getPurchase(SKU_100);
            mIs100 = (a100Purchase != null);

            if (mIs50 == true || mIs100 == true || mIsall == true || mIsPremium == true) {
                hasBuy = true;
                detailViewModel.showAdView.set(false);
                Log.d(TAG, "hasBuy=" + hasBuy);
            }
            detailViewModel.setHashBuy(hasBuy);


            Log.d(TAG, "mIsPremium is " + (mIsPremium ? "true" : "false"));
            Log.d(TAG, "mIs50 is " + (mIs50 ? "true" : "false"));
            Log.d(TAG, "mIs100 is " + (mIs100 ? "true" : "false"));
            Log.d(TAG, "mIsall is " + (mIsall ? "true" : "false"));
            // update UI accordingly


            Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
        // very important:
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }

        Log.d(TAG, "Destroying helper.");
        if (mHelper != null) {
            mHelper.disposeWhenFinished();
            mHelper = null;
        }
    }


    void complain(String message) {
        Log.e("detail", "**** TrivialDrive Error: " + message);
        alert("Attention! " + message);
    }

    void alert(String message) {

        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setMessage(message);
        bld.setNeutralButton("OK", null);
        Log.d("detail", "Showing alert dialog: " + message);
        bld.create().show();

    }

    @Override
    public void receivedBroadcast() {
        // Received a broadcast notification that the inventory of items has changed
        Log.d(TAG, "Received broadcast notification. Querying inventory.");
        try {
            mHelper.queryInventoryAsync(mGotInventoryListener);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error querying inventory. Another async operation in progress.");
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        //Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
        //lauche purchase
        String payload = "";
        try {
            mHelper.launchPurchaseFlow(this,
                    SKU_PREMIUM, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    // Callback for when a purchase is finished
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            if (mHelper == null) return;
            if (result.isFailure()) {
                //complain("Error purchasing: " + result);
                //setWaitScreen(false);
                return;
            }

            Log.d(TAG, "Purchase successful.");

            if (purchase.getSku().equals(SKU_PREMIUM)) {
                // bought 1/4 tank of gas. So consume it.
                Log.d(TAG, "Purchase is SKU_PREMIUM.");
                mIsPremium = true;

                //setWaitScreen(true);
            } else if (purchase.getSku().equals(SKU_50)) {
                // bought 1/4 tank of gas. So consume it.
                Log.d(TAG, "Purchase 50 is SKU_50.");
                mIs50 = true;
                //setWaitScreen(true);
            } else if (purchase.getSku().equals(SKU_100)) {
                // bought 1/4 tank of gas. So consume it.
                Log.d(TAG, "Purchase is SKU_100.");
                mIs100 = true;
                //setWaitScreen(true);
            } else if (purchase.getSku().equals(SKU_all)) {
                // bought 1/4 tank of gas. So consume it.
                Log.d(TAG, "Purchase is SKU_all.");
                mIsall = true;
                //setWaitScreen(true);
            }

            if (mIs50 == true || mIs100 == true || mIsall == true || mIsPremium == true) {
                hasBuy = true;
                detailViewModel.showAdView.set(false);
                Log.d(TAG, "hasBuy=" + hasBuy);
            }
            detailViewModel.setHashBuy(hasBuy);
        }
    };


    @Override
    protected void onPause() {
        // adView.pause();
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        detailViewModel.mpPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onBackPressed() {
        detailViewModel.mpBack();
        super.onBackPressed();
        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        } else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }
}
