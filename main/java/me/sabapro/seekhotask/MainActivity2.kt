package me.sabapro.seekhotask

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val title = intent.getStringExtra("title")
        val no_epi = intent.getStringExtra("No_of_Episode")
        val score = intent.getStringExtra("Score")
        val img_url = intent.getStringExtra("image_url")
        val trailer = intent.getStringExtra("trailer")
        val syno = intent.getStringExtra("synopsis")

//        Toast.makeText(this,"TITLE : $title",Toast.LENGTH_SHORT).show(
//        Log.e("SecondActivity","No Of Eposide $no_epi \n ${score} \n ${img_url} \n ${trailer} \n ${syno}")

        val title_tv = findViewById<TextView>(R.id.sec_title_tv)
        val synop_tv = findViewById<TextView>(R.id.sec_synopsis_tv)
        val epo_tv = findViewById<TextView>(R.id.sec_no_of_epi_TV)
        val rating = findViewById<TextView>(R.id.sec_rating_tv)
        val img_vid = findViewById<ImageView>(R.id.sec_video_VV)


        title_tv.setText(title)
        synop_tv.setText(syno)
        epo_tv.setText(no_epi)
        rating.setText(score)
        Glide.with(this).load(img_url).into(img_vid)

//        if(trailer != null)
//        {
//            Glide.with(this)
//                .asBitmap()
//                .load(trailer)
//                .into(img_vid)
//        }

//        if(trailer != null)
//        {
////            img_vid.setImageResource(trailer.toInt())
//            // Load the video thumbnail
//
//            Glide.with(this)
//                .asBitmap() // Ensures Glide loads a bitmap (thumbnail)
//                .load(trailer) // Load the video URL
//                .into(img_vid)
//        }
//        else
//        {
////            if(img_url != null)
////            {
////                img_vid.setImageResource(img_url.toInt())
////            }
//
//            val e =  Glide.with(this)
//                .load(img_url)
//                .into(img_vid)
//
//        }

    }
}