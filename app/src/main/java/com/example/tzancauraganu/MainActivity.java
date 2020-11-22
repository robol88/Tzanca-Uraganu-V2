package com.example.tzancauraganu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.malagie);
        mp.setVolume(2f, 2f);
        Button btn = (Button) findViewById(R.id.button);

        playOrPause();
        playOrPause();
    }

    void playOrPause() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.malagie);
        mp.setVolume(2f, 2f);
        Button btn = (Button) findViewById(R.id.button);

        if (!mp.isPlaying()) {
            btn.setText("Play");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mp.isPlaying()) {
                        mp.start();
                        btn.setText("Pause");
                        if (mp.isPlaying()) {
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (mp.isPlaying()) {
                                        mp.pause();
                                        btn.setText("Play");
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }
}