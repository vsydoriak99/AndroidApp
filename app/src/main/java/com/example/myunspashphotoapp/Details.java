package com.example.myunspashphotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {


    // TODO: Rename and change types of parameters
    private String mdecs ;
    private String mimg;
    private String mLikes;
    private String mDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
            mdecs =getIntent().getStringExtra("ARG_DESC");
            mimg =getIntent().getStringExtra("ARG_URL");

        mLikes =getIntent().getStringExtra("ARG_LIKES");
        mDate =getIntent().getStringExtra("ARG_DATE");

        setData();

    }

    private void setData() {

        TextView decr = (TextView)findViewById(R.id.img_desc);

        ImageView iv = (ImageView)findViewById(R.id.img_img);

        TextView img_likes = (TextView)findViewById(R.id.img_likes);
        TextView img_date = (TextView)findViewById(R.id.img_date);


        Picasso.get().load(mimg).into(iv);
        decr.setText(mdecs);
        img_likes.setText(mLikes);
        img_date.setText(mDate);

    }


}