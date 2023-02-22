package com.example.fragment_traning

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList







open class First : Fragment() {


    private  lateinit var gamesList: ArrayList<GamesData>
    private lateinit var adapter: FirstAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView :SearchView
    private lateinit var searchlist: ArrayList<GamesData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }





    @SuppressLint("SuspiciousIndentation")



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            gamesList = ArrayList<GamesData>()
            searchlist = ArrayList<GamesData>()


            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.rawg.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val arrayList2 = ArrayList<Result>()

            val api: APISERV = retrofit.create(APISERV::class.java)
            val call: Call<JSON> = api.oyunAl("3be8af6ebf124ffe81d90f514e59856c")

            call.enqueue(object : Callback<JSON> {

                override fun onResponse(call: Call<JSON>, response: Response<JSON>) {
                    println("5")
                    if (response.isSuccessful) {
                        val games = response.body()?.results
                        // ...

                        val listofgames = ArrayList(games)





                        for (result in listofgames) {


                            val retrofitv2: Retrofit = Retrofit.Builder()
                                .baseUrl("https://api.rawg.io/api/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()


                            val apiv2: APISERV = retrofitv2.create(APISERV::class.java)
                            val callv2: Call<DETAILSSS> = apiv2.getGameDescription(
                                result.id,
                                "3be8af6ebf124ffe81d90f514e59856c"
                            )

                            callv2.enqueue(object : Callback<DETAILSSS> {
                                override fun onResponse(
                                    call: Call<DETAILSSS>,
                                    response: Response<DETAILSSS>
                                ) {

                                    if (response.isSuccessful) {

                                        val aciklama = response.body()?.description!!
                                        val website = response.body()?.website!!
                                        val reddit = response.body()?.reddit_url!!
                                        val genresList = result.genres

                                        var genresName = ""
                                        for (genre in genresList) {
                                            genresName += genre.name + ", "
                                        }

                                        val nesne = GamesData(
                                            result.background_image,
                                            result.name,

                                            result.metacritic.toString(),
                                            genresName, aciklama,
                                            website,
                                            reddit
                                        )

                                        gamesList.add(nesne)
                                        searchlist.add(nesne)
                                    }
                                    adapter.notifyDataSetChanged()
                                }

                                override fun onFailure(call: Call<DETAILSSS>, t: Throwable) {
                                    // handle failure
                                }
                            })


                        }




                        adapter.notifyDataSetChanged()


                    } else {
                        // Handle error

                        Log.e("API Call Error", "Error code: ${response.code()}")

                    }
                }

                override fun onFailure(call: Call<JSON>, t: Throwable) {

                    TODO("Not yet implemented")

                }


            })


            val layoutManager = LinearLayoutManager(context)
            recyclerView = view.findViewById(R.id.recyclerView)
            searchView = view.findViewById(R.id.search_fiel)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            adapter = FirstAdapter(searchlist)
            recyclerView.adapter = adapter


            searchView.clearFocus()


            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {

                    searchView.clearFocus()

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    searchlist.clear()
                    val searchtext = newText!!.toLowerCase(Locale.getDefault())
                    if (searchtext.isEmpty()) {

                        recyclerView.visibility = View.GONE


                    }

                    if (searchtext.length >= 3) {

                        gamesList.forEach {
                            recyclerView.visibility = View.VISIBLE


                            if (it.gamesName.toLowerCase(Locale.getDefault())
                                    .contains(searchtext)
                            ) {
                                searchlist.add(it)


                            }
                        }


                        recyclerView.adapter!!.notifyDataSetChanged()


                    } else {

                        searchlist.clear()
                        searchlist.addAll(gamesList)
                        recyclerView.adapter!!.notifyDataSetChanged()

                    }
                    return false

                }


            })

        }




















    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view = inflater.inflate(R.layout.fragment_first,container,false)



        // Inflate the layout for this fragment
        return view
    }
    companion object {

        const val ARG_COLUMN_COUNT = "column-count"


        @JvmStatic
        fun newInstance(columnCount :Int) =
            First().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT,columnCount)
                }
            }

    }





}



