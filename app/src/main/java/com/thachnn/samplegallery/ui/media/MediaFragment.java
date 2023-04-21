package com.thachnn.samplegallery.ui.media;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thachnn.samplegallery.R;
import com.thachnn.samplegallery.di.DaggerAppProvider;
import com.thachnn.samplegallery.di.image.ImageManagerService;
import com.thachnn.samplegallery.model.MediaItem;
import com.thachnn.samplegallery.ui.media.adapter.MediaAdapter;
import com.thachnn.samplegallery.ui.media.adapter.OnMediaItemClick;
import com.thachnn.samplegallery.ui.media.component.EmptyViewHolder;
import com.thachnn.samplegallery.ui.navigation.Navigation;
import com.thachnn.samplegallery.utils.permission.PermissionUtils;
import com.thachnn.samplegallery.viewmodel.MediaViewModel;
import com.thachnn.samplegallery.viewmodel.factory.MediaViewModelFactory;

import javax.inject.Inject;

public class MediaFragment extends Fragment implements OnMediaItemClick {
    private EmptyViewHolder emptyViewHolder;
    private MediaAdapter adapter;
    private ProgressBar progressBar;
    private MediaViewModel viewModel;
    @Inject
    ImageManagerService imageManagerService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerAppProvider.builder().build().inject(this);
        viewModel = new ViewModelProvider(this, new MediaViewModelFactory()).get(MediaViewModel.class);
        adapter = new MediaAdapter(imageManagerService);
        adapter.setOnMediaItemClick(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media, container, false);
        emptyViewHolder = new EmptyViewHolder(view);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        recyclerView.setAdapter(adapter);
        progressBar = view.findViewById(R.id.progressBar);
        viewModel.getMediaItemLiveData().observe(getViewLifecycleOwner(), mediaItems -> {
            if (mediaItems.isEmpty()) {
                emptyViewHolder.visible();
            } else {
                emptyViewHolder.gone();
            }
            adapter.setItems(mediaItems);
            progressBar.setVisibility(View.GONE);
        });
        checkPermission();
        return view;
    }

    void fetchData() {
        viewModel.reload(requireContext());
    }
    
    
    void checkPermission() {
        boolean granted = PermissionUtils.checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (granted) {
            fetchData();
        } else {
            PermissionUtils.requestPermission(this, (allGranted, grantedList, deniedList) -> {
                if (allGranted) {
                    fetchData();
                } else {
                    emptyViewHolder.visible();
                }
            }, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }


    @Override
    public void oClick(MediaItem item) {
        if (item.getType().equals(MediaItem.TYPE_VIDEO)) {
            Navigation.get().openVideoDetails(item.getPath());
        } else {
            Navigation.get().openImageDetails(item.getPath());
        }
    }
}