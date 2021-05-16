package com.konaly.projeto2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.konaly.projeto2.R
import com.konaly.projeto2.model.Produto
import com.konaly.projeto2.model.ProdutoItem
import kotlinx.android.synthetic.main.item.view.*

class HomeAdapter(private val items:Produto):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class HomeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(modelo: ProdutoItem) {
            itemView.textNome.text = modelo.nome
            itemView.textDesc.text = modelo.descricao
        }
    }
}