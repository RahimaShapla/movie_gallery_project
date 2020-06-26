package com.pro.movie.ui.app.moviedetails;

import android.app.Activity;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.pro.movie.R;
import com.pro.movie.data.remote.DetailModel;
import com.pro.movie.data.remote.TrailerModel;
import com.pro.movie.databinding.ActivityMovieDetailsBinding;
import com.pro.movie.ui.app.youtube.YoutubeActivity;
import com.pro.movie.ui.base.component.BaseActivity;
import com.pro.movie.utils.helper.Constants;
import com.pro.movie.utils.libs.GlideUtils;
import com.pro.movie.utils.libs.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MovieDetailActivity extends BaseActivity<MovieDetailMvpView, MovieDetailPresenter>
        implements MovieDetailMvpView, TrailerClickListener {
    private ActivityMovieDetailsBinding mBinding;
    private TrailerAdapter mAdapter;
    private int movieID = -1;

    public static void runActivity(Activity mActivity, int id) {
        Intent intent = new Intent(mActivity, MovieDetailActivity.class);
        intent.putExtra(Constants.IntentKey.MOVIE_ID, id);
        mActivity.startActivity(intent);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_movie_details;
    }

    @NotNull
    @Override
    protected MovieDetailPresenter getActivityPresenter() {
        return new MovieDetailPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (ActivityMovieDetailsBinding) getViewDataBinding();
        setSupportActionBar(mBinding.toolbar1.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.toolbar1.toolbar.setTitle("MovieDetail");
        getData();
    }

    private void getData() {
        if (getIntent() != null)
            movieID = getIntent().getIntExtra(Constants.IntentKey.MOVIE_ID,
                    Constants.Default.DEFAULT_INTEGER);
        mAdapter = new TrailerAdapter();
        mBinding.recyclerViewDetails.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerViewDetails.setAdapter(mAdapter);
        mAdapter.setmListener(this);
        if (movieID != -1) {
            presenter.getDetails(this, movieID);
            presenter.getTrailerList(movieID);
        } else ToastUtils.INSTANCE.error(getString(R.string.something_went_wrong));
    }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onSuccess(DetailModel detailModel) {
        updateUI(detailModel);
    }

    @Override
    public void onTrailerSuccess(List<TrailerModel> trailerModelList) {
        if (!trailerModelList.isEmpty()) {
            mAdapter.addItems(trailerModelList);
            mAdapter.notifyDataSetChanged();
        }
    }

    private void updateUI(DetailModel detailModel) {
        if (detailModel != null) {
            GlideUtils.Companion.glideWithPlaceHolder
                    (mBinding.imageViewMovie, detailModel.posterUrl);
            mBinding.textViewBigTitle.setText(detailModel.title);
            mBinding.textViewYear.setText(presenter.getYear(detailModel.releaseDate));
            mBinding.textViewMin.setText(detailModel.runtime + "min");
            mBinding.textViewRate.setText(detailModel.voteAvg + "/10");
            mBinding.textViewDescription.setText(detailModel.overview);
        }
    }


    @Override
    public void onError(String errorMessage) {
        ToastUtils.INSTANCE.error(errorMessage);
    }

    @Override
    public void onTrailerClick(String key) {
        if (!key.isEmpty()) {
            YoutubeActivity.runActivity(MovieDetailActivity.this, key);
        }
    }

}
