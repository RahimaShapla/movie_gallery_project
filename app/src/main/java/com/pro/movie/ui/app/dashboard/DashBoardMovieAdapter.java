package com.pro.movie.ui.app.dashboard;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.pro.movie.R;
import com.pro.movie.data.remote.MovieModel;
import com.pro.movie.databinding.ItemDashboardMovieBinding;
import com.pro.movie.ui.base.component.BaseAdapter;
import com.pro.movie.ui.base.component.BaseViewHolder;
import com.pro.movie.utils.libs.GlideUtils;

import org.jetbrains.annotations.NotNull;

public class DashBoardMovieAdapter extends BaseAdapter<MovieModel> {

    private MovieItemClickListener mItemClickListener;

    @Override
    public boolean isEqual(MovieModel left, MovieModel right) {
        return false;
    }

    @NotNull
    @Override
    public BaseViewHolder<MovieModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new DashBoardViewHolder(inflate(parent, R.layout.item_dashboard_movie));
    }


    public class DashBoardViewHolder extends BaseViewHolder<MovieModel> {
        ItemDashboardMovieBinding mBinding;

        public DashBoardViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mBinding = (ItemDashboardMovieBinding) viewDataBinding;
        }

        @Override
        public void bind(MovieModel item) {
            if(item != null) {
                GlideUtils.Companion.glideWithPlaceHolder(mBinding.imageViewMovie, item.posterUrl);
                mBinding.imageViewMovie.setOnClickListener(this::onClick);
            }
        }

        @Override
        public void onClick(@NotNull View view) {
            //super.onClick(view);
            mItemClickListener.itemClickListener( mBinding.imageViewMovie,
                    getAdapterPosition(), getItem(getAdapterPosition()));

        }
    }

    public void setClickListener(MovieItemClickListener listener) {
        this.mItemClickListener = listener;
    }
}
