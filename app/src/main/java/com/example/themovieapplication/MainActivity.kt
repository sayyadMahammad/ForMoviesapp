package com.example.themovieapplication

//App centre
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapplication.models.MyMovies
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


const val movieTitle = "movietitle"
const val moviePoster = "movieposter"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "72bf5f02-43fb-4073-a6d9-83e000ce0fcb",
            Analytics::class.java, Crashes::class.java
        )



        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        moviestList.layoutManager = LinearLayoutManager(this)
         moviestList.setHasFixedSize(true)

        val dialog = Dialog(this)
        dialog.apply {
            setContentView(R.layout.progressbar_item)
            setCancelable(true)
            show()
        }
        val movieAdapter by lazy {MyMoviesAdapter(::OnItemClicked)}
        moviestList.adapter=movieAdapter

        mainViewModel.apply {

            myMoviesList.observe(this@MainActivity, Observer {
                movieAdapter.setData(it)
            })

            onLoadingResponse().observe(this@MainActivity, Observer{
                if (it) {
                    dialog.dismiss()
                }
            })
            onFailureResponse().observe(this@MainActivity, Observer{
                if (it) {
                    dialog.dismiss()
                     intent = Intent(this@MainActivity, FailureActivity::class.java)
                    startActivity(intent)
                }

            })
        }

    }

     fun OnItemClicked(item: MyMovies) {
        val title = item.title
        val imagePoster = item.poster
        intent=Intent(this,DetailsActivity::class.java)
        intent.putExtra(movieTitle,title)
        intent.putExtra(moviePoster,imagePoster)
        startActivity(intent)
    }

//    fun OnItemClicked(item: MyMovies) {
//      //  val title = item.title
//        //val imagePoster = item.poster
//        intent=Intent(this,DetailsActivity::class.java)
//       // intent.putExtra(movieTitle,title)
//       // intent.putExtra(moviePoster,imagePoster)
//        startActivity(intent)
//    }
}