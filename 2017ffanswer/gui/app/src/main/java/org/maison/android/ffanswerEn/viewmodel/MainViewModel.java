package org.maison.android.ffanswerEn.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.annotations.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.maison.android.ffanswerEn.gui.DetailActivity;
import org.maison.android.ffanswerEn.model.MainModel;

import java.io.File;

/**
 * Created by Danxun.Jiao on 03/01/2017.
 */

public class MainViewModel {

    private ImageView currentImageView;
    private String currentImageViewUrl;
    MainModel currentMainModel;
    private static final String TAG = "MainViewModel";
    public final ObservableField<String> text1 = new ObservableField<>();
    public final ObservableField<String> text2 = new ObservableField<>();
    public final ObservableField<String> text3 = new ObservableField<>();
    public final ObservableField<String> text4 = new ObservableField<>();
    public final ObservableField<String> text5 = new ObservableField<>();
    public final ObservableField<String> text6 = new ObservableField<>();

    public final ObservableField<String> url1 = new ObservableField<>();
    public final ObservableField<String> url2 = new ObservableField<>();
    public final ObservableField<String> url3 = new ObservableField<>();
    public final ObservableField<String> url4 = new ObservableField<>();
    public final ObservableField<String> url5 = new ObservableField<>();
    public final ObservableField<String> url6 = new ObservableField<>();

    private Context context;


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageDrawable(null);
        } else {
            ImageLoader imageLoader = ImageLoader.getInstance();
            if (ViewModelUtils.isMp3Exist(url, imageView.getContext()) == true) {
                imageLoader.displayImage(url, imageView);
            } else {
                if (url.contains("downloading")) {
                    imageLoader.displayImage(url, imageView);
                } else {
                    DisplayImageOptions options = new DisplayImageOptions.Builder().build();
                    imageLoader.displayImage(url, imageView, options, new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            try {

                                Bitmap bm1 = loadedImage;

                                Bitmap.Config config = bm1.getConfig();
                                if (config == null) {
                                    config = Bitmap.Config.ARGB_8888;
                                }

                                Bitmap newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
                                Canvas newCanvas = new Canvas(newBitmap);

                                final Paint paint = new Paint();
                                paint.setAlpha(130);

                                newCanvas.drawBitmap(bm1, 0, 0, paint);

                                String captionString = "Tape to download";
                                if (captionString != null) {

                                    Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                                    paintText.setColor(Color.BLACK);
                                    paintText.setTextSize(22);
                                    paintText.setStyle(Paint.Style.FILL);
                                    //paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);
                                    paintText.setTextAlign(Paint.Align.CENTER);
                                    Rect rectText = new Rect();
                                    paintText.getTextBounds(captionString, 0, captionString.length(), rectText);

                                    newCanvas.drawText(captionString,
                                            newCanvas.getWidth() / 2, newCanvas.getHeight() / 2 + Math.abs(rectText
                                                    .height()) / 2, paintText);
                                    ((ImageView) view).setImageBitmap(newBitmap);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        }

    }


    public MainViewModel(int mCurrentPage, Context context) {
        this.context = context;
        this.currentMainModel = new MainModel(mCurrentPage);
        changeToPage(mCurrentPage);
    }

    public void changeToPage(int mCurrentPage) {
        Log.d(TAG, "currentMainModel=" + currentMainModel);

        text1.set(currentMainModel.getTitle1());
        text2.set(currentMainModel.getTitle2());
        text3.set(currentMainModel.getTitle3());
        text4.set(currentMainModel.getTitle4());
        text5.set(currentMainModel.getTitle5());
        text6.set(currentMainModel.getTitle6());

        url1.set(currentMainModel.getUrl1());
        url2.set(currentMainModel.getUrl2());
        url3.set(currentMainModel.getUrl3());
        url4.set(currentMainModel.getUrl4());
        url5.set(currentMainModel.getUrl5());
        url6.set(currentMainModel.getUrl6());


    }

    private void downloadMp3(Context context, int currentNumber) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://ffansweren7.appspot.com");
        StorageReference pathReference = storageRef.child("ff/" + currentNumber + "audio.mp3");

        File localFile = null;
        try {
            localFile = new File(context.getFilesDir(), "audio" + currentNumber + ".mp3");
        } catch (Exception e) {
            e.printStackTrace();
        }

        pathReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
                Log.d("FileUtils", "download sucess!");
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(currentImageViewUrl, currentImageView);
                currentImageView.setAlpha(1f);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.d("FileUtils", "download failed!");
            }
        });
    }

    private void launchDeatail(int no) {
        Intent intent1 = new Intent();
        Bundle bundle1 = new Bundle();
        intent1.setClass(context, DetailActivity.class);
        bundle1.putString("currentNo", String.valueOf(no));
        intent1.putExtras(bundle1);
        context.startActivity(intent1);
    }

    public void clickImage1(View view) {
        Log.v(TAG, "clickImage1");
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl1();
        int detailNo = currentMainModel.getNo1();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url1.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            Log.v(TAG, "begin to launchDeatail");
            launchDeatail(detailNo);

        }
    }

    public void clickImage2(View view) {
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl2();
        int detailNo = currentMainModel.getNo2();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url2.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            launchDeatail(detailNo);
            Log.v("MainActivity", "iamge1Left click");
        }
    }

    public void clickImage3(View view) {
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl3();
        int detailNo = currentMainModel.getNo3();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url3.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            launchDeatail(detailNo);
            Log.v("MainActivity", "iamge1Left click");
        }
    }

    public void clickImage4(View view) {
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl4();
        int detailNo = currentMainModel.getNo4();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url4.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            launchDeatail(detailNo);
            Log.v("MainActivity", "iamge1Left click");
        }
    }

    public void clickImage5(View view) {
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl5();
        int detailNo = currentMainModel.getNo5();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url5.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            launchDeatail(detailNo);
            Log.v("MainActivity", "iamge1Left click");
        }
    }

    public void clickImage6(View view) {
        currentImageView = (ImageView) view;
        currentImageViewUrl = currentMainModel.getUrl6();
        int detailNo = currentMainModel.getNo6();
        boolean hasMp3 = ViewModelUtils.isMp3Exist(currentImageViewUrl, view.getContext());
        if (hasMp3 == false) {
            Log.d("", "begin download:" + "ff/" + detailNo + "audio.mp3");
            url6.set("assets://faitdujour/downloading.png");
            downloadMp3(view.getContext(), detailNo);
        } else {
            launchDeatail(detailNo);
            Log.v("MainActivity", "iamge1Left click");
        }
    }


}
