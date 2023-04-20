package com.thachnn.samplegallery.di.usecase;

import com.thachnn.samplegallery.di.usecase.media.MediaUseCase;
import com.thachnn.samplegallery.di.usecase.media.MediaUseCaseImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {
    @Provides
    public MediaUseCase provideMediaUseCase() {
        return new MediaUseCaseImpl();
    }
}
