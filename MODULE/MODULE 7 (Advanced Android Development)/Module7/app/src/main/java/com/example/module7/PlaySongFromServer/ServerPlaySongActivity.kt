package com.example.module7.PlaySongFromServer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.net.toUri
import com.example.module7.R

class ServerPlaySongActivity : AppCompatActivity() {

    lateinit var btnPlay : ImageButton
    var audiourl = "https://ghantalele.com/uploads/files/data-77/38145/Tu%20You%20-%20Armaan%20Malik_192(Ghantalele.com).mp3"

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_playsong)

        btnPlay = findViewById(R.id.btn_server_play)

        mediaPlayer = MediaPlayer.create(this@ServerPlaySongActivity,audiourl.toUri())

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