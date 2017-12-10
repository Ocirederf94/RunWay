package com.mygdx.game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    public void handlePlayButton(View view) {
        Intent intent = new Intent(this, AndroidLauncher.class);
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }
}
