package com.pro.movie.ui.app.dashboard;

import android.view.View;

import com.pro.movie.data.remote.MovieModel;

public interface MovieItemClickListener {
    void itemClickListener(View view, int position, MovieModel movieModel);
}
