package com.example.tema6app3.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tema6app3.R
import com.example.tema6app3.databinding.ListElementBinding
import com.example.tema6app3.pojos.Correo

class CorreoAdapter (private val correos: List<Correo>, private val listener: OnClickListener): RecyclerView.Adapter<CorreoAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = correos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val correo = correos.get(position)
        with(holder){
            setListener(correo)
            binding.tvDe.text = correo.getDe()
            binding.tvAsunto.text = correo.getAsunto()
        }
    }


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListElementBinding.bind(view)

        fun setListener(correo:Correo){
            binding.root.setOnClickListener {
                listener.onClick(correo)
            }
        }
    }
}