package com.thachnn.samplegallery.ui.media.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thachnn.samplegallery.R;
import com.thachnn.samplegallery.di.image.CustomImageSize;
import com.thachnn.samplegallery.di.image.ImageManagerService;
import com.thachnn.samplegallery.model.MediaItem;

import java.io.File;
import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {

    private List<MediaItem> items;

    private ImageManagerService imageManagerService;

    private OnMediaItemClick onMediaItemClick;

    public MediaAdapter(ImageManagerService imageManagerService) {
        this.imageManagerService = imageManagerService;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<MediaItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnMediaItemClick(OnMediaItemClick onMediaItemClick) {
        this.onMediaItemClick = onMediaItemClick;
    }

    @NonNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media, parent, false);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaViewHolder holder, int position) {
        MediaItem item = items.get(position);
        imageManagerService.load(new File(item.getPath()), holder.ivMediaThumb, CustomImageSize.mdpi);
        if (item.getType().equals(MediaItem.TYPE_VIDEO)) {
            holder.ivViewType.setVisibility(View.VISIBLE);
        } else {
            holder.ivViewType.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMediaItemClick != null) {
                    onMediaItemClick.oClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    static class MediaViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMediaThumb;
        View ivViewType;

        MediaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMediaThumb = itemView.findViewById(R.id.ivMediaThumb);
            ivViewType = itemView.findViewById(R.id.ivVideoType);
        }
    }
}