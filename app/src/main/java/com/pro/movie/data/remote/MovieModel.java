package com.pro.movie.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pro.movie.utils.helper.Constants;

public class MovieModel {
    @SerializedName(Constants.JsonKey.POPULARITY)
    @Expose
    public double popularity;

    @SerializedName(Constants.JsonKey.VOTE_COUNT)
    @Expose
    public int voteCount;

    @SerializedName(Constants.JsonKey.POSTER_PATH)
    @Expose
    public String posterUrl;

    @SerializedName(Constants.JsonKey.ID)
    @Expose
    public int id;

    @SerializedName(Constants.JsonKey.ORIGINAL_TITLE)
    @Expose
    public String title;

    @SerializedName(Constants.JsonKey.VOTE_AVG)
    @Expose
    public double voteAvg;

    @SerializedName(Constants.JsonKey.OVERVIEW)
    @Expose
    public String overview;

    @SerializedName(Constants.JsonKey.RELEASE_DATE)
    @Expose
    public String releaseDate;

 /*   @SerializedName(Constants.JsonKey.RUNTIME)
    @Expose
    public String runtime;*/
}
