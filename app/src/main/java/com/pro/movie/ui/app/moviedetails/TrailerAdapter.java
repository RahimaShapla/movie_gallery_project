package com.pro.movie.ui.app.moviedetails;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.pro.movie.R;
import com.pro.movie.data.remote.TrailerModel;
import com.pro.movie.databinding.ItemMovieDetailsBinding;
import com.pro.movie.ui.base.component.BaseAdapter;
import com.pro.movie.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class TrailerAdapter extends BaseAdapter<TrailerModel> {
    TrailerClickListener mListener;

    @Override
    public boolean isEqual(TrailerModel left, TrailerModel right) {
        return false;
    }

    @NotNull
    @Override
    public BaseViewHolder<TrailerModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new TrailerViewHolder(inflate(parent, R.layout.item_movie_details));
    }

    public class TrailerViewHolder extends BaseViewHolder<TrailerModel> {
        ItemMovieDetailsBinding mBinding;
        String key = "";

        public TrailerViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mBinding = (ItemMovieDetailsBinding) viewDataBinding;
        }

        @Override
        public void bind(TrailerModel item) {
            if (item != null) {
                mBinding.textViewTrailerCount.setText(item.name);
                mBinding.parentLayout.setOnClickListener(this::onClick);
            }
        }

        @Override
        public void onClick(@NotNull View view) {
            super.onClick(view);
            if (getItem(getAdapterPosition()) != null)
                mListener.onTrailerClick(getItem(getAdapterPosition()).key);
        }
    }

    public void setmListener(TrailerClickListener listener) {
        this.mListener = listener;
    }
}
