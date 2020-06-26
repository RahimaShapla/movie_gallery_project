package com.pro.movie.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pro.movie.data.remote.TrailerModel;
import com.pro.movie.utils.helper.Constants;

import java.util.List;

public class TrailerListResponse {
    @SerializedName(Constants.JsonKey.RESULTS)
    @Expose
    public List<TrailerModel> trailerList;
}
