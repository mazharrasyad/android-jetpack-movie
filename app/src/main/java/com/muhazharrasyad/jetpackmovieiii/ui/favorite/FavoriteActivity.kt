package com.muhazharrasyad.jetpackmovieiii.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhazharrasyad.jetpackmovieiii.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        val sectionsPagerFavoriteAdapter = SectionsPagerFavoriteAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = sectionsPagerFavoriteAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Favorite"
    }
}