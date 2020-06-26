package com.pro.movie.utils.retrofit;


import android.content.Context;
import android.net.ConnectivityManager;

import com.pro.movie.BaseApplication;
import com.pro.movie.R;
import com.pro.movie.data.remote.DetailModel;
import com.pro.movie.data.response.MovieListResponse;
import com.pro.movie.data.response.TrailerListResponse;

import io.reactivex.Flowable;

public class NetworkUtil {
    private static String API_KEY = "78b9f63937763a206bff26c070b94158";
    private static  boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager)
               BaseApplication.Companion.getBaseApplicationContext()
                       .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static Flowable<MovieListResponse> getMovieList(){
        return Flowable.defer(() -> {
            if(!isNetworkConnected()){
                return  Flowable.error(new Throwable(BaseApplication.Companion.getBaseApplicationContext()
                        .getString(R.string.error_interent_connection)));
            }else {
                try {
                    return  RetrofitClient.getApiService().getMovieList();
                }catch (Exception e){
                   return Flowable.error(new Throwable(e.getMessage()));
                }
            }
        });
    }

    public static Flowable<DetailModel> getMovieDetails(int id){
        return Flowable.defer(() -> {
            if(!isNetworkConnected()){
                return  Flowable.error(new Throwable(BaseApplication.Companion.getBaseApplicationContext()
                        .getString(R.string.error_interent_connection)));
            }else {
                try {
                    return  RetrofitClient.getApiService().getMovieDetails(String.valueOf(id));
                }catch (Exception e){
                    return Flowable.error(new Throwable(e.getMessage()));
                }
            }
        });
    }

    public static Flowable<TrailerListResponse> getTrailerList(int id){
        return Flowable.defer(() -> {
            if(!isNetworkConnected()){
                return  Flowable.error(new Throwable(BaseApplication.Companion.getBaseApplicationContext()
                        .getString(R.string.error_interent_connection)));
            }else {
                try {
                    return  RetrofitClient.getApiService().getTrailerList(String.valueOf(id));
                }catch (Exception e){
                    return Flowable.error(new Throwable(e.getMessage()));
                }
            }
        });
    }
}
