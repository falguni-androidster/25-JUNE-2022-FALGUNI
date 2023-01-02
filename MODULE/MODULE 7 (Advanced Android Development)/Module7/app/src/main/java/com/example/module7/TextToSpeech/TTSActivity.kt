package com.example.module7.TextToSpeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.module7.R
import java.util.*

class TTSActivity : AppCompatActivity(),TextToSpeech.OnInitListener{

    var tts : TextToSpeech?= null
    lateinit var eddata : EditText
    lateinit var ivtts : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ttsactivity)

        eddata = findViewById(R.id.ed_ttsdata)
        ivtts = findViewById(R.id.iv_tts)

        tts = TextToSpeech(this@TTSActivity,this)

        ivtts.setOnClickListener {
            var texttospeech = eddata.text.toString()
            tts!!.speak(texttospeech,TextToSpeech.QUEUE_ADD,null,"")
            tts!!.setSpeechRate(0.5f)
        }

    }

    override fun onInit(p0: Int) {
        if (p0 == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this@TTSActivity, "Language not supported", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }
    }
}