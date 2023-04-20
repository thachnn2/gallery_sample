package com.thachnn.samplegallery.di.repository;

import com.thachnn.samplegallery.di.image.ImageManagerService;
import com.thachnn.samplegallery.di.image.ImageManagerServiceImpl;
import com.thachnn.samplegallery.di.repository.media.MediaRepository;
import com.thachnn.samplegallery.di.repository.media.MediaRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public MediaRepository provideMediaRepository() {
        return new MediaRepositoryImpl();
    }

    @Provides
    public ImageManagerService provideImageManagerService() {
        return new ImageManagerServiceImpl();
    }

}
