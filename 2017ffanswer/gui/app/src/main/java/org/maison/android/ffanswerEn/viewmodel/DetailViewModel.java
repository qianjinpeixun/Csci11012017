package org.maison.android.ffanswerEn.viewmodel;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.maison.android.ffanswerEn.events.MessageEvent;
import org.maison.android.ffanswerEn.gui.R;
import org.maison.android.ffanswerEn.model.DetailModel;

import java.io.File;
import java.io.IOException;

/**
 * Created by Danxun.Jiao on 03/01/2017.
 */

public class DetailViewModel {

    private MediaPlayer mp;
    private boolean hasBuy;
    //private String currentMp3Path;
    private int currentNo;
    private boolean isPlaying;
    private final String TAG="DetailViewModel";
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<Boolean> showAdView = new ObservableField<>();

    public final ObservableField<String> textPlay = new ObservableField<>();
    private DetailModel detailModel;
    private Context mContext;

    public void setHashBuy(boolean hasBuy){
        this.hasBuy=hasBuy;
    }
    @BindingAdapter("loadUrl")
    public static void setUrl(WebView webView, String url) {
        if (url == null) {
            //webView.setImageDrawable(null);
        } else {
            webView.loadUrl(url);

        }

    }



    public DetailViewModel(int currentNo,Context context){
        this.mContext=context;
        this.showAdView.set(true);
        this.hasBuy=false;
        this.currentNo=currentNo;
        this.textPlay.set(mContext.getString(R.string.detail_play));
        this.detailModel=new DetailModel(currentNo);
        this.url.set(detailModel.getQuestionUrl());
        this.isPlaying=false;
        this.mp = new MediaPlayer();
        try {

            if (detailModel.isMp3InAsset() == true) {
                AssetFileDescriptor descriptor=null;
                String currentMp3Path="audio" + File.separator + currentNo  + "audio.mp3";
                descriptor = context.getAssets().openFd(currentMp3Path);
                mp.setDataSource(descriptor.getFileDescriptor(),
                        descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
            } else {
               String fileName =context.getFilesDir().getAbsolutePath()+ "/audio" + currentNo + ".mp3";
               mp.setDataSource(fileName);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void  clickBack(View view){
        Log.d(TAG,"clickPlay,currentNo="+currentNo);
        if (mp != null) {
            int currentPosition = mp.getCurrentPosition();
            int newPosition=currentPosition - (5*1000);
            if(newPosition<0) newPosition=0;
            mp.seekTo(newPosition);

        }
    }

    public void clickPlay(View view){
        Log.d(TAG,"clickPlay,currentNo="+currentNo);
        try {
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer arg0) {
                    textPlay.set(mContext.getString(R.string.detail_play));
                    isPlaying= false;
                    try {
                        mp.reset();
                        if (detailModel.isMp3InAsset() == true) {
                            AssetFileDescriptor descriptor=null;
                            String currentMp3Path="audio" + File.separator + currentNo  + "audio.mp3";
                            descriptor = mContext.getAssets().openFd(currentMp3Path);
                            mp.setDataSource(descriptor.getFileDescriptor(),
                                    descriptor.getStartOffset(), descriptor.getLength());
                            descriptor.close();
                        } else {
                            String fileName =mContext.getFilesDir().getAbsolutePath()+ "/audio" + currentNo + ".mp3";
                            mp.setDataSource(fileName);
                        }
                        Log.d("detail",
                                "onCompletion ffanswerPath is :");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.v("Tag", "Completed");
                }
            });

            if (isPlaying == false) {
                textPlay.set(mContext.getString(R.string.detail_pause));

                //AssetFileDescriptor descriptor = mContext.getAssets().openFd(file);
                //mp.setDataSource(descriptor.getFileDescriptor(),
                //        descriptor.getStartOffset(), descriptor.getLength());
                mp.prepare();
                mp.start();

                isPlaying = true;
            } else {
                textPlay.set(mContext.getString(R.string.detail_play));
                mp.stop();
                isPlaying = false;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void clickNext(View view){
        Log.d(TAG,"clickNext");
        url.set(detailModel.getQuestionUrl());
    }
    public void clickAnswer(View view){
        Log.d(TAG,"clickAnswer");

        if(detailModel.isMp3InAsset()) {
            hasBuy=true;
        }
        if(hasBuy==true) {
            url.set(detailModel.getAnswerUrl());
        }else
        EventBus.getDefault().post(new MessageEvent("Hello everyone!"));
    }

    public void clickText(View view){
        Log.d(TAG,"clickText");
        if(detailModel.isMp3InAsset()) {
            hasBuy=true;
        }
        if(hasBuy==true) {
            url.set(detailModel.getTextUrl());
        }else{
            EventBus.getDefault().post(new MessageEvent("Hello everyone!"));

        }

    }


    public void mpPause(){
        if (mp != null && mp.isPlaying()) {
            mp.stop();
        }
    }

    public void mpBack(){
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
}
