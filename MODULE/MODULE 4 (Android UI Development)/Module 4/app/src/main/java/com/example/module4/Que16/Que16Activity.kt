package com.example.module4.Que16

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.module4.R

class Que16Activity : AppCompatActivity() {

    var seekR : Int = 0
    var seekG : Int = 0
    var seekB : Int = 0

    lateinit var seekbarred : SeekBar
    lateinit var seekbargreen : SeekBar
    lateinit var seekbarblue : SeekBar

    lateinit var linear : LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que16)

        linear = findViewById(R.id.ll_que16)

        seekbarred = findViewById(R.id.sb_red)
        seekbargreen = findViewById(R.id.sb_green)
        seekbarblue = findViewById(R.id.sb_blue)

        seekbarred.setOnSeekBarChangeListener(seekBarChangeListener);
        seekbargreen.setOnSeekBarChangeListener(seekBarChangeListener);
        seekbarblue.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    private val seekBarChangeListener: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            // TODO Auto-generated method stub
            updateBackground()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            // TODO Auto-generated method stub
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
           // TODO Auto-generated method stub
        }
    }

    private fun updateBackground() {
        seekR = seekbarred.getProgress()
        seekG = seekbargreen.getProgress()
        seekB = seekbarblue.getProgress()
        linear.setBackgroundColor(-0x1000000 + seekR * 0x10000 + seekG * 0x100 + seekB)
    }
}