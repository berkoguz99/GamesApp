package com.example.fragment_traning

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FirstAdapter(private val gamesList: ArrayList<GamesData>):
    RecyclerView.Adapter<FirstAdapter.MyHolder>() {



    inner class MyHolder(view: View): RecyclerView.ViewHolder(view){

        var imagessId:ImageView
        var gamesNames:TextView
        var gamesPoints:TextView
        var gamesTypes:TextView
        var metaa:TextView



        init {

            imagessId = view.findViewById(R.id.title_image)
            gamesNames = view.findViewById(R.id.name)
            gamesPoints = view.findViewById(R.id.point)
            gamesTypes = view.findViewById(R.id.type)
            metaa = view.findViewById(R.id.meta)



        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.rec_rov,parent,false)
        return  MyHolder(tasarim)

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val game = gamesList[position]






        Picasso.get().load(gamesList[position].imagesId).into(holder.imagessId)
        holder.gamesNames.text = game.gamesName
        holder.gamesPoints.text = game.gamesPoint
        holder.gamesTypes.text = game.gamesType
        holder.metaa.text = "metacritic:"


        holder.itemView.setOnClickListener{
            holder.itemView.findViewById<View>(R.id.item).setBackgroundColor(0x1F8E8E93)
            val intent= Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("gamedetails",gamesList.get(position))
            holder.itemView.context.startActivity(intent)



            }

        }









    override fun getItemCount(): Int {
        return gamesList.size
    }


}

