package dominando.android.apihelpactivity.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.apihelpactivity.cats.viewModel.CatViewModel
import dominando.android.apihelpactivity.databinding.ActivityMainBinding
import dominando.android.apihelpactivity.databinding.CatActivityMainBinding

class ActivityCat : AppCompatActivity() {

    private lateinit var binding:CatActivityMainBinding
    private lateinit var catViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CatActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        catViewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        catViewModel.getCat()

        catViewModel.livedataCat.observe(this,Observer{lista->
            binding.rvHelp.apply {
                layoutManager = LinearLayoutManager(this@ActivityCat)
                adapter = CatsAdapter(lista)

            }
        })



    }
}