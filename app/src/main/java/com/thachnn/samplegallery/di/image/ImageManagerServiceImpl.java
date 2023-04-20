package com.thachnn.samplegallery.di.image;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

public class ImageManagerServiceImpl extends ImageManagerService {
    @Override
    public void load(File file, ImageView imageView, CustomImageSize size) {
        int targetSize = getSize(size);
        Glide.with(imageView).load(file).apply(new RequestOptions().override(targetSize)).centerCrop().into(imageView);
    }

    @Override
    public int getSize(CustomImageSize size) {
        switch (size) {
            case hdpi:
                return 300;
            case mdpi:
                return 200;
            case xxhdpi:
                return 400;
            case xxxhdpi:
                return 500;
            default:
                return  100;
        }
    }
}
