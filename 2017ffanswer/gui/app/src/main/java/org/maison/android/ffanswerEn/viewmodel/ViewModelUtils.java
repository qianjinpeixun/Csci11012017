package org.maison.android.ffanswerEn.viewmodel;

import android.content.Context;
import android.util.Log;

/**
 * Created by Danxun.Jiao on 05/01/2017.
 */

public class ViewModelUtils {
    private static String TAG="ViewModelUtils";
    public static boolean mp3IsInAsset1(int currentNo) {
        boolean ret = false;
        if (currentNo == 1489 || currentNo == 1491 || currentNo == 1493 || currentNo == 1494 ||
                currentNo == 1495 || currentNo == 1496 || currentNo == 1497 || currentNo == 1498)
            ret = true;
        else
            ret = false;
        return ret;
    }

    public static boolean urlIsInAsset1(String url){
        boolean ret=false;
        Log.d(TAG,"url="+url);
        if(url.contains("1489")||url.contains("1491")||url.contains("1493")||url.contains("1494")||url.contains("1495")||url.contains("1496")||url.contains("1497")||url.contains("1498"))
            ret=true;
        else ret=false;
        return ret;
    }

    public static boolean isMp3Exist(String url, Context context) {
        boolean ret = false;
        if (url.contains("1489") || url.contains("1491") || url.contains("1493") || url.contains
                ("1494") || url.contains("1495") || url.contains("1496") || url.contains("1497")
                || url.contains("1498"))
            ret = true;
        else
            ret = false;
        String[] files = context.fileList();
        for (String ff : files) {
            Log.d(TAG, ff);
            if (ff.contains("audio")) {
                String number = ff.substring(5, 9);
                Log.d(TAG, "number=" + number);
                if (url.contains(number))
                    ret = true;
            }
        }
        return ret;
    }
}
