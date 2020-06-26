package com.pro.movie.ui.app.dashboard;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.pro.movie.ui.base.component.BasePresenter;
import com.pro.movie.ui.base.helper.ProgressDialogUtils;
import com.pro.movie.utils.retrofit.NetworkUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DashBoardPresenter extends BasePresenter<DashBoardMvpView> {
    public void getMovieList(Context context) {
        AlertDialog dialog = ProgressDialogUtils.Companion.on().showProgressDialog(context);
        getCompositeDisposable().add(NetworkUtil.getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListResponse -> {
                    if (dialog != null)
                        dialog.dismiss();
                    if(movieListResponse!=null) {
                        if (movieListResponse.movieList.isEmpty()) {
                            getMvpView().onError("Movie list is empty");
                        } else {
                            getMvpView().onSuccess(movieListResponse.movieList);
                        }
                    }else getMvpView().onError("Movie list is empty");
                }, throwable -> {
                    if (dialog != null)
                        dialog.dismiss();
                    getMvpView().onError(throwable.getMessage());
                }));
    }
}
