package com.demo.reidyn.demoanimacion;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by desarrollo on 05/07/17.
 */

public class AlarmFramesActivity extends AppCompatActivity{

    private ImageView imageView;
    private Button btnIniciar;
    private Button btnDetener;
    private AnimationDrawable animationDrawable;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms_frames);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.alarms_imagen);
        animationDrawable = (AnimationDrawable)imageView.getBackground();

        btnIniciar = (Button)findViewById(R.id.btnIniciar);
        btnDetener = (Button)findViewById(R.id.btnDetener);

        asignarEventos();
    }

    private void asignarEventos(){
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
                try {
                    playSound();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
                stopSound();
            }
        });
    }

    private void playSound() throws IOException {
        stopSound();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ringing);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
