package com.example.tzancauraganu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    public static int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.malagie);
        mp.setVolume(2f, 2f);
        Button btn = (Button) findViewById(R.id.button);

        if (!mp.isPlaying()) {
            playOrPause();
        }


    }

    void playOrPause() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.malagie);
        mp.setVolume(2f, 2f);
        Button btn = (Button) findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if(a == 2) { a = 0; }
                if (a==1) {
                    mp.start();
                    btn.setText("Pause");
                }
                if(a==0) {
                    mp.pause();
                    btn.setText("Play");
                }
            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                a = 0;
                btn.setText("Play");
            }
        });
    }
}