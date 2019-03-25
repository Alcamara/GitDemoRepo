package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageData> myList = new ArrayList<>();
    private LinearLayout interLinearLayout;
    static final int REQUESTCODE_GETIMAGE = 0;
    private Button getPic;
    private Context main = this;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        interLinearLayout = findViewById(R.id.inter_linear_layout);
        //String getTextView = startIntent.getStringExtra();
        //textView.setText(getTextView);


        getPic = findViewById(R.id.button_get_image);
        getPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getImage = new Intent(Intent.ACTION_PICK);
                getImage.setType("image/*");
                getImage.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(getImage, REQUESTCODE_GETIMAGE);



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUESTCODE_GETIMAGE ){
            if(data != null) {
                Uri pictureUri = data.getData();
                ImageData imageData = new ImageData("name", pictureUri.toString());
                myList.add(imageData);
                createTextView(Integer.toString(myList.size()), myList.indexOf(imageData));
            }

        }


    }

//    <TextView
//    android:layout_gravity="center"
//    android:textSize="35dp"
//    android:text="test"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content" />

    public TextView createTextView(String viewText, final int index){

        final TextView text = new TextView(main);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text.setTag(myList);
                Intent intent = new Intent(main, DetailsActivity.class);
                //.putExtra sends data to next Activity
                ImageData imageData = myList.get(index);
                intent.putExtra("imageData",imageData);
                startActivity(intent);

            }
        });
        text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setText(viewText);
        text.setTextSize(35);
        text.setPadding(10,10,10,10);
        interLinearLayout.addView(text);
        return text;

    }


}
