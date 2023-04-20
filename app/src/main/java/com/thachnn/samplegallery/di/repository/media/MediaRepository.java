package com.thachnn.samplegallery.di.repository.media;

import android.content.Context;

import com.thachnn.samplegallery.model.MediaItem;

import java.util.List;

public abstract class MediaRepository {
    public abstract List<MediaItem> getAllMedia(Context context);
}
