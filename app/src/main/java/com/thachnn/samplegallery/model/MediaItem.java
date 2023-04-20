package com.thachnn.samplegallery.model;


import android.util.Log;

public class MediaItem {
    private final String id;
    private final String path;
    private final String type;
    public static String TYPE_VIDEO = "video";
    public static String TYPE_IMG = "image";
    public MediaItem(String id, String path, String type) {
        this.id = id;
        this.path = path;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }
}