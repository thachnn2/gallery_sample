package com.thachnn.samplegallery.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.thachnn.samplegallery.viewmodel.MediaViewModel;

public class MediaViewModelFactory implements ViewModelProvider.Factory {


    public MediaViewModelFactory() {

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MediaViewModel.class)) {
            return (T) new MediaViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
