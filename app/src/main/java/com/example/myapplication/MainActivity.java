package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    /*
    https://i.imgur.com/2bvab7y.jpeg
    https://i.imgur.com/Jvh1OQm.jpeg
    https://i.imgur.com/zt7smR4.jpeg
     */

    Button addImage;
    LinearLayout layout;

    String url;
    //String value = text.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImage = findViewById(R.id.addImage);
        layout = findViewById(R.id.layout);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = new ImageView( MainActivity.this);
                AddView(imageView, 800, 800);

            }
        });

    }

    public void AddView(ImageView imageView, int width, int height){

        EditText text = findViewById(R.id.editText);
        url = text.getText().toString();

        if(url.trim().equals("")){

            Toast.makeText(getApplicationContext(), " Invalid URL", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
            Picasso.with(this).load(url).into(imageView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
            layoutParams.setMargins(0,10,0,10);
            imageView.setBackgroundColor(0xFF014D87);
            imageView.setLayoutParams(layoutParams);
            layout.addView(imageView);

        }
    }

}