package com.example.paint;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.paint.views.MyPaintView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceType")
    public void imageView(View view) {
        int id = view.getId();
        ImageView imageView = findViewById(id);
        MyPaintView.setColor(Color.valueOf(imageView.getImageTintList().getDefaultColor()));
    }

}
