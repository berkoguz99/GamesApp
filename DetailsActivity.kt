package com.example.fragment_traning

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.squareup.picasso.Picasso


class DetailsActivity (): AppCompatActivity()  {
    //private lateinit var sharedPreferences: SharedPreferences
    private lateinit var favList: ArrayList<GamesData>
    var game: GamesData? = null
    private lateinit var favgame1 : GamesData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)
        val intent = intent
        // sharedPreferences = this.getSharedPreferences(
            //"com.example.fragment_traning",
            //Context.MODE_PRIVATE
        //)


        game = intent.getSerializableExtra("gamedetails") as GamesData
        //favgame1= game!!
        //favList= ArrayList<GamesData>()
        val fragmentManager: FragmentManager= supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val fav_ekle = findViewById<Button>(R.id.button)

            //supportFragmentManager.beginTransaction().replace(R.id.det,fragment).commit()






        Picasso.get().load(game!!.imagesId).into(findViewById<ImageView>(R.id.imageView2))
        findViewById<TextView>(R.id.textView6).text = game!!.gamesName
        findViewById<TextView>(R.id.textView8).text = game!!.gamesDesc
        //findViewById<TextView>(R.id.textView14).text = game!!.reddit
        //findViewById<TextView>(R.id.textView13).text = game!!.website

        val expandableTextView = findViewById<TextView>(R.id.textView8)
        expandableTextView.maxLines = 2
        val initialMaxLines = expandableTextView.maxLines
        expandableTextView.setOnClickListener {
            expandableTextView.maxLines = if (expandableTextView.maxLines == initialMaxLines) {
                Int.MAX_VALUE
            } else {
                initialMaxLines
            }


        }
        findViewById<TextView>(R.id.textView13).setOnClickListener {
            val openWebsite = Intent(android.content.Intent.ACTION_VIEW)
            openWebsite.data= Uri.parse(game!!.website)
            startActivity(openWebsite)

        }
        findViewById<TextView>(R.id.textView14).setOnClickListener {
            val openReddit = Intent(android.content.Intent.ACTION_VIEW)
            openReddit.data=Uri.parse(game!!.reddit)
            startActivity(openReddit)
        }

       // favList = ArrayList<GamesData>()





    }
    //val fav_ekle = findViewById<Button>(R.id.button)

    /*fun Favs(view: View){

        val fragment = Second()
        val bundle = Bundle()
        bundle.putSerializable("favgame",game!!)
        fragment.arguments=bundle






           /* if (game!!.is_it_fav==false) {
                favList.add(game!!)
                findViewById<Button>(R.id.button).text = ("Favourited")
                game!!.is_it_fav=true
               // val favvedgame= GamesData(game!!.imagesId,game!!.gamesName,game!!.gamesPoint,game!!.gamesType,game!!.gamesDesc,game!!.reddit,game!!.website,true)


            }
            else{
                findViewById<Button>(R.id.button).text=("Favourite")
                game!!.is_it_fav=false


            }*/



    }*/



    /*fav_ekle.setOnClickListener ()
        {
            fav_ekle.text = ("Favourited")
            sharedPreferences.edit().putString("gamesfavname", "Favourited")
            for (i in favList) {
                if (i != game!!) {
                f   avList.add(game!!)
                }


            }


        }*/

}


