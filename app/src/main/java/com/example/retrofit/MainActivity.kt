package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mobilelist: List<Mobile>
    private lateinit var recyclerview: RecyclerView

    private val BASE_URL = "https://run.mocky.io"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllMobiles()
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)


    }

    private fun getAllMobiles() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
        api.getAll().enqueue(object : Callback<List<Mobile>> {
            override fun onResponse(
                call: Call<List<Mobile>>,
                response: Response<List<Mobile>>

            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        mobilelist = it
                        recyclerview.adapter = MyAdapter(mobilelist)
                    }
                }
            }

            override fun onFailure(call: Call<List<Mobile>>, t: Throwable) {
                Log.e("failure", "failure")
            }


        })


    }


}