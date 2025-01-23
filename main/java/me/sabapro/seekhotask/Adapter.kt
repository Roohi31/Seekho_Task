package me.sabapro.seekhotask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val AnimeList: List<Anime>, val context: Context) : RecyclerView.Adapter<Adapter.innerAdapter>()
{

    inner class innerAdapter(itemview: View) : RecyclerView.ViewHolder(itemview)
    {
        var img : ImageView
        var title : TextView?
        var episode : TextView?
        var score : TextView?

//        var trailer : ImageView
//        var synopsis : String?


        init {
            img = itemview.findViewById(R.id.img_IV)
            title = itemview.findViewById(R.id.title_tv)
            episode = itemview.findViewById(R.id.episode_tv)
            score = itemview.findViewById(R.id.score_tv)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerAdapter {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return innerAdapter(viewHolder)
    }

    override fun getItemCount(): Int {
        return AnimeList.size
    }

    override fun onBindViewHolder(holder: innerAdapter, position: Int) {
        Glide.with(holder.itemView.context).load(AnimeList[position].images.jpg.image_url).into(holder.img)
        holder.title?.setText(AnimeList[position].title)
        holder.episode?.setText(AnimeList[position].episodes)
        holder.score?.setText(AnimeList[position].score)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("title", AnimeList[position].title) // Pass the anime ID
            intent.putExtra("No_of_Episode", AnimeList[position].episodes) // Pass the anime ID
            intent.putExtra("Score", AnimeList[position].score) // Pass the anime ID
            intent.putExtra("image_url", AnimeList[position].images.jpg.image_url) // Pass the anime ID
            intent.putExtra("trailer", AnimeList[position].trailer.url) // Pass the anime ID
            intent.putExtra("synopsis", AnimeList[position].synopsis) // Pass the anime ID
            context.startActivity(intent)
        }
    }

}