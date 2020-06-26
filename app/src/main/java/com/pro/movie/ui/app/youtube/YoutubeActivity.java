package com.pro.movie.ui.app.youtube;

import android.app.Activity;
import android.content.Intent;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.pro.movie.R;
import com.pro.movie.databinding.ActivityPlayerBinding;
import com.pro.movie.ui.base.component.BaseActivity;
import com.pro.movie.utils.helper.Constants;

import org.jetbrains.annotations.NotNull;

public class YoutubeActivity extends BaseActivity<YoutubeMvpPlayer, YouTubePresenter>
        implements YouTubePlayer.OnInitializedListener {
    String videoKey = "";

    public static void runActivity(Activity mActivity, String key) {
        Intent intent = new Intent(mActivity, YoutubeActivity.class);
        intent.putExtra(Constants.IntentKey.VIDEO_KEY, key);
        mActivity.startActivity(intent);
    }

    private ActivityPlayerBinding mBinding;
    YouTubePlayerFragment playerFragment;
    private YouTubePlayer mPlayer;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_player;
    }

    @NotNull
    @Override
    protected YouTubePresenter getActivityPresenter() {
        return new YouTubePresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (ActivityPlayerBinding) getViewDataBinding();
        setSupportActionBar(mBinding.toolbar1.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.toolbar1.toolbar.setTitle("Trailer");
        if (getIntent() != null)
            videoKey = getIntent().getStringExtra(Constants.IntentKey.VIDEO_KEY);
        playerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.youtube_player);
        if(playerFragment != null)
        playerFragment.initialize("AIzaSyBUSAS7pnlH8hb8tHJWiUB5b8wMxRSv1jY", this);


    }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean b) {
        mPlayer = youTubePlayer;
        if(mPlayer != null){
            mPlayer.loadVideo( videoKey);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

    }
}
