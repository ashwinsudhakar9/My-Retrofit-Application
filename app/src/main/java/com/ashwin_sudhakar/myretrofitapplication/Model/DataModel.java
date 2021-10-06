package com.ashwin_sudhakar.myretrofitapplication.Model;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("id")
    private String mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    public DataModel(String mId, String mTitle, String mBody) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mBody = mBody;
    }


}
