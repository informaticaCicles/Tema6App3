package com.example.tema6app3.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema6app3.activities.MainActivity
import com.example.tema6app3.adapters.CorreoAdapter
import com.example.tema6app3.adapters.OnClickListener
import com.example.tema6app3.databinding.FragmentListBinding
import com.example.tema6app3.pojos.Correo


class ListFragment : Fragment(), OnClickListener{
    private lateinit var correoAdapter: CorreoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: FragmentListBinding

    private lateinit var listener: CorreosListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        correoAdapter = CorreoAdapter(Correo.CorreoDatos.CORREOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply{
            layoutManager = linearLayoutManager
            adapter = correoAdapter
            addItemDecoration(itemDecoration)
        }
        //Hacer click sobre un elemento del recycler
        /*binding.recyclerIdList.setOnClickListener {
            var position = binding.recyclerIdList.getChildAdapterPosition(it)
            Toast.makeText(context, "Seleccion: ${Correo.CorreoDatos.CORREOS.get(position).getDe()}", Toast.LENGTH_LONG).show()

            if(listener!=null){
                listener.onCorreoSeleccionado(Correo.CorreoDatos.CORREOS.get(position))
            }
        }*/

        return binding.root
    }

    /*fun setCorreosListener(listener: CorreosListener) {
        this.listener = listener
    }*/

    override fun onClick(correo: Correo) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("Correo", correo)
        startActivity(intent)
    }


}