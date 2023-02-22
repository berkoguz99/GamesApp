package com.example.fragment_traning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Second() : Fragment() {


    private lateinit var adapter: FirstAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var  favList : ArrayList<GamesData>
    private lateinit var favgame : GamesData

    //var favgame1 = GamesData(R.drawable.a,"Gta","6","action","Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate)....","https//sdsdasdad//","HttpsU//sdjsoreddit")
    //var favgame2 = GamesData(R.drawable.b,"valorant","1","action","Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate)....","https//sdsdasdad//","HttpsU//sdjsoreddit")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)





         //val data =arguments


        // favgame= data!!.getSerializable("favgame") as GamesData


         //favList.add(favgame)
        favList = ArrayList<GamesData>()
        //favList.add(favgame1)
        //favList.add(favgame2)







        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FirstAdapter(favList)
        recyclerView.adapter = adapter





        if (favList.size == 0){

            view.findViewById<TextView>(R.id.favnotfound).text= "There is no favourites found."


        }else{
            view.findViewById<TextView>(R.id.title).text = "Favourites(${favList.size})"

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


}