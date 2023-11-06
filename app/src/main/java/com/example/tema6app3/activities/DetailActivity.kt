package com.example.tema6app3.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tema6app3.R

import com.example.tema6app3.databinding.ActivityDetailBinding
import com.example.tema6app3.fragments.DetailFragment


class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detalle = supportFragmentManager
            .findFragmentById(R.id.frgDetalle) as DetailFragment?

        intent.getStringExtra("TextoDetalle")?.let { detalle?.mostrarDetalle(it) }

    }
}