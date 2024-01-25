package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroes.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesDetailBinding

    companion object{
        val EXTRA_HERO = "hero"

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)

    }
}