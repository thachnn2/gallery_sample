package com.thachnn.samplegallery.di.image;

import android.widget.ImageView;

import java.io.File;

public abstract class ImageManagerService {

    abstract public void load(File file, ImageView imageView, CustomImageSize size);

    abstract public int getSize(CustomImageSize size);

}
