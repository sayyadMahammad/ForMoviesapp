package com.example.themovieapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapplication.models.MyMovies


class MyMoviesAdapter (
    val itemClicked : (MyMovies)->Unit
        ) : RecyclerView.Adapter<MyMoviesAdapter.MovieViewHolder>() {

            class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
                var movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
                var  movieReleaseDate  =itemView.findViewById<TextView>(R.id.movieReleaseDate)
                var moviePoster = itemView.findViewById<ImageView>(R.id.moviePoster)
            }

    private var resultList = mutableListOf<MyMovies>()
    private val moviesList:List<MyMovies>
    get() = resultList
    fun setData(list :List<MyMovies>){
        resultList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        val  newItemView= MovieViewHolder(view)
        view.setOnClickListener {
            itemClicked(moviesList[newItemView.adapterPosition])
        }
        return newItemView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val ImageBase = "https://image.tmdb.org/t/p/w500/"
        holder.movieTitle.text=moviesList[position].title
        holder.movieReleaseDate.text=moviesList[position].release
        Glide.with(holder.itemView).load(ImageBase+moviesList[position].poster).into(holder.moviePoster)
    }
    override fun getItemCount(): Int = moviesList.size
}
