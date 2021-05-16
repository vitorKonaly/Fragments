package com.konaly.projeto2.network

import com.konaly.projeto2.model.Produto
import retrofit2.Call
import retrofit2.http.GET

interface ProdutosAPI {

    @GET("produtos")
    fun getProdutos():Call<Produto>
}