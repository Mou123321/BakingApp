package com.mou.bakingapp.views.fragments;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.mou.bakingapp.R;
import com.mou.bakingapp.data.models.StepModel;
import com.mou.bakingapp.databinding.FragmentStepDetailBinding;


public class StepDetailFragment extends Fragment{

    private FragmentStepDetailBinding binding;

    private SimpleExoPlayer mExoPlayer;

    private String uri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.bind(inflater.inflate(R.layout.fragment_step_detail, container, false));

        StepModel stepModel = getArguments().getParcelable("step");

        uri = stepModel.getVideoURL();

        if (uri != null && !uri.isEmpty()) {
            initializePlayer(Uri.parse(uri));
        }

        return binding.getRoot();
    }


    private void initializePlayer(Uri mediaUri) {
        if (mExoPlayer == null) {
            // Create an instance of the ExoPlayer.
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            mExoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector, loadControl);
            binding.player.setPlayer(mExoPlayer);
            // Prepare the MediaSource.
            String userAgent = Util.getUserAgent(getContext(), "BakingApp");
            MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(getContext(), userAgent), new DefaultExtractorsFactory(), null, null);
            mExoPlayer.prepare(mediaSource);
            mExoPlayer.setPlayWhenReady(true);
        }
    }

    private void releasePlayer() {
        if (mExoPlayer != null) {
            mExoPlayer.stop();
            mExoPlayer.release();
            mExoPlayer = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (uri != null && !uri.isEmpty()) {
            initializePlayer(Uri.parse(uri));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        releasePlayer();
    }
}
