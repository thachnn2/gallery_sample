package com.thachnn.samplegallery.di.usecase.media;

import android.content.Context;

import com.thachnn.samplegallery.di.DaggerAppProvider;
import com.thachnn.samplegallery.di.repository.media.MediaRepository;
import com.thachnn.samplegallery.model.MediaItem;

import java.util.List;

import javax.inject.Inject;

public class MediaUseCaseImpl extends MediaUseCase {

    public MediaUseCaseImpl() {
        super();
    }

    @Override
    public List<MediaItem> getAllMedia(Context context) {
        return repository.getAllMedia(context);
    }
}
