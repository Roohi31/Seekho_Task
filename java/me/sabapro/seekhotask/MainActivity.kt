package me.sabapro.seekhotask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

       //Fetching the API
        RetrofitInstance.api.getTopAnime().enqueue(object : Callback<TopAnimeResponse> {
            override fun onResponse(
                call: Call<TopAnimeResponse>,
                response: retrofit2.Response<TopAnimeResponse>) {
                if(response.isSuccessful)
                {
                    var videoURL = ""
                    val topAnimeList = response.body()?.data
                    topAnimeList?.forEach { anime ->
//                        Log.d("MainActivity", "Title: ${anime.title}")
//                        Log.d("MainActivity", "Episodes: ${anime.episodes ?: "N/A"}")
//                        Log.d("MainActivity", "Score: ${anime.score ?: "N/A"}")
//                        Log.d("MainActivity", "Image URL: ${anime.images.jpg.image_url}")

                        videoURL = anime.trailer.url

//                        Log.d("MainActivity", "Trailer URL: ${anime.trailer.url}")
//                        Log.d("MainActivity", "Synopsis : ${anime.synopsis}")
                    }

                    val animeList = response.body()?.data?: emptyList()
                    recyclerView.adapter = Adapter(animeList,this@MainActivity)

                }
            }

            override fun onFailure(call: Call<TopAnimeResponse>, t: Throwable) {
                Log.e("MainActivity", "Error fetching data: ${t.message}")
                t.printStackTrace()
            }

        })

    }
}