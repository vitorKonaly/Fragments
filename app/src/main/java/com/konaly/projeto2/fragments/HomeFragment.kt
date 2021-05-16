package com.konaly.projeto2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.konaly.projeto2.R
import com.konaly.projeto2.adapter.HomeAdapter
import com.konaly.projeto2.datasorce.Modelo
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val konaly = Modelo("konaly","black")
        val modelo = arrayListOf(konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly)
        recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = HomeAdapter(modelo)
    }

}