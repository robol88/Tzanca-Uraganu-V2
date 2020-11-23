# Tzanca-Uraganu-V2
**Hai din nou cu tzanca uraganu'!**

GitHub Repository pentru Țancă Uraganu'
Acest mesaj este pentru developeri.

Dacă dai push, managerul (unul dintre Hangani) trebuie să îți dea accept la noile schimbări (changes).
Limbajul de programare folosit este Java, dar ne putem adapta la schimbări dacă acestea sunt strict necesare.
Vă rugăm să publicați schimbările pe brachul potrivit (îl puteți întreba pe Darius aka. ProgrammerDog dacă nu știți care este cel potrivit pentru dumneavoastră)
Dacă nu ați intrat în Trello, vă rugăm să o faceți!

.gitignore (MAIN)

```java
*.iml
.gradle
/local.properties
/.idea/caches
/.idea/libraries
/.idea/modules.xml
/.idea/workspace.xml
/.idea/navEditor.xml
/.idea/assetWizardSettings.xml
.DS_Store
/build
/captures
.externalNativeBuild
.cxx
local.properties
```

settings

```java
include ':app'
rootProject.name = "Tzanca Uraganu'"
```

main_activity

```java
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
```
Va multumim pentru citire!