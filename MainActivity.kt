package com.example.fragment_traning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_traning.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {

    private  lateinit var gamesList: ArrayList<GamesData>
    private lateinit var adapter: FirstAdapter
    private lateinit var recyclerView: RecyclerView





    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)






        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(First())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.games-> replaceFragment(First())
                R.id.fav-> replaceFragment(Second())

                else->{

                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager= supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}