package com.thachnn.samplegallery.ui.navigation;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.thachnn.samplegallery.ui.media.MediaFragment;
import com.thachnn.samplegallery.ui.photo.PhotoFragment;
import com.thachnn.samplegallery.ui.video.VideoFragment;

public class Navigation {
    private static Navigation instance;
    private FragmentManager fragmentManager;
    private int containerId;

    public static Navigation get() {
        if (instance == null) {
            throw new NullPointerException();
        }
        return instance;
    }

    public static Navigation init(FragmentManager fragmentManager, int containerId) {
        instance = new Navigation();
        instance.fragmentManager = fragmentManager;
        instance.containerId = containerId;
        return instance;
    }

    public void openMediaFragment() {
        MediaFragment mediaFragment = new MediaFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, mediaFragment)
                .commit();
    }

    public void openVideoDetails(String pathOfVideo) {
        VideoFragment videoFragment = new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("video", pathOfVideo);
        videoFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .add(containerId, videoFragment)
                .addToBackStack(null)
                .commit();
    }

    public void openImageDetails(String pathOfImage) {
        PhotoFragment photoFragment = new PhotoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("image", pathOfImage);
        photoFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .add(containerId, photoFragment)
                .addToBackStack(null)
                .commit();
    }
}