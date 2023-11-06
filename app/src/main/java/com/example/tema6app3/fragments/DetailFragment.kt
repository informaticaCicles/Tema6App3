package com.example.tema6app3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tema6app3.R
import com.example.tema6app3.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    //private lateinit var binding: FragmentDetailBinding
    private lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textView = view.findViewById<TextView>(R.id.tvDetalle)
        return view

        /*binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root*/
    }

    // Creamos un método público que nos ayude a asignar el contenido del correo
    fun mostrarDetalle(texto: String) {
        textView.text = texto
    }
}