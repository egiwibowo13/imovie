package co.id.egiwibowo.imovie.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.egiwibowo.imovie.MyApplication
import co.id.egiwibowo.imovie.R
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import co.id.egiwibowo.imovie.domain.entities.Movie
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels {
        factory
    }

    lateinit var movieAdapter: MovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
//            val intent = Intent(activity, DetailTourismActivity::class.java)
//            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
//            startActivity(intent)
        }

        homeViewModel.popularMovies.observe(viewLifecycleOwner, Observer { movies ->
            if (movies != null) {
                when (movies) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> {
                        movies.data?.let { showPopularMovies(movies = it) }
                    }
                    is Resource.Error -> {
                        showErrorPopularMovies()
                    }
                }
            }
        })

        with(rv_popular_movies) {
//            layoutManager = LinearLayoutManager(context)
//            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
            setHasFixedSize(true)
            adapter = movieAdapter
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    private fun showLoading() {

    }

    private fun showPopularMovies(movies: List<Movie>) {
        Log.d("showPopularMovies", movies.toString())
        movieAdapter.setData(movies)
    }

    private fun showErrorPopularMovies() {

    }


}