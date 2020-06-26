package com.pro.movie.ui.app.moviedetails;

import com.pro.movie.data.remote.DetailModel;
import com.pro.movie.data.remote.TrailerModel;
import com.pro.movie.ui.base.callback.MvpView;

import java.util.List;

public interface MovieDetailMvpView extends MvpView {
    void onSuccess(DetailModel detailModel);
    void onTrailerSuccess(List<TrailerModel> trailerModelList);
    void onError(String errorMessage);
}
