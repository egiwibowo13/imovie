package co.id.egiwibowo.imovie.data.di

import android.content.Context
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    fun provideRepository() : IMovieRepository
}