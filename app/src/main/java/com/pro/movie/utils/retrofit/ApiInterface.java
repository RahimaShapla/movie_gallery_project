package com.pro.movie.utils.retrofit;

import com.pro.movie.data.remote.DetailModel;
import com.pro.movie.data.response.MovieListResponse;
import com.pro.movie.data.response.TrailerListResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("popular?api_key=78b9f63937763a206bff26c070b94158")
    Flowable<MovieListResponse> getMovieList();

    @GET("{id}?api_key=78b9f63937763a206bff26c070b94158")
    Flowable<DetailModel> getMovieDetails(@Path("id") String id);

    @GET("{id}/videos?api_key=78b9f63937763a206bff26c070b94158")
    Flowable<TrailerListResponse> getTrailerList(@Path("id") String id);
}
