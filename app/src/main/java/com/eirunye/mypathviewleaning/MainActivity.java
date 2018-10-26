package com.eirunye.mypathviewleaning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
//        MyPathView1 myPathView = new MyPathView1(this);
//        frameLayout.addView(myPathView);
        MyQuadToView myQuadToView = new MyQuadToView(this);
        frameLayout.addView(myQuadToView);
    }


}
