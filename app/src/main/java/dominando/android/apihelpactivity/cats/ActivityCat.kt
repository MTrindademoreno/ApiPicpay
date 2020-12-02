package dominando.android.apihelpactivity.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.apihelpactivity.cats.viewModel.CatViewModel
import dominando.android.apihelpactivity.databinding.ActivityMainBinding
import dominando.android.apihelpactivity.databinding.CatActivityMainBinding

class ActivityCat : AppCompatActivity() {
private val catsAdapter = CatsAdapter()
    private lateinit var binding:CatActivityMainBinding
    private lateinit var catViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CatActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvHelp.apply {
            layoutManager = GridLayoutManager(this@ActivityCat, 2)
            adapter = catsAdapter
        }
        catViewModel = ViewModelProvider(this).get(CatViewModel::class.java)


        catViewModel.moviePagedList?.observe(this,Observer{
            binding.rvHelp.apply {

                    catsAdapter.submitList(it)


            }
        })



    }
}