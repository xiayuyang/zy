package com.example.administrator.zy.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.zy.R;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class TiwenActivity extends AppCompatActivity {
    Button finish ;
    Button cancel;
    EditText editText1;
    EditText editText2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiwen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.tiwenpicture);
        finish = (Button) findViewById(R.id.finish);
        cancel = (Button) findViewById(R.id.cancel);
        editText1 = (EditText) findViewById(R.id.biaoti);
        editText2 = (EditText) findViewById(R.id.zhengwen);
        final String title = editText1.getText().toString();
        final String description = editText2.getText().toString();
        //Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        //final String string = convertIconToString(bitmap);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title",title);
                intent.putExtra("description",description);
                //intent.putExtra("image",string);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static String convertIconToString(Bitmap bitmap) {
        if (bitmap == null)
            return "";
        else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();// outputstream
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            final byte[] appicon = baos.toByteArray();// 转为byte数组

            String string = null;
            try {
                string = new String(appicon, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return string;


        }
    }

}
