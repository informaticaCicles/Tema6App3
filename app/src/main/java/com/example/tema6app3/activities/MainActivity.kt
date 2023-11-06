package com.example.tema6app3.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tema6app3.R
import com.example.tema6app3.databinding.ActivityMainBinding
import com.example.tema6app3.fragments.CorreosListener
import com.example.tema6app3.fragments.DetailFragment
import com.example.tema6app3.fragments.ListFragment
import com.example.tema6app3.pojos.Correo


class MainActivity : AppCompatActivity(), CorreosListener{

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frgListado: ListFragment = supportFragmentManager.findFragmentById(binding.frgListado.id) as ListFragment
        frgListado.setCorreosListener(this)

        //val correo = intent.getSerializableExtra("Correo") as? Correo


    }

    override fun onCorreoSeleccionado(correo: Correo) {
        if (correo != null) {
            var hayDetalle = binding.frgDetalle?.let { supportFragmentManager.findFragmentById(it.id) } != null

            if(hayDetalle){//Se muestra el contenido en la misma Activity

                val detailFragment = DetailFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frgDetalle, detailFragment)
                transaction.commitNow()
                detailFragment.mostrarDetalle(correo.getTexto())

                /*// Find or create the DetailFragment
                val detailFragment = supportFragmentManager.findFragmentById(R.id.frgDetalle) as? DetailFragment ?: DetailFragment()

                // Add or replace the DetailFragment in a container
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frgDetalle, detailFragment, "detailFragment").commit()

                detailFragment.mostrarDetalle(correo.getTexto())*/



                /* (binding.frgDetalle?.let {
                     supportFragmentManager
                         .findFragmentById(it.id)
                 } as DetailFragment?)?.mostrarDetalle(correo.getTexto())*/
            }else{
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra("TextoDetalle", correo.getTexto())
                startActivity(i)
            }
        }
    }


}