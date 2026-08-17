package com.example.calcidade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etanoatual: EditText
    private lateinit var etanonasc: EditText
    private lateinit var etidadeemanos: TextView
    private lateinit var etidadeemmeses: TextView
    private lateinit var etidadeemsemanas: TextView
    private lateinit var etidadeemdias: TextView
    private lateinit var etidadeemhoras: TextView

    private lateinit var etidadeemminutos: TextView
    private lateinit var etidadeemsegundos: TextView




    private lateinit var btcalc: Button
    private lateinit var btlimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            var systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etanoatual = findViewById(R.id.etanoatual)
        etanonasc = findViewById(R.id.etanonasc)
        etidadeemanos = findViewById(R.id.etidadeemanos)
        etidadeemmeses = findViewById(R.id.etidadeemmeses)
        etidadeemdias = findViewById(R.id.etidadeemdias)
        etidadeemhoras = findViewById(R.id.etidadeemhoras)
        etidadeemminutos = findViewById(R.id.etidadeemminutos)
        etidadeemsegundos = findViewById(R.id.etidadeemsegundos)





        btcalc = findViewById(R.id.btcalc)
        btlimpar = findViewById(R.id.btlimpar)

        btcalc.setOnClickListener {
            var sAnonasc = etanonasc.text.toString()
            var sAnoatual = etanoatual.text.toString()
            //val sFaltas = etfaltas.text.toString()

            if (sAnonasc.isEmpty() || sAnoatual.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var anon = sAnonasc.toDouble()
            var anoa = sAnoatual.toDouble()
            //val faltas = sFaltas.toInt()

            var anos = (anoa - anon)

            etidadeemanos.text = String.format("%.1f", anos)

            var meses = (anos * 12)

            etidadeemmeses.text = String.format("%.1f", meses)

            var dias = (meses * 30)

            etidadeemdias.text = String.format("%.1f", dias)

            var horas = (dias * 24)

            etidadeemhoras.text = String.format("%.1f", horas)

            var minutos = (horas * 60)

            etidadeemminutos.text = String.format("%.1f", minutos)

            var segundos = (minutos * 60)

            etidadeemsegundos.text = String.format("%.1f", segundos)

        }
    }
}
