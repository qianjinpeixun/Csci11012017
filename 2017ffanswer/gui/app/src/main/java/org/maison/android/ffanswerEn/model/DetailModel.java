package org.maison.android.ffanswerEn.model;

import android.databinding.ObservableField;

import org.maison.android.ffanswerEn.viewmodel.ViewModelUtils;

/**
 * Created by Danxun.Jiao on 03/01/2017.
 */

public class DetailModel {

    private String audioUrl;
    private String questionUrl;
    private String answerUrl;
    private String textUrl;
    private int currentNo;
    private boolean mp3InAsset;

    public DetailModel(int no){
        this.currentNo=no;
        if(ViewModelUtils.mp3IsInAsset1(no)==true) {
            this.mp3InAsset=true;
            this.audioUrl = "audio/" + no + "audio.mp3";
        }
        else {
            this.audioUrl = "audio" + no + ".mp3";
            this.mp3InAsset=false;
        }
        this.questionUrl="file:///android_asset/faitdujour/"+no+"gquestions.html";
        this.answerUrl="file:///android_asset/faitdujour/"+no+"ganswers.html";;
        this.textUrl="file:///android_asset/faitdujour/"+no+"script.html";
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }

    public String getTextUrl() {
        return textUrl;
    }

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    @Override
    public String toString() {
        return "DetailModel{" +
                "audioUrl='" + audioUrl + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
                ", answerUrl='" + answerUrl + '\'' +
                ", textUrl='" + textUrl + '\'' +
                ", currentNo=" + currentNo +
                ", mp3InAsset=" + mp3InAsset +
                '}';
    }

    public void setCurrentNo(int currentNo) {
        this.currentNo = currentNo;
    }

    public boolean isMp3InAsset() {
        return mp3InAsset;
    }

    public void setMp3InAsset(boolean mp3InAsset) {
        this.mp3InAsset = mp3InAsset;
    }
}
