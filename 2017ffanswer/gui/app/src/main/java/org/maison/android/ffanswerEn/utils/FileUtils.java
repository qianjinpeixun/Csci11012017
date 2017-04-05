package org.maison.android.ffanswerEn.utils;

import android.content.Context;
import android.util.Log;

import com.android.annotations.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

/**
 * Created by Danxun.Jiao on 30/12/2016.
 */

public class FileUtils {
    public static void downloadFile(Context context, int fileNumber){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://ffansweren7.appspot.com");
        StorageReference pathReference = storageRef.child("ff/"+fileNumber+"audio.mp3");

        File localFile = null;
        try {
            localFile =  new File(context.getFilesDir(), fileNumber+"audio.mp3");
        } catch (Exception e) {
            e.printStackTrace();
        }

        pathReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
                Log.d("FileUtils","download sucess!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.d("FileUtils","download failed!");
            }
        });
    }


    public static boolean hasDownloaded(Context context, int fileNumber){
        boolean ret=false;
        File localFile = null;
        try {
            localFile =  new File(context.getFilesDir(), fileNumber+"audio.mp3");
            if(localFile.exists())
                ret=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }


}
