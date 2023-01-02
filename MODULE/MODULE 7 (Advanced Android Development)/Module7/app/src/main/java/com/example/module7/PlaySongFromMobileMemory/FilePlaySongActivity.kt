package com.example.module7.PlaySongFromMobileMemory

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.module7.R


class FilePlaySongActivity : AppCompatActivity() {

    lateinit var btnPlay : ImageButton

    private val PICK_AUDIO_FILE = 1
    var audioUri: Uri? = null
    lateinit var selectaudio: TextView
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_playsong)

        btnPlay = findViewById(R.id.btn_file_play)
        selectaudio = findViewById(R.id.tv_select_audio)

        mediaPlayer = MediaPlayer()

        selectaudio.setOnClickListener {
            mediaPlayer.stop()
            val audio = Intent()
            audio.type = "audio/*"
            audio.action = Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(
                Intent.createChooser(audio, "Select Audio From Media File"),
                PICK_AUDIO_FILE
            )
        }

        btnPlay.visibility = View.INVISIBLE

        btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_24)
            } else {
                mediaPlayer.pause()
                btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_AUDIO_FILE && resultCode == RESULT_OK) {
            // Audio is Picked in format of URI
            audioUri = data!!.data
            mediaPlayer  = MediaPlayer.create(this@FilePlaySongActivity,audioUri)
            selectaudio.text = "$audioUri"
            btnPlay.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer.stop()
    }

}