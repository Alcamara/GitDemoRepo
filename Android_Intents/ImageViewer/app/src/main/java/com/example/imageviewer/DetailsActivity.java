package com.example.imageviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView getImage = findViewById(R.id.image_act);


        Intent intent =  getIntent();
        ImageData imageData = (ImageData) intent.getSerializableExtra("imageData");

        getImage.setImageURI(imageData.getUri());






    }



}
