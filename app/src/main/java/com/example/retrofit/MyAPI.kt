package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
interface MyAPI
{
    @GET("v3/01532b41-82a2-4183-aa2e-71bc7e70aa29")
    fun getAll():Call<List<Mobile>>




}