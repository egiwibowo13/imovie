package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.movie.R
import co.id.egiwibowo.imovie.movie.di.MovieComponentProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.about_film.view.*
import kotlinx.android.synthetic.main.fragment_movie_details.*
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels {
        factory
    }

    lateinit var genreAdapter: GenreAdapter
    lateinit var castAdapter: CastAdapeter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            var movieId = it.getInt("movieId", 0)
            movieDetailsViewModel.getMovieDetails(movieId)
        }

        setupGenreAdapter()
        setupCastAdapter()

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

    private fun setupGenreAdapter() {
        genreAdapter = GenreAdapter()
        with(rv_genre) {
            setHasFixedSize(true)
            adapter = genreAdapter
        }
    }

    private fun setupCastAdapter() {
        castAdapter = CastAdapeter()
        with(rv_actor) {
            setHasFixedSize(true)
            adapter = castAdapter
        }
    }

    fun showLoading() {

    }

    fun showErrorPopularMovies() {

    }

    fun showMovie(movieDetails: MovieDetails) {
        Log.d("showMovie", movieDetails.toString())
        tv_vote.text = movieDetails.voteCount.toString() + " VOTES"
        tv_title.text = movieDetails.title
        tv_description.text = movieDetails.overview
        tv_rating.text = movieDetails.voteAverage.toString()
        tv_year.text = movieDetails.year
        tv_time.text = movieDetails.runtime
        context?.let {
            Glide.with(it)
                .load("https://image.tmdb.org/t/p/w500"+movieDetails.backdropPath)
                .into(img_backdrop)
            Glide.with(it)
                .load("https://image.tmdb.org/t/p/w500"+movieDetails.posterPath)
                .into(include_about_film.img_poster)
        }
        genreAdapter.setData(movieDetails.genres)
        castAdapter.setData(movieDetails.casts)
        include_about_film.tv_original_title.text = movieDetails.originalTitle
        include_about_film.tv_status.text = movieDetails.status
        include_about_film.tv_budget.text = movieDetails.budget
        include_about_film.tv_revenue.text = movieDetails.revenue
        include_about_film.tv_release_date.text = movieDetails.releaseDate
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as MovieComponentProvider).provideMovieComponent().inject(this)
    }
}