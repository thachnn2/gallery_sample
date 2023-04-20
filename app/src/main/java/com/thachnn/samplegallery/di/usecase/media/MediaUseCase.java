package com.thachnn.samplegallery.di.usecase.media;

import android.content.Context;

import com.thachnn.samplegallery.di.DaggerAppProvider;
import com.thachnn.samplegallery.di.repository.media.MediaRepository;
import com.thachnn.samplegallery.model.MediaItem;

import java.util.List;

import javax.inject.Inject;

public abstract class MediaUseCase {
    @Inject
    MediaRepository repository;

    public MediaUseCase() {
        DaggerAppProvider.builder().build().inject(this);
    }

    public abstract List<MediaItem> getAllMedia(Context context);
}
