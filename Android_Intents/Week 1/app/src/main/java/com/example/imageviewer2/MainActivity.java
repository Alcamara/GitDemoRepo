package com.example.imageviewer2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Picture;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int REQUESTCODE_GETIMAGE = 0;
   private Button addPicture;
   private LinearLayout interLinerLayout;
   private Context context = this;
   private ArrayList<ImageData> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPicture = findViewById(R.id.import_picture);
        interLinerLayout = findViewById(R.id.inter_linearlayout);

        addPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addpic = new Intent(Intent.ACTION_PICK);
                addpic.setType("image/*");
                addpic.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(addpic, REQUESTCODE_GETIMAGE);
            }
        });

       // fakeText();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if (requestCode == REQUESTCODE_GETIMAGE && resultCode == RESULT_OK){
           if (data != null){
               Uri pictureUri = data.getData();
               ImageData imageData = new ImageData("name",pictureUri.toString());
               imageList.add(imageData);
               generateTextView(Integer.toString(imageList.size()),imageList.indexOf(imageData));
           }

       }
    }

    TextView generateTextView(String image,final int element){
        TextView text = new TextView(context);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openList = new Intent(context, ImageDetails.class);
                ImageData imageData = imageList.get(element);
                openList.putExtra("imageData", imageData);
                startActivity(openList);

            }
        });

        text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setText(image);
        text.setTextSize(35);
        text.setPadding(12,12,12,12);
        interLinerLayout.addView(text);



        return text;
    }






}


