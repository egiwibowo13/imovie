package co.id.egiwibowo.imovie.movie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelKey
import co.id.egiwibowo.imovie.movie.presentation.movie_details.MovieDetailsViewModel
import co.id.egiwibowo.imovie.movie.presentation.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @MovieScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    abstract fun bindMovieDetailsViewModel(viewModel: MovieDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(viewModel: MoviesViewModel): ViewModel
}