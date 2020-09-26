package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import co.id.egiwibowo.imovie.data.di.DaggerDataComponent
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.movie.R
import co.id.egiwibowo.imovie.movie.di.DaggerMovieComponent
import co.id.egiwibowo.imovie.movie.di.MovieComponentProvider
import kotlinx.android.synthetic.main.fragment_movie_details.*
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels {
        factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieDetailsViewModel.movieDetails.observe(viewLifecycleOwner, Observer { movieDetails ->
            if (movieDetails != null) {
                when (movieDetails) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> {
                        movieDetails.data?.let { showMovie(it) }
                    }
                    is Resource.Error -> {
                        showErrorPopularMovies()
                    }
                }
            }
        })

        movieDetailsViewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
//            showMovie(movie = movie)
        })
    }

    fun showLoading() {

    }

    fun showErrorPopularMovies() {

    }

    fun showMovie(movieDetails: MovieDetails) {
        Log.d("showMovie", movieDetails.toString())
        tv_vote.text = movieDetails.voteCount.toString() + " VOTES"
        tv_title.text = movieDetails.title
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as MovieComponentProvider).provideMovieComponent().inject(this)
    }
}