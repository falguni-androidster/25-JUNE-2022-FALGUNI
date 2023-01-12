package com.example.rockpaperscissorsgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    var gameArray = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
    var gameNumber : Int = 0

    lateinit var rock : AppCompatButton
    lateinit var paper : AppCompatButton
    lateinit var scissors : AppCompatButton

    lateinit var topImage : ImageView
    lateinit var bottomImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "CPU - top, Human - bottom", Toast.LENGTH_LONG).show()

        rock = findViewById(R.id.rockButton)
        paper = findViewById(R.id.paperButton)
        scissors = findViewById(R.id.scissorsButton)
        topImage = findViewById(R.id.topImage)
        bottomImage = findViewById(R.id.bottomImage)

        // each button will use onClick function
        rock.setOnClickListener {
            gameNumber = 1 //value for rock
            bottomImage.setImageResource(R.drawable.rock) //sets buttom image as user
            computerPlay() //function provides random cpu image
        }
        paper.setOnClickListener{
            gameNumber = 2
            bottomImage.setImageResource(R.drawable.paper)
            computerPlay()
        }
        scissors.setOnClickListener{
            gameNumber = 3
            bottomImage.setImageResource(R.drawable.scissors)
            computerPlay()
        }
    }

    private fun computerPlay() {
        val imageId = (0..(gameArray.size - 1)).random()
        topImage.setImageResource(gameArray[imageId])
        checkWinner(imageId)
    }

    private fun checkWinner(imageId : Int) {
        // game logic - gets user image by value and checks against cpu image
        if(gameNumber == 1 && imageId == 0) {
            showWinner(2)
        } else if(gameNumber == 1 && imageId == 1){
            showWinner(1)
        } else if(gameNumber == 1 && imageId == 2){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 0){
            showWinner(0)
        } else if(gameNumber == 2 && imageId == 1){
            showWinner(2)
        } else if(gameNumber == 2 && imageId == 2){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 0){
            showWinner(1)
        } else if(gameNumber == 3 && imageId == 1){
            showWinner(0)
        } else if(gameNumber == 3 && imageId == 2){
            showWinner(2)
        }
    }

    private fun showWinner(result: Int) {
        //winning logic
        when (result) {
            0 -> Toast.makeText(this, "Yuppiii, You Won!!!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "Oh Noooo, You Lost!!!", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Tie Game!!!", Toast.LENGTH_SHORT).show()
        }
    }
}