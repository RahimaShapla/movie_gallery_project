package com.pro.movie.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pro.movie.utils.helper.Constants;

public class TrailerModel {
    @SerializedName(Constants.JsonKey.ID)
    @Expose
    public String id;

    @SerializedName(Constants.JsonKey.KEY)
    @Expose
    public String key;

    @SerializedName(Constants.JsonKey.NAME)
    @Expose
    public String name;

}
