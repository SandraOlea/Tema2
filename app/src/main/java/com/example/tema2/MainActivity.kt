package com.example.tema2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 : Button = findViewById(R.id.button)
        val boton2 : Button = findViewById(R.id.button2)
        val boton3 : Button = findViewById(R.id.button3)

        boton1.setOnClickListener {
            val miIntent1 = Intent(this, Ejercicio1Activity::class.java)
            startActivity(miIntent1)
        }




    }
}