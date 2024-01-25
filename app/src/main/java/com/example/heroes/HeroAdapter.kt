package com.example.heroes

import android.content.Intent
import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(var heroesList: List<Hero>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    companion object{
        val EXTRA_NAME = "name"
        val EXTRA_RANK = "rank"
        val EXTRA_DESC = "desc"
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewRanking: TextView
        val textViewName: TextView
        val textViewDesc: TextView
        val layout: ConstraintLayout

        init {
            textViewRanking = view.findViewById(R.id.textView_heroitem_rank)
            textViewName = view.findViewById(R.id.textView_heroitem_name)
            textViewDesc = view.findViewById(R.id.textView_heroitem_desc)
            layout = view.findViewById(R.id.layout_itemHero)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_hero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hero = heroesList[position]
        val context = viewHolder.layout.context
        viewHolder.textViewRanking.text = hero.ranking.toString()
        viewHolder.textViewName.text = hero.name
        viewHolder.textViewDesc.text = hero.description


        // click listener for clicking anywhere on the current hero
        viewHolder.layout.setOnClickListener {
            val detailIntent = Intent(context, HeroesDetailActivity::class.java)
            detailIntent.putExtra(HeroesDetailActivity.EXTRA_HERO, hero)
            context


        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = heroesList.size

}