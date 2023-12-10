package com.example.tema2

import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tema2.databinding.ActivityEjercicio1Binding


class Ejercicio1Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEjercicio1Binding
    private lateinit var contador: Contador
    private lateinit var contadorDescendente: MyCountDownTimer
    private val PAUSA = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        contador = Contador(0, PAUSA)
        binding.tiempo.text = PAUSA.toString() + ": 00"
        binding.botonMenos.setOnClickListener(this)
        binding.botonMas.setOnClickListener(this)
        binding.botonComenzar.setOnClickListener(this)
    }
    override fun onClick(view: View) {

        if(view == binding.botonMenos) binding.tiempo.text = contador.disminuirTiempo();

        if(view == binding.botonMas) binding.tiempo.text = contador.aumentarTiempo();

        if( view == binding.botonComenzar) {

            if(binding.botonComenzar.text.equals("Comenzar")){
                contadorDescendente = MyCountDownTimer((contador.obtenerTiempo()*60*1000).toLong(), 1000)
                contadorDescendente.start()
                binding.botonMenos.isEnabled = false
                binding.botonMas.isEnabled = false
                binding.botonComenzar.isEnabled = false
            }else{
                binding.cuenta.text = "0"
                contador.setCafes(0)
                binding.botonComenzar.text = "Comenzar"
            }


        }
    }
    inner class MyCountDownTimer(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(
        millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {

            val minutos: Long
            val segundos: Long

            minutos = millisUntilFinished / 1000 / 60
            segundos = millisUntilFinished / 1000 % 60

            binding.tiempo.text = "$minutos:$segundos"
        }

        override fun onFinish() {
            Toast.makeText(this@Ejercicio1Activity, "Pausa terminada", Toast.LENGTH_LONG).show()
            binding.cuenta.text = contador.aumentarCafes()
            binding.tiempo.text = contador.obtenerTiempo().toString() + ":00"


            var mediaPlayer: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.sonido)
            mediaPlayer?.start() // no need to call prepare(); create() does that for you

            if(binding.cuenta.text.equals("10")){
                val popup: AlertDialog.Builder = AlertDialog.Builder(this@Ejercicio1Activity)
                popup.setTitle("Finalizado")
                popup.setMessage("Fin!!")
                popup.setPositiveButton("Ok", null)
                popup.show()


                binding.botonComenzar.text = "Reiniciar"
            }

            binding.botonMenos.isEnabled = true
            binding.botonMas.isEnabled = true
            binding.botonComenzar.isEnabled = true
        }
    }

}