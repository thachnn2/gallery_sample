package com.thachnn.samplegallery.di;

import com.thachnn.samplegallery.di.repository.RepositoryModule;
import com.thachnn.samplegallery.ui.media.MediaFragment;
import com.thachnn.samplegallery.ui.photo.PhotoFragment;
import com.thachnn.samplegallery.viewmodel.MediaViewModel;

import dagger.Component;


@Component(modules = {RepositoryModule.class})
public interface AppProvider {
    void inject(MediaViewModel viewModel);

    void inject(MediaFragment adapter);

    void inject(PhotoFragment photoFragment);
}





