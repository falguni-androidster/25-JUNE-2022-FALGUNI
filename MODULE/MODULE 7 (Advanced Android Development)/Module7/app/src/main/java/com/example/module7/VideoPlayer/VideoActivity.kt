package com.example.module7.VideoPlayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import com.example.module7.R

class VideoActivity : AppCompatActivity() {

    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        // Awake Screen
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        videoView = findViewById(R.id.video)

        var mediacontroller = MediaController(this@VideoActivity)
        mediacontroller.setAnchorView(videoView)

        var offlineURL = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoView.setMediaController(mediacontroller)
        videoView.setVideoURI(offlineURL)
        videoView.requestFocus()
        videoView.start()

    }
}