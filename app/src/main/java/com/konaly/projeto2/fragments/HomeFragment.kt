package com.konaly.projeto2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.konaly.projeto2.R
import com.konaly.projeto2.adapter.HomeAdapter
import com.konaly.projeto2.datasorce.Modelo
import com.konaly.projeto2.model.Produto
import com.konaly.projeto2.network.ProdutosAPI
import com.konaly.projeto2.network.RetrofitInstance
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
//        val konaly = Modelo("konaly","black")
//        val modelo = arrayListOf(konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly,konaly)

        callGetProdutos()


    }

    private fun callGetProdutos() {
        val produtosApi : ProdutosAPI = RetrofitInstance.getRestEngin().create(ProdutosAPI::class.java)
        val result: Call<Produto> = produtosApi.getProdutos()
        result.enqueue(object : Callback<Produto>{
            override fun onFailure(call: Call<Produto>, t: Throwable) {
                Toast.makeText(context,"ERRO",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                recycler.adapter = response.body()?.let { HomeAdapter(it) }
            }
        })
    }

}