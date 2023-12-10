package com.example.tema2

class Contador {
    private val DESCANSO = 5
    private var cafes: Int//número de cafés
    private var tiempo: Int // tiempo de la pausa en minutos
    constructor() {
        cafes = 0
        tiempo = DESCANSO
    }
    constructor(c: Int, t: Int) {
        cafes = c
        tiempo = t
    }
    fun aumentarTiempo(): String {
        tiempo += 1
        return tiempo.toString() + ":00"
    }
    fun disminuirTiempo(): String {
        tiempo -= 1
        if (tiempo < 1) tiempo = 1
        return tiempo.toString() + ":00"
    }
    fun obtenerTiempo(): Int {
        return tiempo
    }
    fun aumentarCafes(): String {
        cafes += 1
        return cafes.toString()
    }
    fun setCafes(n: Int){
        cafes = n
    }
}