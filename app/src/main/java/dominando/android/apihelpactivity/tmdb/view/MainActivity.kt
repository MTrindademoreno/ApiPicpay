package dominando.android.apihelpactivity.tmdb.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.tmdb.adapter.HomeAdapter
import dominando.android.apihelpactivity.tmdb.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupOnservables()






    }



    private fun setupOnservables() {

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getTopRated()
        mainViewModel.userLiveData.observe(this, Observer {
            findViewById<RecyclerView>(R.id.rvHelp).apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = HomeAdapter(it)
            }
        })
    }
}