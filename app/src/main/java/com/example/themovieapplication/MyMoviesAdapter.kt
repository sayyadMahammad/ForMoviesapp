package com.example.themovieapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapplication.models.MyMovies
import kotlinx.android.synthetic.main.movie_item.view.*

class MyMoviesAdapter (
    private val movies:List<MyMovies>
        ) : RecyclerView.Adapter<MyMoviesAdapter.MovieViewHolder>() {
            class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
                fun bindMovie(movie : MyMovies ){
                     val ImageBase = "https://image.tmdb.org/t/p/w500/"
                    itemView.movieTitle.text= movie.title
                    itemView.movieReleaseDate.text=movie.release
                    Glide.with(itemView).load(ImageBase+movie.poster).into(itemView.moviePoster)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
       )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size
}