package com.pro.movie.ui.app.moviedetails;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.pro.movie.ui.base.component.BasePresenter;
import com.pro.movie.ui.base.helper.ProgressDialogUtils;
import com.pro.movie.utils.retrofit.NetworkUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailPresenter extends BasePresenter<MovieDetailMvpView> {
    AlertDialog dialog ;
    public void getDetails(Context context, int id) {
        dialog = ProgressDialogUtils.Companion.on()
                .showProgressDialog(context);
        getCompositeDisposable().add(NetworkUtil.getMovieDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(detailModel -> {
                   /* if (dialog != null)
                        dialog.dismiss();*/
                    if (detailModel == null) {
                        getMvpView().onError("Movie details is empty");
                    } else {
                        getMvpView().onSuccess(detailModel);
                    }
                }, throwable -> {
                   /* if (dialog != null)
                        dialog.dismiss();*/
                    getMvpView().onError(throwable.getMessage());
                }));
    }

    public String getYear(String serverDate) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date yourDate = parser.parse(serverDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yourDate);
            return "" + calendar.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void getTrailerList( int id) {
        getCompositeDisposable().add(NetworkUtil.getTrailerList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trailerListResponse -> {
                    if (dialog != null)
                        dialog.dismiss();
                    if (trailerListResponse == null) {
                        getMvpView().onError("No trailer found");
                    } else {
                        if (!trailerListResponse.trailerList.isEmpty())
                            getMvpView().onTrailerSuccess(trailerListResponse.trailerList);
                        else getMvpView().onError("No trailer found");
                    }
                }, throwable -> {
                    if (dialog != null)
                        dialog.dismiss();
                    getMvpView().onError(throwable.getMessage());
                }));
    }

}
