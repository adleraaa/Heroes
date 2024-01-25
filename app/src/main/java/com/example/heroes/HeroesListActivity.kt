package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {

    companion object {
        val TAG = "HeroesListActivity"
    }

    private lateinit var binding: ActivityHeroesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        
//        Log.d(TAG, "onCreate: $jsonString")

        val gson = Gson()
        val type = object : TypeToken<List<Hero>>() { }.type
        val heroes = gson.fromJson<List<Hero>>(jsonString, type).sorted()

        Log.d(TAG, "onCreate: $heroes")

        // link the adapter to the recyclerview and give it the list
        val adapter = HeroAdapter(heroes)
        binding.recyclerViewHeroesListHeroes.adapter = adapter
        binding.recyclerViewHeroesListHeroes.layoutManager = LinearLayoutManager(this)



    }

}