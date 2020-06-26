package com.pro.movie.ui.app.dashboard;

import com.pro.movie.data.remote.MovieModel;
import com.pro.movie.ui.base.callback.MvpView;

import java.util.List;

public interface DashBoardMvpView extends MvpView {
    void onSuccess(List<MovieModel> modelList);
    void onError(String errorMessage);
}
