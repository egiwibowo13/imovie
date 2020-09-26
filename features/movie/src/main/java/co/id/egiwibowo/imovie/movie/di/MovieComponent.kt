package co.id.egiwibowo.imovie.movie.di

import co.id.egiwibowo.imovie.data.di.DataComponent
import co.id.egiwibowo.imovie.movie.presentation.movie_details.MovieDetailsFragment
import co.id.egiwibowo.imovie.movie.presentation.movies.MoviesFragment
import dagger.Component

@MovieScope
@Component(
    dependencies = [DataComponent::class],
    modules = [MovieModule::class, ViewModelModule::class]
)
interface MovieComponent {
    @Component.Factory
    interface Factory {
        fun create(dataComponent: DataComponent): MovieComponent
    }

    fun inject(fragment: MoviesFragment)
    fun inject(fragment: MovieDetailsFragment)
}