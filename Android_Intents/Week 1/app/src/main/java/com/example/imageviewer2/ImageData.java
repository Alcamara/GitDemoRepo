package com.example.imageviewer2;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String imageData;
    private String name;

    public ImageData(String imageData, String name) {
        this.imageData = imageData;
        this.name = name;
    }




    public Uri getImageData() {
        return Uri.parse(imageData);
    }

    public void setImageData(String imageData) {
        this.imageData = imageData.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
