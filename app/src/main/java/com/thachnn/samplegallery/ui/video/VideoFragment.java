package com.thachnn.samplegallery.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thachnn.samplegallery.R;

public class VideoFragment extends Fragment {

    VideoView vvVideoPlayer;
    String pathOfVideo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        assert getArguments() != null;
        pathOfVideo = getArguments().getString("video");
        vvVideoPlayer = view.findViewById(R.id.vvVideoPlayer);
        view.setOnClickListener(v -> requireActivity().onBackPressed());
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (pathOfVideo != null) {
            vvVideoPlayer.setVideoPath(pathOfVideo);
        }
        vvVideoPlayer.start();
    }
}