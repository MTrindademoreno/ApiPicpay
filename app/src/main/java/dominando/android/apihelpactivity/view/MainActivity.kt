package dominando.android.apihelpactivity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.adapter.HomeAdapter
import dominando.android.apihelpactivity.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getUsers()

        mainViewModel.userLiveData.observe(this, Observer {
            findViewById<RecyclerView>(R.id.rvHelp).apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = HomeAdapter(it)
            }
        })


    }
}