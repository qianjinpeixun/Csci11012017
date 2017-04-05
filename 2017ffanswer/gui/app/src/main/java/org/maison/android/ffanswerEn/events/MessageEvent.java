package org.maison.android.ffanswerEn.events;

import android.util.Log;
import android.view.View;

import com.android.annotations.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import org.maison.android.ffanswerEn.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Danxun.Jiao on 30/12/2016.
 */

public class MessageEvent {

    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }

}
