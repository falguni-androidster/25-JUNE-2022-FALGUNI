package com.example.module7.PlaySongFromResource

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.module7.R

class ResourcePlaySongActivity : AppCompatActivity() {

    lateinit var btnPlay : ImageButton
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_playsong)

        btnPlay = findViewById(R.id.btn_resource_play)

        mediaPlayer = MediaPlayer.create(this,R.raw.music)

        btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaPlayer.pause()
                btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer.stop()
    }
}