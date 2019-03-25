package com.example.imageviewer;

import android.net.Uri;

import java.io.Serializable;

 class ImageData implements Serializable  {

     private String uriInStringForm;
     private String  name;


     public ImageData(String name, String uri){
         this.name = name;
         this.uriInStringForm = uri;
     }



    public Uri getUri() {

        return Uri.parse(uriInStringForm);
    }

    public void setUri(Uri uri) {

        uriInStringForm = uri.toString();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

         this.name = name;
    }
}
