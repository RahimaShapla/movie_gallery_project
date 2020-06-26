package com.pro.movie.ui.app.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.pro.movie.R;
import com.pro.movie.data.remote.MovieModel;
import com.pro.movie.databinding.ActivityDashboardBinding;
import com.pro.movie.ui.app.moviedetails.MovieDetailActivity;
import com.pro.movie.ui.base.component.BaseActivity;
import com.pro.movie.utils.libs.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DashBoardActivity extends BaseActivity<DashBoardMvpView, DashBoardPresenter>
        implements MovieItemClickListener, DashBoardMvpView {
    private ActivityDashboardBinding mBinding;
    private DashBoardMovieAdapter mAdapter;

    public static void runActivity(Activity mActivity) {
        Intent intent = new Intent(mActivity, DashBoardActivity.class);
        mActivity.startActivity(intent);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard;
    }

    @NotNull
    @Override
    protected DashBoardPresenter getActivityPresenter() {
        return new DashBoardPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (ActivityDashboardBinding) getViewDataBinding();
        initView();

    }

    private void initView() {
        mAdapter = new DashBoardMovieAdapter();
        mAdapter.setClickListener(this);
        mBinding.recyclerViewMovie.setLayoutManager(new GridLayoutManager(this, 2));
        mBinding.recyclerViewMovie.setAdapter(mAdapter);
        presenter.getMovieList(this);
    }


    @Override
    protected void stopUI() {

    }

    @Override
    public void itemClickListener(View view, int position, MovieModel movieModel) {
        MovieDetailActivity.runActivity(this, movieModel.id);
    }

    @Override
    public void onSuccess(List<MovieModel> modelList) {
        if(!modelList.isEmpty()){
            mAdapter.addItems(modelList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String errorMessage) {
        ToastUtils.INSTANCE.error(errorMessage);
    }
}
