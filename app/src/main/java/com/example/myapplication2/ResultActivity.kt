package com.example.myapplication2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var  resultTextView: TextView
    lateinit var  imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTextView = findViewById<TextView>(R.id.resultTextView)
        imageView = findViewById<ImageView>(R.id.imageView)
        var height = intent.getStringExtra("height")?.toInt()
        var weight = intent.getStringExtra("weight")?.toInt()
        var name = intent.getStringExtra("name")
        // BMI 계산
        val heightValue = height?.div(100.0) ?: 0.0
        val bmi = weight?.div(Math.pow(heightValue, 2.0))

        //글자로 출력
        when{
            bmi!! >= 35 -> resultTextView.text = "고도 비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }

        //이미지 출력
        when{
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.baseline_mood_24)
            bmi > 18.5 ->
                imageView.setImageResource(
                    R.drawable.baseline_mood_24)
            else ->
                imageView.setImageResource(
                    R.drawable.baseline_mood_bad_24)
        }
        Toast.makeText(this,"$name"+" : "+"$bmi", Toast.LENGTH_SHORT).show()
    }
}