package com.thachnn.samplegallery.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thachnn.samplegallery.di.DaggerAppProvider;
import com.thachnn.samplegallery.di.usecase.media.MediaUseCase;
import com.thachnn.samplegallery.model.MediaItem;

import java.util.List;

import javax.inject.Inject;

public class MediaViewModel extends ViewModel {

    @Inject
    MediaUseCase mediaUseCase;
    private final MutableLiveData<List<MediaItem>> mediaItems;

    public MediaViewModel() {
        this.mediaItems = new MutableLiveData<>();
        DaggerAppProvider.builder().build().inject(this);
    }

    public LiveData<List<MediaItem>> getMediaItemLiveData() {
        return mediaItems;
    }

    public void reload(Context context) {
        this.mediaItems.setValue(this.mediaUseCase.getAllMedia(context));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
