package co.id.egiwibowo.imovie

import android.app.Application
import co.id.egiwibowo.imovie.abstraction.utils.AppExecutors_Factory.create
import co.id.egiwibowo.imovie.data.di.DaggerDataComponent
import co.id.egiwibowo.imovie.data.di.DataComponent
import co.id.egiwibowo.imovie.di.AppComponent
import co.id.egiwibowo.imovie.di.DaggerAppComponent
import co.id.egiwibowo.imovie.movie.di.DaggerMovieComponent
import co.id.egiwibowo.imovie.movie.di.MovieComponent
import co.id.egiwibowo.imovie.movie.di.MovieComponentProvider

open class MyApplication : Application(), MovieComponentProvider {

    private val dataComponent: DataComponent by lazy {
        DaggerDataComponent.factory().create(applicationContext)
    }

    override fun provideMovieComponent(): MovieComponent {
        return  DaggerMovieComponent.factory().create(dataComponent)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(dataComponent)
    }


}