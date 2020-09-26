package co.id.egiwibowo.imovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var factory: ViewModelFactory
//
//    private val mainViewModel: MainViewModel by viewModels {
//        factory
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel.popularMovies.observe(this, Observer { movies ->
//            if (movies != null) {
//                when (movies) {
//                    is Resource.Loading -> { }
//                    is Resource.Success -> {
//                       Log.d("popularMovies", movies.data.toString())
//                    }
//                    is Resource.Error -> {
//
//                    }
//                }
//            }
//        })

    }
}