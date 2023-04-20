package com.thachnn.samplegallery.ui.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thachnn.samplegallery.R;
import com.thachnn.samplegallery.di.DaggerAppProvider;
import com.thachnn.samplegallery.di.image.CustomImageSize;
import com.thachnn.samplegallery.di.image.ImageManagerService;

import java.io.File;

import javax.inject.Inject;

public class PhotoFragment extends Fragment {
    ImageView ivImagePreview;
    String pathOfImage;
    @Inject
    ImageManagerService imageManagerService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerAppProvider.builder().build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        assert getArguments() != null;
        pathOfImage = getArguments().getString("image");
        ivImagePreview = view.findViewById(R.id.ivImagePreview);
        view.setOnClickListener(v -> requireActivity().onBackPressed());
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (pathOfImage != null) {
            imageManagerService.load(new File(pathOfImage), ivImagePreview, CustomImageSize.xxxhdpi);
        }

    }
}