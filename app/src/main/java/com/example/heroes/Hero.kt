package com.example.heroes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val superpower: String,
    val ranking: Int,
    val image: String
) : Parcelable, Comparable<Hero> {
    override fun compareTo(other: Hero): Int {
        // ranking will be the natural ordering
        // if the current hero is rak 1
        // the other hero is rank 3
        // the result shoudld be -2
        return this.ranking - other.ranking
        TODO("Not yet implemented")
    }
}

