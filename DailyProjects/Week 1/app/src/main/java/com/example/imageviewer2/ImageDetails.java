package com.example.imageviewer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        ImageView getImage = findViewById(R.id.viewImage);

        Intent showImage = getIntent();

        ImageData imageData = (ImageData) showImage.getSerializableExtra("imageData");

        getImage.setImageURI(imageData.getImageData());



    }
}
