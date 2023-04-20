package com.thachnn.samplegallery.di.repository.media;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.thachnn.samplegallery.model.MediaItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MediaRepositoryImpl extends MediaRepository {


    @Override
    public List<MediaItem> getAllMedia(Context context) {
        List<MediaItem> mediaItems = new ArrayList<>();

        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.DATA,
                MediaStore.Files.FileColumns.MEDIA_TYPE
        };

        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "=?"
                + " OR "
                + MediaStore.Files.FileColumns.MEDIA_TYPE + "=?";

        String[] selectionArgs = new String[]{
                String.valueOf(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE),
                String.valueOf(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO)
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Files.getContentUri("external"),
                projection,
                selection,
                selectionArgs,
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC"
        );

        if (cursor != null) {
            int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID);
            int pathColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            int typeColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MEDIA_TYPE);

            while (cursor.moveToNext()) {
                String id = cursor.getString(idColumn);
                String path = cursor.getString(pathColumn);
                String type = Objects.equals(cursor.getString(typeColumn), String.valueOf(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE))
                        ? "image" : "video";
                mediaItems.add(new MediaItem(id, path, type));
            }

            cursor.close();
        }
        Log.e("ThachNN2", "ALL PHOTOS "+ mediaItems.size());
        return mediaItems;
    }
}
